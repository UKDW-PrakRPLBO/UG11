package com.ug11.instapost;

import org.junit.Assert;
import org.junit.Test;

public class EmailExceptionTest {

    @Test
    public void testEmailExceptionWithErrorCode1() {
        int errorCode = 1;
        EmailException exception = new EmailException(errorCode);

        String expectedErrorMessage = "Login gagal! Email yang Anda masukkan tidak valid.";
        String actualErrorMessage = exception.getErrorMessage();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testEmailExceptionWithErrorCode2() {
        int errorCode = 2;
        EmailException exception = new EmailException(errorCode);

        String expectedErrorMessage = "Login gagal! Email Anda tidak terdaftar di Google";
        String actualErrorMessage = exception.getErrorMessage();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
