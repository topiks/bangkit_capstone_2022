const tf = require("@tensorflow/tfjs-node");
const { getImage } = require("../utils/predictImg")
const { readFileData, writeFileData } = require("../datahandler/upload");
const path = require("path");
const hostname = require("../utils/localhost");

const fs = require("fs")
let labels = [];
let predictions = null;
let ricemodel = null;

const { labelrice } = require("../utils/labels");

const argMax = (array) => {
    return [].reduce.call(array, (m,c,i,arr)=> (c > arr[m] ? i : m), 0);
};

let uploadfiles = {
    files: []
}

const getUploadHandler = async (req, res) =>{
    try{
        uploadfiles =readFileData();
        let files = null;
        const { model } = req.query;
        if (model) {
            files =uploadfiles.files.filter(
                (b) => b.model.toLowerCase().indexOf(model.toLowerCase())
                !== -1
            );
        } else {
            files = uploadfiles.files;
        }
        return res.status(200).json({
            status: "Success",
            data: {
                files,
            },
        });
    } catch (e) {
        console.log(e);
        return res.status(400).json({
            status: "fail",
            message: e.message,
        });
    }
    return res.status(500).json({
        status: "failed",
        message: "Internal server expection",
    });
};

const addImgUploadHandler = async (req, res) => {
    try {
        const { filename, mimetype } = req.file
        const model = req.query.model;

        if (!model) {
            throw Error("Model Not found");
        }
        if (req.rval) {
            throw Error(req.rval);
        }

        if (model === "rice"){
            if (!ricemodel){
                ricemodel = await tf.loadLayersModel("file://" + path.join(__dirname, "..", "models", "model.json" ));
            }
            labels = labelrice;
        }else {
            throw Error("Model is not found");
        }

        //image prediction
        const clientImg = await getImage(
            path.join(__dirname, "..", "client-img", model, filename)
        );
        if (model === "rice"){
            predictions = await ricemodel.predict(clientImg).dataSync();
        }

        //predict

        const prediction = Math.max(...predictions);
        console.log("Hasil Prediksi: ");
        console.log(predictions);
        let disease = labels[argMax(predictions)];
        if (!disease){
            disease = "undefined";
        }



    

        const newFile = {
            filename: filename,
            mimetype: mimetype,
            model: model,
            url: "https://" + hostname + "/download/" + model +"/"+ filename,
            disease: disease,
            prediction: (prediction * 100).toFixed(3),
        };
        uploadfiles.files.push(newFile);
        writeFileData(uploadfiles);

        
        return res.status(200).json({
            status: "success",
            filename: filename,
            model:model,
            url:  "https://" + hostname + "/download/" + model + "/" + filename, 
            disease: disease,
            prediction: (prediction * 100 ).toFixed(3),
            message: `masuk POST Service`,
        });
    } catch (e){
        console.log(e);
        return res.status(400).json({
            status: "fail",
            message: e.message,
        });
    }
    return res.status(500).json({
        status: "failed",
        message: "Internal Server execption"
    });
};

const deleteImgUploadHandler = async (req, res) => {
    try {
        const model = req.query.model;
        if (!model){
            throw Error("model name required");
        }
        const directory = path.join(__dirname, "..", "client-img", model);
        fs.readdir(directory, (err,files)=>{
            if (err) throw Error("Image has been deleted");
            for (const file of files) {
                if (file === ".gitkeep") continue;
                fs.unlink(path.join(directory, file), (err) =>{
                    if (err) throw Error("Files has been deleted");
                });
            }
        });
        const index = uploadfiles.files.filter((n) => n.model === model)[0];
        if (index === undefined) throw Error("Files has been deleted");
        for (let i = 0; i< uploadfiles.files.length; i++) {
            if (uploadfiles.files[i].model === model){
                uploadfiles.files.splice(i,1);
                i--;
            }
        }
        console.log("data cleared!")
        writeFileData(uploadfiles)
        return res.status(200).json({
            status: "Success",
            message: model + "data deleted",
        });
    } catch (e){
        console.log(e);
        return res.status(400).json({
            status: "fail",
            message: e.message,
        });
    }
    return res.status(500).json({
        status: "failed",
        message: "Internal Server execption"
    });
};

module.exports = {
    getUploadHandler,
    addImgUploadHandler,
    deleteImgUploadHandler,
}

