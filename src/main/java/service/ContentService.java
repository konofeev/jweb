package service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Content;

/**
 * Сервис работы с контентом
 */
@Named("content")
@RequestScoped
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

    public Content save(Content content)
    {
        return null;
    }
}
