package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetupShould {

    @Test
    void whenAGameIsCreatedNothingHappens() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game();

        assertEquals("", stream.toString());
    }

    @Test
    void whenAddPlayerNameAndNumberArePrinted() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game();
        game.add("Nando");

        assertEquals(String.format("Nando was added%1$sThey are player number 1%1$s", System.getProperty("line.separator")), stream.toString());
    }
}
