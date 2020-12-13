package com.cb.templateService.database.models;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class Template extends BaseEntity {
    private Integer userId;
    private String template;

    public Template() {

    }

    public Template(int id, Timestamp createdAt, Timestamp updatedAt, int userId, String alias, String template) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.template = template;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
