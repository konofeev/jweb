package controller;

import entity.Content;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import service.ContentService;

@Named
@RequestScoped
public class ContentController 
{
    @Inject
    private ContentService contentService;
    private Content content = new Content();

    @Inject
    private Logger logger;

    public String doCreateContent() 
    {
        logger.info("ContentController#doCreateContent(): name=" + content.getName());
        contentService.createContent(content);
        FacesContext.getCurrentInstance().addMessage
        (
            null,
            new FacesMessage
            (
                FacesMessage.SEVERITY_INFO,
                "Content created",
                "The content" + content.getName() + " has been created with id=" + content.getId()
            )
        );
        return "list.xhtml";
    }

    public void doFindContentById() 
    {
        content = contentService.findContentById(content.getId().longValue());
    }

    public Content getContent() 
    {
        return content;
    }

    public void setContent(Content content) 
    {
        logger.info("ContentController#setContent(): name=" + content.getName());
        this.content = content;
    }
}
