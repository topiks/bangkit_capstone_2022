const fs = require("fs");

const readFileUtil = (filepath) => {
    try {
        const jsonString = fs.readFileSync(filepath, "utf8");
        const parsedJson = JSON.parse(jsonString);
        if (!parsedJson) {
            const object = {};
            writeFileUtil(object, filepath);
            // console.log ('new JSON Initialized);
        }
        console.log("read success");
        // console.log(parsedjson);
        return parsedJson;
    } catch (err){
        console.log(err);
        return;
    }
};

const writeFileUtil = (arr, filepath) =>{
    try {
        const jsonString = JSON.stringify(arr);
        fs.writeFileSync(filepath, jsonString);
        console.log("write completed");
        return;

    } catch (err) {
        console.log(err);
        return;
    }
};

module.exports = { readFileUtil, writeFileUtil };