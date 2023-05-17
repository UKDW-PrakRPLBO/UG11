package com.ug11.kalkulasirupiah;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan teks: ");
        String teks = input.nextLine();
        String[] arrTeks = teks.split(" ");
        int counter = 0;
        StringBuilder sb = new StringBuilder("Rincian biaya: ");
        for(String kata: arrTeks){
            if (kata.contains("Rp")){
                String angka = kata.substring(2,kata.length()-3);
                sb.append(kata+" + ");
                counter+=Integer.parseInt(angka.replace(".",""));
            }
        }
        String hasil = sb.toString();
        System.out.println(hasil.substring(0,hasil.length()-3));
        System.out.println("Total: "+counter);
    }
}
