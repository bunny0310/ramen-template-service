package com.cb.templateService.database.DAO;

import com.cb.templateService.database.models.Template;
import com.cb.templateService.database.templates.TemplateMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TemplateMapper.class)
public interface TemplatesDAO {

    @SqlQuery("SELECT * FROM templates WHERE userId = :id")
    public List<Template> getUserTemplates(@Bind("id") final int id);

    @SqlUpdate("INSERT INTO templates (userId, alias, template) VALUES (:userId, :alias, :template)")
    public void insertTemplate(@BindBean Template template);

}
