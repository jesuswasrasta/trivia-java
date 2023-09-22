package com.jesuswasrasta.trivia.approvals;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.stream.LongStream;

@UseReporter(JunitReporter.class)
public class GameRunnerApprovalTests {
    private ByteArrayOutputStream stream;

    /**
     * Number of Golden master files to generate
     */
    static final int MAX_SEED = 1000;

    private static void call(Long s) {
        GameRunner gameRunner = new GameRunner();
        Random random = new Random((Long) s);
        gameRunner.play(random);
    }

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

//    nando: can't manage to get this work :|
//    @ParameterizedTest
//    @MethodSource("range")
//    @UseReporter(FileLauncherReporter.class)
//    public void GameRunnerTestWithSeeds(int seed) {
//        Random random = new Random(seed);
//        GameRunner gameRunner = new GameRunner();
//        gameRunner.play(random);
//
//        Approvals.verify(stream.toString(), Approvals.NAMES.withParameters(String.valueOf(seed)));
//    }

    @Test
    @UseReporter(DiffReporter.class)
    public void GameRunnerTestCombinations() {
        // CombinationApprovals is a way to generate multiple tests form a set of data.
        // Basically, here we call gameRunner.play() MAX_SEEDS times.
        //see: https://yoan-thirion.gitbook.io/knowledge-base/software-craftsmanship/code-katas/gilded-rose-approval-testing
        CombinationApprovals.verifyAllCombinations(
                this::callGameRunnerPlay, //this is the method you want to test
                rangeArray() //this is the data provider, array of Long in this case
        );
    }

    private String callGameRunnerPlay(Long seed) {
        ByteArrayOutputStream stream = getOutputStream();

        Random random = new Random(seed);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);

        return stream.toString();
    }

    static Long[] rangeArray() {
        return (LongStream.range(0, MAX_SEED).boxed().toArray(Long[] ::new));
    }

    private ByteArrayOutputStream getOutputStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
