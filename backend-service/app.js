const express = require("express");
const logger = require("morgan");
const app = express();
const bodyParser = require("body-parser")
const cors = require("cors");
const port = process.env.PORT || 8080;
const indexRouter = require("./routes/index");
const uploadRouter = require("./routes/upload");


app.use(cors());
app.use(logger("dev"));
app.use(bodyParser.urlencoded({extended: true}))
app.use(express.json({ limit: "100mb" }));
app.use(express.urlencoded({ limit: "100mb", extended: true}));

app.use("/", indexRouter);
app.use("/upload", uploadRouter);


app.listen(port, _ => {
    console.log(`App Deploy at port ${port}`);
})

