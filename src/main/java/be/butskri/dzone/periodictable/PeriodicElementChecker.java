package be.butskri.dzone.periodictable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PeriodicElementChecker {

    private static final Pattern ELEMENT_NAME_PATTERN = Pattern.compile("[A-Z][a-z]+");
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("[A-Z][a-z]");

    public boolean isValidChemicalSymbol(String elementName, String symbol) {
        if (!isValidElementName(elementName)) {
            return false;
        }
        if (!isValidSymbol(symbol)) {
            return false;
        }
        return areBothCharactersOfSymbolInElementName(elementName, symbol);
    }

    private boolean isValidElementName(String elementName) {
        if (elementName == null) {
            return false;
        }
        return ELEMENT_NAME_PATTERN.matcher(elementName).matches();
    }

    private boolean isValidSymbol(String symbol) {
        if (symbol == null) {
            return false;
        }
        return SYMBOL_PATTERN.matcher(symbol).matches();
    }

    private boolean areBothCharactersOfSymbolInElementName(String elementName, String symbol) {
        String elementNameInLowerCase = elementName.toLowerCase();
        return elementNameInLowerCase.matches(regExpContainingBothCharactersInOrder(symbol.toLowerCase()));
    }

    private String regExpContainingBothCharactersInOrder(String symbolInLowerCase) {
        return ".*" + symbolInLowerCase.charAt(0) + ".*" + symbolInLowerCase.charAt(1) + ".*";
    }

    public String findFirstSymbolInAlphabeticalOrder(String elementName) {
        if (!isValidElementName(elementName)) {
            throw new IllegalArgumentException("invalid elementName: " + elementName);
        }
        return determineAllPossibleDistinctSymbolsFor(elementName).first();
    }

    public int countNumberOfDistinctValidSymbols(String elementName) {
        if (!isValidElementName(elementName)) {
            throw new IllegalArgumentException("invalid elementName: " + elementName);
        }
        return determineAllPossibleDistinctSymbolsFor(elementName).size();
    }

    private SortedSet<String> determineAllPossibleDistinctSymbolsFor(String elementName) {
        SortedSet<String> result = new TreeSet<String>();
        for (int i=0;i < elementName.length() - 1;i++) {
            String firstCharacterInUppercase = elementName.substring(i, i+1).toUpperCase();
            result.addAll(allCombinationsOf(firstCharacterInUppercase, elementName.substring(i + 1)));
        }
        return result;
    }

    private Collection<? extends String> allCombinationsOf(String firstCharacterInUpperCase, String charactersToBeCombined) {
        Set<String> allCombinations = new HashSet<String>();
        for (int i=0;i < charactersToBeCombined.length();i++) {
            allCombinations.add(firstCharacterInUpperCase + charactersToBeCombined.charAt(i));
        }
        return allCombinations;
    }

}
