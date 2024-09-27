import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsApp {
    @Test
    public void UnitTest1(){
        App application = new App();
        Assertions.assertEquals(application.imageFormatDetection("images/imagenBMP.bmp"),FileType.JPG);
    }

}
