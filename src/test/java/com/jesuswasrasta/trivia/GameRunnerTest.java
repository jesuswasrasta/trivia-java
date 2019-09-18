package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

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
    void gameTest() {
        Random random = new Random(0);
        GameRunner gameRunner = new GameRunner();
        gameRunner.play(random);

        assertEquals(String.format("Chet was added%1$s" +
                "They are player number 1%1$s" +
                "Pat was added%1$s" +
                "They are player number 2%1$s" +
                "Sue was added%1$s" +
                "They are player number 3%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 1%1$s" +
                "Chet's new location is 1%1$s" +
                "The category is Science%1$s" +
                "Science Question 0%1$s" +
                "Question was incorrectly answered%1$s" +
                "Chet was sent to the penalty box%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 5%1$s" +
                "Pat's new location is 5%1$s" +
                "The category is Science%1$s" +
                "Science Question 1%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Pat now has 1 Gold Coins.%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 1%1$s" +
                "Sue's new location is 1%1$s" +
                "The category is Science%1$s" +
                "Science Question 2%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 1 Gold Coins.%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 2%1$s" +
                "Chet is not getting out of the penalty box%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 5%1$s" +
                "Pat's new location is 10%1$s" +
                "The category is Sports%1$s" +
                "Sports Question 0%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Pat now has 2 Gold Coins.%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 3%1$s" +
                "Sue's new location is 4%1$s" +
                "The category is Pop%1$s" +
                "Pop Question 0%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 2 Gold Coins.%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 4%1$s" +
                "Chet is not getting out of the penalty box%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 1%1$s" +
                "Pat's new location is 11%1$s" +
                "The category is Rock%1$s" +
                "Rock Question 0%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Pat now has 3 Gold Coins.%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 5%1$s" +
                "Sue's new location is 9%1$s" +
                "The category is Science%1$s" +
                "Science Question 3%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 3 Gold Coins.%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 2%1$s" +
                "Chet is not getting out of the penalty box%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 4%1$s" +
                "Pat's new location is 3%1$s" +
                "The category is Rock%1$s" +
                "Rock Question 1%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Pat now has 4 Gold Coins.%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 5%1$s" +
                "Sue's new location is 2%1$s" +
                "The category is Sports%1$s" +
                "Sports Question 1%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 4 Gold Coins.%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 3%1$s" +
                "Chet is getting out of the penalty box%1$s" +
                "Chet's new location is 4%1$s" +
                "The category is Pop%1$s" +
                "Pop Question 1%1$s" +
                "Answer was correct!!!!%1$s" +
                "Chet now has 1 Gold Coins.%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 4%1$s" +
                "Pat's new location is 7%1$s" +
                "The category is Rock%1$s" +
                "Rock Question 2%1$s" +
                "Question was incorrectly answered%1$s" +
                "Pat was sent to the penalty box%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 3%1$s" +
                "Sue's new location is 5%1$s" +
                "The category is Science%1$s" +
                "Science Question 4%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 5 Gold Coins.%1$s" +
                "Chet is the current player%1$s" +
                "They have rolled a 1%1$s" +
                "Chet is getting out of the penalty box%1$s" +
                "Chet's new location is 5%1$s" +
                "The category is Science%1$s" +
                "Science Question 5%1$s" +
                "Answer was correct!!!!%1$s" +
                "Chet now has 2 Gold Coins.%1$s" +
                "Pat is the current player%1$s" +
                "They have rolled a 3%1$s" +
                "Pat is getting out of the penalty box%1$s" +
                "Pat's new location is 10%1$s" +
                "The category is Sports%1$s" +
                "Sports Question 2%1$s" +
                "Answer was correct!!!!%1$s" +
                "Pat now has 5 Gold Coins.%1$s" +
                "Sue is the current player%1$s" +
                "They have rolled a 3%1$s" +
                "Sue's new location is 8%1$s" +
                "The category is Pop%1$s" +
                "Pop Question 2%1$s" +
                "Answer was corrent!!!!%1$s" +
                "Sue now has 6 Gold Coins.%1$s", System.getProperty("line.separator")), stream.toString());
    }


    private ByteArrayOutputStream getOutputStream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
