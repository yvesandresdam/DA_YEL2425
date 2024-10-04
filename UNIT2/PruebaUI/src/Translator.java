import java.util.HashMap;
import java.util.Map;

public class Translator {
    private static final String TEXT1_ITALIANO = "Accettate il patto?";
    private static final String TEXT2_ITALIANO = "Un po’ di pazienza, sefìor. " +
            "Simili aftari non si trattano lì per " +
            "lì, specialmente quando non si sa dove si può finire.";
    private static final String TEXT3_ITALIANO = "Non posso dire che sia meschino, senior.,.. Toh! Non so ancora il vostro nome";


    public void displayDictionary(Language lang) {
        if (lang == Language.ITALIANO) {
            for (String s : dictionaryItaliano.values()) {
                System.out.println(s);
            }
        } else if (lang == Language.DEUTSCHE) {
            for (String s : dictionaryAleman.values()) {
                System.out.println(s);
            }
        } else {
            return;
        }
    }

    public void DisplayLineNumberWithLanguage(Language lang, int lineNumber){
        if(lang == Language.ITALIANO){
            Translator italiano = new Translator();
            String result = italiano.dictionaryItaliano.get(lineNumber);
            System.out.println(result);
        }
        else if(lang == Language.DEUTSCHE){
            Translator deutsche = new Translator();
            String result = deutsche.dictionaryAleman.get(lineNumber);
            System.out.println(result);
        }
    }

    private Map<Integer, String> dictionaryItaliano = new HashMap<>() {
        {
            {
                put(0, TEXT1_ITALIANO);
            }

            {
                put(1, TEXT2_ITALIANO);
            }
            {
                put(2, TEXT3_ITALIANO);
            }
        }
    };

    private static final String TEXT1_ALEMAN = "Akzeptiere Sie den Deal?";
    private static final String TEXT2_ALEMAN = "Ich mag es nicht, mich in die Länge zu ziehen, Kapitän Nuncz.";
    private static final String TEXT3_ALEMAN = "Etwas Geduld, Sefìor. Solche Aftari werden dort nicht behandelt\n" +
            "dort, vor allem, wenn man nicht weiß, wo man landen könnte.";

    private Map<Integer, String> dictionaryAleman = new HashMap<>() {
        {
            {
                put(0, TEXT1_ALEMAN);
            }

            {
                put(1, TEXT2_ALEMAN);
            }
            {
                put(2, TEXT3_ALEMAN);
            }
        }
    };
}
