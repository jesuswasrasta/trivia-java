package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Before;
import org.junit.Test;

@UseReporter(JunitReporter.class)
public class ApprovalTest {
    private ByteArrayOutputStream stream;

    @Before
    public void beforeEach(){
        stream = getOutputStream();
    }

    @Test
//    @UseReporter(JunitReporter.class) //Don't need to specify it here, as it is specified as default class reporter
    public void gameTestWithJUnitReporter() {
        //Hint: run the test, see it failing in console, rename `received` file in `approved` by hand
        Random random = new Random(0);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);
        Approvals.verify(stream.toString());
    }

    @Test
    @UseReporter(DiffReporter.class)
    public void gameTestWithDiffReporter() {
        // Directions:
        // You will need to have a diff reporter installed on you system to do this.
        // 1) Run the test
        // 2) Right click the result in your diff tool and select use whole file.
        /*
         * Currently supported Diff Tools are
         * Mac:
         * DiffMerge
         * TkDiff
         * Kaleidoscope
         *
         * Windows:
         * BeyondCompare
         * TortoiseDiff
         * WinMerge
         */
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
