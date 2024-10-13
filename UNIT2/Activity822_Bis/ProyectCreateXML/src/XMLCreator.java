public class XMLCreator {

    public String createOpenTagWithTitle(String title) {
        return "<" + title + ">";
    }

    public String createCloseTagWithTitle(String title) {
        return "</" + title + ">";
    }

    public String createIndentionWithNumberTabulators(int number) {
        String blank = "    ";
        String result = "";
        for (int i = 0; i < number; i++) {
            result += blank;
        }
        return result;
    }
}
