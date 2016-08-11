package be.butskri.dzone.periodictable;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicElementCheckerSamplesTest {

    private PeriodicElementChecker checker = new PeriodicElementChecker();

    @Test
    public void testIsValidChemicalSymbol() {
        Assert.assertFalse(checker.isValidChemicalSymbol("Boron", "B"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Mercury", "Hg"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Mercury", "Cy"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Silver", "Vr"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Silver", "Rv"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Magnesium", "Ma"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Magnesium", "Am"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Xenon", "Nn"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Xenon", "Xx"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Xenon", "Oo"));

        Assert.assertTrue(checker.isValidChemicalSymbol("Spenglerium", "Ee"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Zeddemorium", "Zr"));
        Assert.assertTrue(checker.isValidChemicalSymbol("Venkmine", "Kn"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Stantzon", "Zt"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Melintzum", "Nn"));
        Assert.assertFalse(checker.isValidChemicalSymbol("Tullium", "Ty"));
    }

    @Test
    public void testFindFirstInAlphabeticalOrder() {
        Assert.assertEquals("Ei", checker.findFirstSymbolInAlphabeticalOrder("Gozerium"));
        Assert.assertEquals("Ie", checker.findFirstSymbolInAlphabeticalOrder("Slimyrine"));
    }

    @Test
    public void testCountNumberOfDistinctValidSymbols() {
        Assert.assertEquals(11, checker.countNumberOfDistinctValidSymbols("Zuulon"));
    }
}
