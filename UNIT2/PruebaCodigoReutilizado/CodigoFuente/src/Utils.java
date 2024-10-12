import java.util.Random;

public class Utils {
    public static int getRandomWithBounding(int min, int max){
        Random random = new Random();
        return random.nextInt(min,max);
    }
}
