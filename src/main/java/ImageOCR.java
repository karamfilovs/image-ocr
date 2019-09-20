import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;


public class ImageOCR {
    private static final String TRAINED_DATA_LOCATION = "src/main/resources/trained-data";

    public String extractText(String imagePath) {
        Tesseract tesseract = new Tesseract();
        String imageText = null;
        try {
            tesseract.setDatapath(TRAINED_DATA_LOCATION);
            imageText = tesseract.doOCR(new File(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return imageText;
    }

    public static void main(String args[]) {
        ImageOCR imageOCR = new ImageOCR();
        String text = imageOCR.extractText("src/main/resources/download.jpg");
        System.out.println("The extracted text from image is: \n" + text);

    }

}