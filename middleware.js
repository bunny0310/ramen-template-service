const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
    
    try {
        if(Object.keys(req.headers).indexOf('authorization') === -1) {
            throw "Header not found";
        } 
        const token = req.headers.authorization.split(' ')[1];
        jwt.verify(token, 'secret123', (err, token) => {
            if(err) {
                throw err;
            }
            next();
        });
    }catch(err) {
        return res.status(401).json({"msg": "Auth failed " + err});
    }
}
