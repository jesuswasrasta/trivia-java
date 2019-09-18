package com.jesuswasrasta.trivia;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import com.jesuswasrasta.trivia.runner.GameRunner;
import org.apache.commons.io.FileUtils;

class GoldenMaster {
    private final String encoding = "ISO-8859-1";
    static final int MAX_SEED = 1000;

    String getGameResult(long seed) {
        //Redirect system console output to a stream I can use for tests
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        GameRunner.play(new Random(seed));

        return stream.toString();
    }

    void generateFiles() throws IOException {
        for (long seed = 0; seed < MAX_SEED; seed++) {
            File file = getFilenameBySeed(seed);
            String gameResult = getGameResult(seed);

            FileUtils.writeStringToFile(file, gameResult, encoding);
        }
    }

    String getGoldenMasterBySeed(long seed) throws IOException {
        return FileUtils.readFileToString(getFilenameBySeed(seed), encoding);
    }

    private File getFilenameBySeed(long seed) {
        String baseDir = System.getProperty("user.dir");
        return new File(baseDir + "/src/test/goldenMasters/" + seed + ".txt");
    }
}
