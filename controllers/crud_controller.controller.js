const fs = require('fs')
const path = './data/data.json';
const url = require('url');

let data = JSON.parse(fs.readFileSync(path, 'utf8'))

exports.create = function (req, res) {
    let new_city = req.url.split('/')[1];
    if (new_city === '') {
        res.send('Empty name of the city - try again');
    } else {
        data.cities.push(new_city);
        fs.writeFileSync(path, JSON.stringify(data));
        res.send('City added: ' + new_city);
    }
}

exports.read = function (req, res) {
    let size = Object.keys(data.cities).length;
    let output = 'All cities: ';
    for (let i = 0; i < size; i++) {
        output += data.cities[i];
        if (i != size - 1) {
            output += ', ';
        }
    }
    output += '<br>';
    res.send(output);
}


exports.update = function (req, res) {
    let new_city = req.url.split('/')[1];
    data.cities[0] = new_city;
    fs.writeFileSync(path, JSON.stringify(data));
    res.send('First city replaced: ' + new_city);
}

exports.delete = function (req, res) {
    let size = Object.keys(data.cities).length;
    let id = parseInt(req.url.split('/')[1]);
    if (!Number.isSafeInteger(id) || id < 0 || id >= size) {
        res.send('Incorrect id - try again' + id);
    } else {
        data.cities.splice(id, 1);
        fs.writeFileSync(path, JSON.stringify(data));
        res.send('City with id ' + id + 'deleted');
    }
}