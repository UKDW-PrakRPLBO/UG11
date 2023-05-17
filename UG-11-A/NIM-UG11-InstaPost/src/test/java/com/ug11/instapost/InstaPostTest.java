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
            instaPost.login("albertusadrian");
        } catch (EmailException e) {
            Assert.assertEquals("Login gagal! Email yang Anda masukkan tidak valid.", e.getErrorMessage());
        }
    }

    @Test
    public void testLoginWithInvalidEmailInvalidDomain() {
        try {
            instaPost.login("albertusadrian@ti.ukdw.ac.id");
        } catch (EmailException e) {
            Assert.assertEquals("Login gagal! Email Anda tidak terdaftar di Google", e.getErrorMessage());
        }
    }

    @Test
    public void testLoginWithValidEmail() {
        try {
            instaPost.login("albertusadrian@gmail.com");
            Assert.assertEquals("ALBERTUSADRIAN", instaPost.getUsername());
            Assert.assertEquals("albertusadrian@gmail.com", instaPost.getEmail());
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
        String caption = "@susi @dea @yossia Yuk kerjain tugas gaes";
        instaPost.post(caption);
        Assert.assertEquals(3, instaPost.getTotalMention());
    }
}
