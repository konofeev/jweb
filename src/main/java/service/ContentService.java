package service;

import entity.Content;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    @Inject
    private Logger logger;

    @PersistenceContext(unitName="jweb")
    EntityManager entityManager;

    /**
     * Получить список контента
     *
     * @return Список контента
     */
    public List<Content> getContentList()
    {
        logger.info("Получение списка контента");
        return entityManager.createNamedQuery
        (
            "getAllContent",
            Content.class
        ).getResultList();
    }

    public Content createContent(Content content)
    {
        logger.info("Создание контента: " + content);
        entityManager.persist(content);
        return content;
    }

    public Content findContentById(Long id)
    {
        logger.info("Получение контента. Идентификатор: " + id);
        return entityManager.find(Content.class, id);
    }
    
    public void remove(Content content)
    {
        logger.info("Удаление контента. Идентификатор: " + content.getId());
        entityManager.remove(content);
    }
}
