package com.ug11.instapost;

public class InstaPost {
    private String email;
    private String username;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalMention() {
        return totalMention;
    }

    private int totalMention;
    public void login(String email) throws EmailException {
        try {
            if(!email.contains("@")){
                throw new EmailException(1);
            } else {
                String[] splitEmail = email.split("@");
                if(!splitEmail[1].equals("gmail.com")){
                    throw new EmailException(2);
                } else {
                    this.username = splitEmail[0].toUpperCase();
                    this.email = email;
                    System.out.println("Login berhasil!");
                }
            }
        } catch (EmailException e){
            System.out.println("Error: "+e.getErrorMessage());
        }
    }
    public void post(String caption){
        String result = "";
        int counter = 0;
        StringBuilder sbUserMentioned = new StringBuilder();
        String[] arrPesan = caption.split(" ");
        for(int i=0;i<arrPesan.length;i++) {
            if (arrPesan[i].charAt(0) == '@'){
                sbUserMentioned.append(arrPesan[i]+", ");
                counter+=1;
            }
        }
        if(counter==0){
            sbUserMentioned.append("-");
            result = sbUserMentioned.toString();
        } else {
            String res = sbUserMentioned.toString();
            result = res.substring(0,res.length()-2);
        }
        this.totalMention+=counter;
        System.out.println("Caption: "+caption);
        System.out.println("Pengguna yang Anda mention: "+result);
        System.out.println("Total username yang Anda mention: "+counter);
    }
    public void printInfo(){
        System.out.println("Username: "+this.username);
        System.out.println("Email: "+this.email);
        System.out.println("Total Mention: "+this.totalMention);
    }
}
