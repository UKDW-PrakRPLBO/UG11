package com.ug11.kalkulasirupiah;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AppTest {

    @Test
    public void testApp1() {
        String input = "Ibu membeli minyak goreng seharga Rp22.500,00 dan margarin seharga Rp12.500,00 di supermarket"; // Example input
        String expectedOutput = "Rincian biaya: Rp22.500,00 + Rp12.500,00" + System.lineSeparator()
                + "Total: 35000" + System.lineSeparator();

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

    @Test
    public void testApp2() {
        String input = "Harga gula sudah Rp19.000,00 per kg. Bahkan ada juga yang mencapai Rp20.000,00 ribu per kg di beberapa pasar. Kalau di warung kelontong bisa sampai Rp21.000,00 per kg.” ujar Abdullah. "; // Example input
        String expectedOutput = "Rincian biaya: Rp19.000,00 + Rp20.000,00 + Rp21.000,00" + System.lineSeparator()
                + "Total: 60000" + System.lineSeparator();

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
