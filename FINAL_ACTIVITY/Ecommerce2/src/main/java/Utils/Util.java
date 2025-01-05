package Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    public void setLoggerSevere(){
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setLevel(Level.SEVERE);
    }
}
