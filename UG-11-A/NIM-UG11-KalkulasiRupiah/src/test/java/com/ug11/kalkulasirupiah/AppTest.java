package com.ug11.kalkulasirupiah;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AppTest {

    @Test
    public void testApp() {
        String input = "Rp10000 Rp5000 Rp40000"; // Example input
        String expectedOutput = "Rincian biaya: Rp10000 + Rp5000 + Rp20000" + System.lineSeparator()
                + "Total: 65000" + System.lineSeparator();

        // Redirect System.in and System.out for testing
        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            System.setIn(inStream);
            System.setOut(new PrintStream(outStream));

            App.main(new String[]{});

            String actualOutput = outStream.toString();
            Assertions.assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(sysInBackup);
            System.setOut(sysOutBackup);
        }
    }
}
