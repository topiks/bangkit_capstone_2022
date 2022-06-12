const res = require("express/lib/response");

const getIndexHandler = async (req, res) =>{
    try {
        const { name = "Manda", place = "Backend Service Richest" } = req.query;
        console.log(`Selamat Datang ${name} di dalam ${place}`);
        return res.status(200).json({
            status: "success",
            message: `Selamat Datang ${name} di dalam ${place}`,
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
        message: "internal server execption",
    });
};

module.exports = getIndexHandler;