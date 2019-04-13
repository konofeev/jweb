package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Content;
import service.ContentService;

@Named
@RequestScoped
public class ContentController
{
    @Inject
    private ContentService contentService;
    private Content content = new Content();

    public String doCreateContent()
    {
        contentService.create(content);
        return "create.xhtml";
    }
}