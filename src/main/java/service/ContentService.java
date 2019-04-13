package service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import entity.Content;

/**
 * Сервис работы с контентом
 */
@Named("content")
@Stateless
public class ContentService
{
    @PersistenceContext(unitName="junit")
    EntityManager entityManager;

    private Content content;

    public ContentService()
    {
        content = new Content();
    }

    /**
     * Получить список контента
     *
     * @return Список контента
     */
    public List<Content> getContentList()
    {
        return entityManager.createNamedQuery
        (
            "getAllContent",
            Content.class
        ).getResultList();
    }

    public Content save(Content content)
    {
        return null;
    }

    public void create()
    {
        entityManager.persist(content);
    }

    public void setName(String name)
    {
        this.content.setName(name);
    }

    public void setContent(String content)
    {
        this.content.setContent(content);
    }

    public String getName()
    {
        return content.getName();
    }

    public String getContent()
    {
        return content.getContent();
    }
}
