package com.jesuswasrasta.trivia.approvals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.Before;
import org.junit.Test;

@UseReporter(JunitReporter.class)
public class ApprovalTestExamples {
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
    @UseReporter(QuietReporter.class)
    public void gameTestWithQuietReporter() {
        // Directions:
        // 1) Run the test
        // 2) Manually rename The .received. File to .approved.
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

    @Test
    @UseReporter(ClipboardReporter.class)
    public void gameTestWithClipboardReporter() {
        // The ClipboardReporter copies to the clipboard the `move` command you need to run to rename `received` file to `approved` one.
        //
        // Directions:
        // 1) Run the test
        // 2) Then open a command line (terminal), and paste the move command from your clipboard
        Random random = new Random(0);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);
        Approvals.verify(stream.toString());
    }

    @Test
    @UseReporter(FileLauncherReporter.class)
    public void gameTestWithFileLauncherReporter() {
        // The FileLauncherReporter opens `received` file into default text editor
        //
        // Directions:
        // 1) Run the test
        // 2) Save the launched file as `approved`
        Random random = new Random(0);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);
        Approvals.verify(stream.toString());
    }

    @Test
    @UseReporter(IntelliJReporter.class)
    public void gameTestWithIntelliJReporter() {
        // Directions:
        // Run it in IntelliJ. It will report test results in the test output toolbox.
        // You can then compare the files by hand.
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
