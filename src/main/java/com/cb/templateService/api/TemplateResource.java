package com.cb.templateService.api;

import com.cb.templateService.cache.LRUCache;
import com.cb.templateService.database.models.Template;
import com.cb.templateService.services.TemplateService;
import org.skife.jdbi.v2.sqlobject.BindBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/templates")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Produces(MediaType.APPLICATION_JSON)
public class TemplateResource {
    private LRUCache<String, String> cache = new LRUCache<String, String>(10);
    private TemplateService templateService;

    public TemplateResource(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GET()
    @Path("/list/{userId}")
    public Response getUserTemplates(@PathParam("userId") final int userId) {
        List<Template> templates = this.templateService.getUserTemplates(userId);
        return Response.status(200).entity(templates).build();
    }

    @POST()
    @Path("/insert")
    public Response insertTemplate(Template template) {
        if(template.getUserId() == null) {
            return Response.status(422).entity("User id required").build();
        }
        this.templateService.insertTemplate(template);
        return Response.status(200).entity("Template inserted").build();
    }
}