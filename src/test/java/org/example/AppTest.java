package org.example;


import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.stream.Collectors;

public class AppTest

{
    private List<Character> stringToListOfChars(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }


    //Tests for pascal triangle
    @Test
    public void testTopOfTriangle() {
        Assert.assertEquals(App.pascal(0, 0), 1, "Top of the triangle should be 1");
    }


    @Test
    public void testMiddleOfTriangle() {
        Assert.assertEquals(App.pascal(1, 2), 2, "Middle of the triangle at row 2 should be 2");
    }

    @Test
    public void testLeftEdgeOfTriangle() {
        Assert.assertEquals(App.pascal(0, 5), 1, "Left edge of the triangle should be 1");
    }

    @Test
    public void testRightEdgeOfTriangle() {
        Assert.assertEquals(App.pascal(5, 5), 1, "Right edge of the triangle should be 1");
    }

    @Test
    public void testGeneralCase() {
        Assert.assertEquals(App.pascal(2, 4), 6, "General case at row 4, column 2 should be 6");
    }

    @Test
    public void testDiagonalCase() {
        Assert.assertEquals(App.pascal(3, 3), 1, "Diagonal case where column equals row should be 1");
    }


    @Test
    public void testFirstRow() {
        Assert.assertEquals(App.pascal(0, 0), 1, "First row should be 1");
    }

    @Test
    public void testFirstColumn() {
        Assert.assertEquals(App.pascal(0, 5), 1, "First column should always be 1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeRow() {
        App.pascal(0, -1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeColumn() {
        App.pascal(-1, 0);
    }


    /////Tests for balance function
    @Test
    public void testBalancedParentheses1() {
        List<Character> test1 = stringToListOfChars("(if (zero? x) max (/ 1 x))");
        Assert.assertTrue(App.balance(test1),
                "The string '(if (zero? x) max (/ 1 x))' should be balanced.");
    }

    @Test
    public void testBalancedParentheses2() {
        List<Character> test2 = stringToListOfChars("I told him (that it’s not (yet) done). (But he wasn’t listening)");
        Assert.assertTrue(App.balance(test2),
                "The string 'I told him (that it’s not (yet) done). (But he wasn’t listening)' should be balanced.");
    }

    @Test
    public void testUnbalancedParentheses1() {
        List<Character> test3 = stringToListOfChars(":-)");
        Assert.assertFalse(App.balance(test3),
                "The string ':-)' should be unbalanced.");
    }

    @Test
    public void testUnbalancedParentheses2() {
        List<Character> test4 = stringToListOfChars("())(");
        Assert.assertFalse(App.balance(test4),
                "The string '())(' should be unbalanced.");
    }

    @Test
    public void testEmptyString() {
        List<Character> test = stringToListOfChars("");
        Assert.assertTrue(App.balance(test),
                "An empty string should be balanced.");
    }

    @Test
    public void testSingleOpenParenthesis() {
        List<Character> test = stringToListOfChars("(");
        Assert.assertFalse(App.balance(test),
                "A single open parenthesis should be unbalanced.");
    }


    @Test
    public void testNestedParentheses() {
        List<Character> test = stringToListOfChars("((()))");
        Assert.assertTrue(App.balance(test),
                "Nested parentheses should be balanced.");
    }

    @Test
    public void testNonParenthesisCharacters() {
        List<Character> test = stringToListOfChars("abcde");
        Assert.assertTrue(App.balance(test),
                "String with no parentheses should be balanced.");
    }
}
