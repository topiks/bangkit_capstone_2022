const domain = process.env.DOMAIN || "backend-richest.et.r.appspot.com";
const hostname = process.env.NODE_ENV !== "production" ? "localhost": domain;

module.exports = hostname;