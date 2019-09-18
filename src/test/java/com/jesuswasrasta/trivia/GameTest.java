package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    ByteArrayOutputStream stream;

    @BeforeEach
    void beforeEach(){
        stream = getOutputStream();
    }

    @Test
    void whenAGameIsCreatedNothingHappens() {
        Game game = new Game();

        assertEquals("", stream.toString());
    }

    @Test
    void whenAddPlayerNameAndNumberArePrinted() {
        Game game = new Game();
        game.add("Nando");

        assertEquals(String.format("Nando was added%1$sThey are player number 1%1$s", System.getProperty("line.separator")), stream.toString());
    }

    @Test
    void name() {
        GameRunner gameRunner = new GameRunner();
        gameRunner.main(new String[0]);

        assertEquals("", stream.toString());
    }


    private ByteArrayOutputStream getOutputStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
