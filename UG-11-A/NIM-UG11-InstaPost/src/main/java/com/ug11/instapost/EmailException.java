package com.ug11.instapost;

public class EmailException extends Exception {
    private int errorCode;
    private String errorMessage;
    public EmailException(int errorCode) {
        super();
        this.errorCode = errorCode;
        if(errorCode==1){
            this.errorMessage = "Login gagal! Email yang Anda masukkan tidak valid.";
        } else if(errorCode==2){
            this.errorMessage = "Login gagal! Email Anda tidak terdaftar di Google";
        }
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
