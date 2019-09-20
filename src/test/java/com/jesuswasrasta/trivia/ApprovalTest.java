package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApprovalTest {
    private ByteArrayOutputStream stream;

    @BeforeEach
    void beforeEach(){
        stream = getOutputStream();
    }

    @Test
    void gameTest() {
        Random random = new Random(0);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);
        Approvals.verify(stream.toString());
    }


    private ByteArrayOutputStream getOutputStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
