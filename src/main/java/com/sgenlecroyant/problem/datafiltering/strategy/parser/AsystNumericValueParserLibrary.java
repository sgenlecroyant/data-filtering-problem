/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.strategy.parser;

/**
 * @author sgen
 *
 */
public class AsystNumericValueParserLibrary {

	// juste un trique pour resourdre le probleme de Coercion
	/** explication:
	 * 		La valeur string: "2000" est literalement egale a une valeur numerique 2000
	 * 		mais jamais en aucun cas, la valeur string mixte comme ceci:
	 * 			
	 * 			"2020x2020Wq" aura sa valeur numerique equivalente  a cause de ces caracteres
	*/
	public static boolean isParseable(String value) {

		try {
			double parsedValue = Double.parseDouble(value);
			return true;
		} catch (Exception exception) {
			// juste retourne false, car c'est une exception attendue;
			return false;
		}
	}
}
