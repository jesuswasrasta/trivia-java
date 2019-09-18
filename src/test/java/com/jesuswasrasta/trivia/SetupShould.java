package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetupShould {

    @Test
    public void whenAGameIsCreatedNothingHappens() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game();

        assertEquals("", stream.toString());
    }
}
