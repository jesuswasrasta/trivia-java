package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRunnerTest {
    ByteArrayOutputStream stream;

    @BeforeEach
    void beforeEach(){
        stream = getOutputStream();
    }

    @Test
    void name() {
        GameRunner gameRunner = new GameRunner();
        gameRunner.main(new String[0]);

        assertEquals("Chet was added\n" +
                "They are player number 1\n" +
                "Pat was added\n" +
                "They are player number 2\n" +
                "Sue was added\n" +
                "They are player number 3\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 1 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 2\n" +
                "Pat's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 1 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 1\n" +
                "Sue's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 1 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 2 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 2\n" +
                "Pat's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 2 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 5\n" +
                "Sue's new location is 6\n" +
                "The category is Sports\n" +
                "Sports Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 2 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet's new location is 8\n" +
                "The category is Pop\n" +
                "Pop Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 3 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 8\n" +
                "The category is Pop\n" +
                "Pop Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 3 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 4\n" +
                "Sue's new location is 10\n" +
                "The category is Sports\n" +
                "Sports Question 3\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 3 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 4\n" +
                "Chet's new location is 0\n" +
                "The category is Pop\n" +
                "Pop Question 3\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 4 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 0\n" +
                "The category is Pop\n" +
                "Pop Question 4\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 4 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 5\n" +
                "Sue's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 4 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 5\n" +
                "Chet's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 5 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 3\n" +
                "Pat's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 1\n" +
                "Question was incorrectly answered\n" +
                "Pat was sent to the penalty box\n" +
                "Sue is the current player\n" +
                "They have rolled a 2\n" +
                "Sue's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 3\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 5 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet's new location is 7\n" +
                "The category is Rock\n" +
                "Rock Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Chet now has 6 Gold Coins.\n", stream.toString());
    }


    private ByteArrayOutputStream getOutputStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
