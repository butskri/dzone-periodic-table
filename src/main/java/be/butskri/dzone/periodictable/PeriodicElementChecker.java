package be.butskri.dzone.periodictable;

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
}
