const path = require("path");
const { readImageUtil, writeImageUtil } = require("../function/dataWrite");
const uploadFile = path.join(__dirname,"..","database","filedata.json")

const readImageData = () => {
    try {
        const parsedJson = readImageUtil(uploadFile);
        return parsedJson;

    } catch (err) {
        console.log(err);
        return;
    }
};

const writeImageData = (arr) => {
    try {
        writeImageUtil(arr, uploadFile);
        return;
    } catch (err){
        console.log(err);
        return;
    }
};

module.exports = { writeImageData , readImageData };