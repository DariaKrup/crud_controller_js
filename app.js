// app.js
const express = require('express');
const bodyParser = require('body-parser');

const controller = require('./controllers/crud_controller.controller');// Imports routes for the products
const app = express();

app.use("/create", controller.create);
app.use("/read", controller.read);
app.use("/update", controller.update);
app.use("/delete", controller.delete);

let port = 1234;
app.listen(port, () => {
    console.log('Server is up and running on port number ' + port);
});
