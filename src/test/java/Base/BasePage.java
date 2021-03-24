package Base;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

import java.util.Random;

public class BasePage {
    public static RequestSpecification httpRequest;
    public static Response response;

    @After
    public void checkStatusCode(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }



    public String random(String no) {
        char[] sayi = no.toCharArray();
        for (int a = sayi.length - 1; a >= 0; a--) {
            if (sayi[a] == 'z') {
                sayi[a] = 'a';
            } else if (sayi[a] == '9') {
                sayi[a] = '0';
            } else {
                sayi[a]++;
                break;
            }
        }
        return String.valueOf(sayi);
    }

    public String randomName(int stringLength) {
        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz".toCharArray();
        String stringRandom = "";
        for (int i = 0; i < stringLength; i++) {
            stringRandom = stringRandom + String.valueOf(chars[random.nextInt(chars.length)]);
        }
        return stringRandom;
    }


    private static final String randomNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*randomNumber.length());
            builder.append(randomNumber.charAt(character));
        }
        return builder.toString();
    }

}
