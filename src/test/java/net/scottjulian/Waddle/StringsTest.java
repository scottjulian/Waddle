package net.scottjulian.Waddle;


import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void testShortestPalindrome(){
        assertEquals(Strings.getShortestPalindrome("abcd"), "dcbabcd");
        assertEquals(Strings.getShortestPalindrome("aacecaaa"), "aaacecaaa");
    }

    @Test
    public void testAnagramPalindrome(){
        assertTrue(Strings.isAnagramPalindrome("racecar"));
        assertTrue(Strings.isAnagramPalindrome("rabacorcaobatsst"));
        assertFalse(Strings.isAnagramPalindrome("notapalindrome"));
    }

}
