package com.jesuswasrasta.trivia;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Custom assertion for text lines.
 * Just a dumb trick to avoid line endings test failures... 😅
 */
public class StringAssertions {
    public static void assertLinesEqual(String expectedString, String actualString){
        BufferedReader expectedLinesReader = new BufferedReader(new StringReader(expectedString));
        BufferedReader actualLinesReader = new BufferedReader(new StringReader(actualString));

        try {
            int lineNumber = 0;

            String actualLine;
            while((actualLine = actualLinesReader.readLine()) != null){
                String expectedLine = expectedLinesReader.readLine();
                Assert.assertEquals("Line " + lineNumber, expectedLine, actualLine);
                lineNumber++;
            }

            if(expectedLinesReader.readLine() != null){
                Assert.fail("Actual string does not contain all expected lines");
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        } finally {
            try {
                expectedLinesReader.close();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            try {
                actualLinesReader.close();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
    }
}
