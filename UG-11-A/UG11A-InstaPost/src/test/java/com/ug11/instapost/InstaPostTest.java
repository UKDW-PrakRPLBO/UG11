package com.ug11.instapost;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InstaPostTest {
    private InstaPost instaPost;

    @Before
    public void setUp() {
        instaPost = new InstaPost();
    }

    @Test
    public void testLoginWithInvalidEmailMissingAtSymbol() {
        try {
            instaPost.login("yohanesvito");
        } catch (EmailException e) {
            Assert.assertEquals("Login gagal! Email yang Anda masukkan tidak valid.", e.getErrorMessage());
        }
    }

    @Test
    public void testLoginWithInvalidEmailInvalidDomain() {
        try {
            instaPost.login("yohanesvito@ti.ukdw.ac.id");
        } catch (EmailException e) {
            Assert.assertEquals("Login gagal! Email Anda tidak terdaftar di Google", e.getErrorMessage());
        }
    }

    @Test
    public void testLoginWithValidEmail() {
        try {
            instaPost.login("yohanesvito@gmail.com");
            Assert.assertEquals("YOHANESVITO", instaPost.getUsername());
            Assert.assertEquals("yohanesvito@gmail.com", instaPost.getEmail());
        } catch (EmailException e) {
            Assert.fail("Exception should not be thrown.");
        }
    }

    @Test
    public void testPostWithoutMention() {
        String caption = "Cuaca hari ini sangat baik.";
        instaPost.post(caption);
        Assert.assertEquals(0, instaPost.getTotalMention());
    }

    @Test
    public void testPostWithMultipleMentions() {
        String caption = "@jarwo @pepeng @emil Yuk kerjain tugas gaes";
        instaPost.post(caption);
        Assert.assertEquals(3, instaPost.getTotalMention());
    }
}
