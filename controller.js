const {Template} = require('./models/template');

const getTemplates = async (id) => {
        const templates = await Template.find({"userId": id});
        return templates;
}

const insertTemplate = async (body) => {
        const template = new Template({'template': body.template, 'alias': body.alias, 'userId': body.userId});
        await template.save();
        return template;
};

module.exports = {getTemplates, insertTemplate};