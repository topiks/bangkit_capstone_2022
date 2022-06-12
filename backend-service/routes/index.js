const express = require("express");
const router = express.Router();
const getIndexHandler = require("../handlerImg/indexHandler");

router.get("/", getIndexHandler);

module.exports = router;