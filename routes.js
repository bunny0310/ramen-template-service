const express = require("express");
const router = express.Router();
const {getTemplates, insertTemplate} = require('./controller');
const auth = require('./middleware');

router.get('/list/:userId', auth, (req, res) => {
    getTemplates(req.params['userId'])
    .then((data) => {
        return res.status(200).json({'data': data});
    })
    .catch((err) => {
        return res.status(500).json({'data': null, 'msg': "Error: " + err});
    });
})

router.post('/insert', (req, res) => {
    const body = req.body;
    const keys = Object.keys(body);
    if(keys.indexOf('userId') === -1 || keys.indexOf('alias') === -1 || keys.indexOf('template') === -1) {
        return res.status(400).json({"data": null, "msg": "incorrect format, fields missing"});
    }

    insertTemplate(body)
    .then((data) => {
        return res.status(200).json({"data": data, "msg": "Template inserted successfully"});
    })
    .catch((err) => {
        return res.status(500).json({'data': null, 'msg': "Error: " + err});
    })
});

module.exports = router;