import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsApp {
    App application = new App();

    @Test
    public void unitTest1() {
        Assertions.assertEquals(application.imageFormatDetection("images/imagenBMP.bmp"), FileType.BMP);
    }

    @Test
    public void unitTest2() {
        Assertions.assertEquals(application.imageFormatDetection("images/imagenJPG.jpg"), FileType.JPG);
    }

    @Test
    public void unitTest3() {
        Assertions.assertEquals(application.imageFormatDetection("images/imagenICO.ico"), FileType.ICO);
    }

    @Test
    public void unitTest4() {
        Assertions.assertEquals(application.imageFormatDetection("images/imagenGIF.gif"), FileType.GIF);
    }
}

class TestsApps2{
    App application = new App();
    @Test
    public void unitTest1(){
        Assertions.assertEquals(application.imageFormatDetection("cadena incorrecta"),FileType.UNKNOWN);
        System.out.println("Si el usuario introduce una cadena incorrecta, se le avisa con dos mensajes distintos");
    }
}
