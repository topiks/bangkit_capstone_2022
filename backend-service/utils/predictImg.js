const { input } = require("@tensorflow/tfjs-node");
const tf = require ("@tensorflow/tfjs-node")
const Jimp = require("jimp")



const processImg = (image) => {
    image.resize(100,100);
    const value = image.bitmap.data;
    const outShape = [1, image.bitmap.width, image.bitmap.height, 4];
    let input = tf.tensor4d(value, outShape, "float32")

    input = input.slice(
        [0,0,0,0],
        [1, image.bitmap.width, image.bitmap.height, 3]
    );
    return input
};

const loadImage = async (filename) => {
    try{
        const image = await Jimp.read(filename);
        return processImg(image);
    } catch (err){
        console.log(err)
    }
};

const getImage = async (filename) => {
    try{
        this.image = await loadImage(filename);

    } catch(err){
        console.log("error loading the image", err);
    }
    return this.image;
} 

module.exports = { getImage }
