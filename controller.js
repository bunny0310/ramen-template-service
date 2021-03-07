const {Template} = require('./models/template');

const getTemplates = async (id) => {
        const templates = await Template.find({"_id": id});
        return templates;
}

const insertTemplate = async (body) => {
        const template = new Template({'template': body.template, 'alias': body.alias, 'userId': body.userId});
        template.save();
        return template;
};

module.exports = {getTemplates, insertTemplate};