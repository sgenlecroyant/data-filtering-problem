/**
 *
 */
package com.sgenlecroyant.problem.datafiltering.strategy.implementation;

import com.sgenlecroyant.problem.datafiltering.builder.QueryBuilder;
import com.sgenlecroyant.problem.datafiltering.strategy.EntityFilteringStrategy;
import com.sgenlecroyant.problem.datafiltering.strategy.parser.AsystNumericValueParserLibrary;
import com.sgenlecroyant.problem.datafiltering.util.QueryCleanUpUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * @author sgenlecroyant
 *
 */
@Service
public class DynamicEntityFilteringStrategy implements EntityFilteringStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <T> List<T> filterByAnyField(String inputValue, Class<T> entityClazz) {

        boolean isAnnotationPresent = entityClazz.isAnnotationPresent(Entity.class);

        if (!isAnnotationPresent) {
            throw new RuntimeException("This filtering strategy is supported only by entity classes");

        }

        // ca c'est important au cas ou on a donne un autre nom qui est different de la
        // classe
        Entity entityAnnotation = entityClazz.getDeclaredAnnotation(Entity.class);
        String entityTableName = null;
        if (entityAnnotation.name().isBlank()) {
            entityTableName = entityClazz.getTypeName();
        } else {
            entityTableName = entityAnnotation.name();
        }

        String queryString;

        // j'ai decide d'utiliser StringBuffer parce que StringBuffer est 'Thread-Safe'
        // si non, on pourrait faire le locking manuel si on allait utiliser le
        // StringBuilder
        StringBuffer query = new StringBuffer();

        query.append("SELECT instance FROM ").append(entityTableName).append(" instance WHERE ");

        Field[] dynamicFields = entityClazz.getDeclaredFields();

        boolean isParsable = AsystNumericValueParserLibrary.isParseable(inputValue);

        int parameterPosition = 1;
        for (Field field : dynamicFields) {
            field.setAccessible(true);

            if (isParsable) {
                parameterPosition = QueryBuilder.builder().buildWith(query, parameterPosition, field)
                        .getLastParameterPosition();

            } else {
                if (field.getType().equals(String.class)) {
                    parameterPosition = QueryBuilder.builder().buildWith(query, parameterPosition, field)
                            .getLastParameterPosition();
                }

            }

			field.setAccessible(false);

        }

        queryString = QueryCleanUpUtils.cleanUpQuery(query);

        // veuillons voir notre requete finale
        this.logger.info("Query: {}", queryString);

        Query selectCreatedQuery = this.entityManager.createQuery(queryString, entityClazz);

        for (int staticPosition = 1; staticPosition < parameterPosition; staticPosition++) {
            selectCreatedQuery.setParameter(staticPosition, inputValue);
            //TODO: check this exception in case the value is string numerical

            if (isParsable) {
                selectCreatedQuery.setParameter(staticPosition, inputValue);
                return Collections.emptyList();
            } else {
                selectCreatedQuery.setParameter(staticPosition, "%" + inputValue + "%");

            }

        }

        List<T> result = selectCreatedQuery.getResultList();

        return result;
    }


}
