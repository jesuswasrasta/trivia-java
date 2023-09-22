package com.jesuswasrasta.trivia.goldenmaster;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.jesuswasrasta.trivia.StringAssertions.assertLinesEqual;

class GoldenMasterTest {
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

            assertLinesEqual(expected, actual);
        }
    }
}
