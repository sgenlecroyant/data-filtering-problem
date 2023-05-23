/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.builder;

import java.lang.reflect.Field;

/**
 * @author sgen
 *
 */
public class QueryBuilder {

	private int moveCursor;
	
	public static QueryBuilder builder() {
		return new QueryBuilder();
	}

	public QueryBuilder buildWith(StringBuffer query, int parameterPosition, Field field) {

		query.append(" (instance.").append(field.getName()).append(" != NULL AND ").append("instance." + field.getName())
				.append(" ILIKE ?" + (parameterPosition)).append(") OR ");
		parameterPosition++;
		moveCursor = parameterPosition;

		return this;
	}

	public int getLastParameterPosition() {
		return moveCursor;
	}

}
