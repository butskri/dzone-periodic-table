package be.butskri.dzone.periodictable;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicElementCheckerTest {

    private PeriodicElementChecker checker = new PeriodicElementChecker();

    @Test
    public void symbolCannotHaveMoreThanTwoCharacters() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Abc"));
    }

    @Test
    public void symbolCannotHaveLessThanTwoCharacters() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "A"));
    }

    @Test
    public void symbolIsValidWhenStartsWithCapitalAndBothLettersAreInOrderInTheElementName() {
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Ab"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Ac"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Ad"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Bc"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Bd"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcd", "Cd"));
    }

    @Test
    public void symbolIsNotValidWhenCharactersOfElementNotInCorrectOrder() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Ba"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Ca"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Da"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Cb"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Db"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Dc"));
    }

    @Test
    public void symbolIsNotValidWhenAtLeastOneCharacterNotInElementName() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Ae"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "Eb"));
    }

    @Test
    public void symbolIsNotValidWhenInvalidCharacterInSymbol() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd-", "A-"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "A-"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "A1"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd-", "A-"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "-b"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", ".."));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", ".*"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "*."));
    }

    @Test
    public void elementNameContainingNonAlphatbeticCharacterIsInvalid() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd-", "Ab"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Ab-cd", "Ab"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Ab1cd", "Ab"));
    }

    @Test
    public void nullIsNotAValidElementname() {
        Assert.assertFalse(checker.isValidChemicalSymbol(null, "Ab"));
    }

    @Test
    public void nullIsNotAValidSymbol() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", null));
    }

    @Test
    public void elementnameOfTwoLettersIsValid() {
        Assert.assertTrue(checker.isValidChemicalSymbol("Ab", "Ab"));
    }

    @Test
    public void elementnameMustStartWithCapital() {
        Assert.assertFalse(checker.isValidChemicalSymbol("abcd", "Ab"));
    }

    @Test
    public void symbolMustStartWithCapital() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcd", "ab"));
    }

    @Test
    public void symbolWithDuplicateCharacterOnlyValidWhenElementnameContainsCharacterTwice() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcdc", "Aa"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcdc", "Bb"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Abcdc", "Cc"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Abcdc", "Dd"));
    }

    @Test
    public void canFindFirstInAlphabeticalOrder() {
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Abcd"));
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Acbd"));
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Acdb"));
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Cabd"));
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Cadb"));
        Assert.assertEquals("Ab", checker.findFirstSymbolInAlphabeticalOrder("Cdab"));

        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Aabc"));
        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Abac"));
        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Abca"));
        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Baac"));
        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Baca"));
        Assert.assertEquals("Aa", checker.findFirstSymbolInAlphabeticalOrder("Bcaa"));
    }

    @Test
    public void canCountNumberOfDistinctValidSymbols() {
        Assert.assertEquals(6, checker.countNumberOfDistinctValidSymbols("Abcd"));
        Assert.assertEquals(4, checker.countNumberOfDistinctValidSymbols("Baac"));
        Assert.assertEquals(11, checker.countNumberOfDistinctValidSymbols("Zuulon"));
    }

}
