/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.util;

/**
 * @author sgen
 *
 */
public class QueryCleanUpUtils {

	// l'operation delete est: indexe debut inclusif et index fin exclusif
	
	public static String cleanUpQuery(StringBuffer query) {
		return query
				.delete(query.length() - (4), query.length() - 1)
				.append("") /*
							 * remplacer la valeur blank <<"">> par <<";">> c'est important si la requete
							 * SQL que tu veux au final est une requete native pour les RDBs comme MySQL,
							 * PostgreSQL, SQL Server, ... and so on and so forth
							 */
				.toString();
	}

}
