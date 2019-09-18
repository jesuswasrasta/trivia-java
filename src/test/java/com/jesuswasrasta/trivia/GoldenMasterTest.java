package com.jesuswasrasta.trivia;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GoldenMasterTest {
    @Test
    void generateFiles() throws IOException {
        GoldenMaster goldenMaster = new GoldenMaster();
        goldenMaster.generateFiles();
    }
}
