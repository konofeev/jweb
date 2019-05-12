package service;

import entity.Content;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Сервис работы с контентом
 */
@Named
@Stateless
public class ContentService
{
    @PersistenceContext(unitName="jweb")
    EntityManager entityManager;

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

    public Content createContent(Content content)
    {
        entityManager.persist(content);
        return content;
    }

    public Content findContentById(Long id)
    {
        return entityManager.find(Content.class, id);
    }
}
