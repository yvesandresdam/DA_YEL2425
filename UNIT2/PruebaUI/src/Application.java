import java.util.Random;

public class Application {
    public void launch(){
        displayText();
    }

    public void displayText(){

        int n1 = getRandom(3);
        Translator line1 = new Translator();
        line1.DisplayLineNumberWithLanguage(Language.DEUTSCHE,n1);

        int n2 = getRandom(3);
        Translator line2 = new Translator();
        line2.DisplayLineNumberWithLanguage(Language.ITALIANO,n2);
    }

    private static int getRandom(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
}
