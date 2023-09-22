package com.jesuswasrasta.trivia.approvals;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

@UseReporter(JunitReporter.class)
public class GameRunnerApprovalTests {
    private ByteArrayOutputStream stream;

    @Before
    public void beforeEach(){
        stream = getOutputStream();
    }

    @Test
    @UseReporter(DiffReporter.class)
    public void GameRunnerTestWithSeed0() {
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
