const path = require("path");
const { readFileUtil, writeFileUtil } = require("../utils/dataWrite");
const uploadFile = path.join(__dirname,"..","database","filedata.json")
const readFileData = () => {
    try {
        const parsedJson = readFileUtil(uploadFile);
        return parsedJson;

    } catch (err) {
        console.log(err);
        return;
    }
};

const writeFileData = (arr) => {
    try {
        writeFileUtil(arr, uploadFile);
        return;
    } catch (err){
        console.log(err);
        return;
    }
};

module.exports = { writeFileData , readFileData };