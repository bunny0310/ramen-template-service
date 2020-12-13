package com.cb.templateService.database.templates;

import com.cb.templateService.database.models.Template;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TemplateMapper implements ResultSetMapper<Template> {
    @Override
    public Template map(int index, ResultSet r, StatementContext ctx) throws SQLException {

        Template template = new Template(
                r.getInt("id"),
                r.getTimestamp("createdAt"),
                r.getTimestamp("updatedAt"),
                r.getInt("userId"),
                r.getString("alias"),
                r.getString("template")
        );

        return template;
    }
}
