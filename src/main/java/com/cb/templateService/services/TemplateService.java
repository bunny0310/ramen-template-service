package com.cb.templateService.services;

import com.cb.templateService.database.DAO.TemplatesDAO;
import com.cb.templateService.database.models.Template;

import java.util.List;

public class TemplateService {
    private TemplatesDAO templatesDAO;
    public TemplateService(TemplatesDAO templatesDAO) {
        this.templatesDAO = templatesDAO;
    }
    public List<Template> getUserTemplates(int userId) {
        return this.templatesDAO.getUserTemplates(userId);
    }

    public void insertTemplate(Template template) {
        this.templatesDAO.insertTemplate(template);
    }
}
