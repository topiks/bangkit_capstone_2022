const fs = require("fs");

const readImageUtil = (filepath) => {
    try {
        const jsonString = fs.readFileSync(filepath, "utf8");
        const parsedJson = JSON.parse(jsonString);
        if (!parsedJson) {
            const object = {};
            writeImageUtil(object, filepath);
            
        }
        console.log("read success");
        
        return parsedJson;
    } catch (err){
        console.log(err);
        return;
    }
};

const writeImageUtil = (arr, filepath) =>{
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

module.exports = { readImageUtil, writeImageUtil };