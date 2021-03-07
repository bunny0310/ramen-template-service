const {mongoose_connection} = require("../config");

const mongoose = mongoose_connection();

const schema = new mongoose.Schema({
    userId: {type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true},
    template: {type: String, required: true},
    alias: {type: String, required: true},
    createdAt: {type: Date, default: Date.now()},
    updatedAt: {type: Date, default: Date.now()},
})

const Template = new mongoose.model('Template', schema);

module.exports = {Template}