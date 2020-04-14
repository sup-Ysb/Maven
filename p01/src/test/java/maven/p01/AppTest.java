package maven.p01;

import org.junit.Assert;
import org.junit.Test;
public class AppTest {
    private String INPUT = "123456";
    private String INPUT1 = "12345";
    @Test
    public void testLength() {
        Assert.assertEquals(64, App.sha256hex(INPUT).length());
    }
    @Test
    public void testHex() {
        String expected = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        Assert.assertEquals(expected, App.sha256hex(INPUT));
    }
    @Test
    public void testHex1() {
        String expected = "12345";
        Assert.assertEquals(expected, App.sha255hex(INPUT1));
    }
}