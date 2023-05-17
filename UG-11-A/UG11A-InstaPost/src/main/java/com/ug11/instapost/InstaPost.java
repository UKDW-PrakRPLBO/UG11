package com.ug11.instapost;

public class InstaPost {
    private String email;
    private String username;
    private int totalMention;

    //TODO 1: Buat getter untuk atribut diatas

    public void printInfo(){
        System.out.println("Username: "+getUsername());
        System.out.println("Email: "+getEmail);
        System.out.println("Total Mention: "+getTotalMention());
    }

    //TODO 2: Lengkapi Class InstaPost sesuai dengan tabel di soal

}
