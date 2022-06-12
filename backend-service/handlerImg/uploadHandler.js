const tf = require("@tensorflow/tfjs-node");
const { getImage } = require("../function/predictImg")
const { writeImageData, readImageData } = require("../datahandlerImg/upload");
const path = require("path");


let labels = [];
let predictions = null;
let ricemodel = null;

const { labelrice } = require("../function/labels");

const argMax = (array) => {
    return [].reduce.call(array, (m,c,i,arr)=> (c > arr[m] ? i : m), 0);
};

let uploadfiles = {
    files: []
}



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

       
        const clientImg = await getImage(
            path.join(__dirname, "..", "img", model, filename)
        );
        if (model === "rice"){
            predictions = await ricemodel.predict(clientImg).dataSync();
        }

    

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
            disease: disease,
            prediction: (prediction * 100).toFixed(3),
        };
        uploadfiles.files.push(newFile);
        writeImageData(uploadfiles);

        
        return res.status(200).json({
            status: "success",
            filename: filename,
            model:model,
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



const getUploadHandler = async (req, res) =>{
    try{
        uploadfiles = readImageData();
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

module.exports = {
    getUploadHandler, 
    addImgUploadHandler,
}

