package com.jesuswasrasta.trivia;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMasterTest {
    @Test
    @Disabled("Use this only to (re)generate the Golden Master files")
    void generateFiles() throws IOException {
        GoldenMaster goldenMaster = new GoldenMaster();
        goldenMaster.generateFiles();
    }

    @Test
    void checkAgainstGoldenMaster() throws IOException {
        GoldenMaster goldenMaster = new GoldenMaster();

        for (long seed = 0; seed < GoldenMaster.MAX_SEED; seed++) {
            String expected = goldenMaster.getGoldenMasterBySeed(seed);
            String actual = goldenMaster.getGameResult(seed);

            assertEquals(expected, actual);
        }
    }
}
