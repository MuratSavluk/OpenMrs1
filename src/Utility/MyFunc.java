package Utility;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MyFunc {
    public static void Wait(int sn){
        try {
            Thread.sleep(sn * 1000l);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static int randum(int i){
        Random random = new Random();
         return  random.nextInt(i);
    }

    public static boolean listContaionsString(List<WebElement> list,String aranan){
        boolean bulndu = false;
        for (WebElement e : list){
            if (e.getText().toLowerCase().equals(aranan.toLowerCase())) {
                bulndu = true;
                break;
            }
        }
        return bulndu;
    }
}
