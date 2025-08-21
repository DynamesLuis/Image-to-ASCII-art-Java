import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    public ImageProcessor(String imagePath) throws IOException{
            BufferedImage myImg = ImageIO.read(new File(imagePath));

            Image originalImage= myImg.getScaledInstance(myImg.getWidth() / 4, myImg.getHeight() / 4, Image.SCALE_DEFAULT);
            int type = ((myImg.getType() == 0) ? BufferedImage.TYPE_INT_ARGB : myImg.getType());
            BufferedImage resizedImage = new BufferedImage(myImg.getWidth() / 4, myImg.getHeight() / 4, type);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(myImg, 0, 0, myImg.getWidth() / 4, myImg.getHeight() / 4, null);
            g2d.dispose();

            WriteFile writeFile = new WriteFile();

            //int height = myImg.getHeight();
            //int width = myImg.getWidth();
            int height = resizedImage.getHeight();
            int width = resizedImage.getWidth();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    String asciiCharacter = "";
                    int clr = resizedImage.getRGB(x, y);
                    int red = (clr & 0x00ff0000) >> 16;
                    int green = (clr & 0x0000ff00) >> 8;
                    int blue = clr & 0x000000ff;
                    float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;
                    if (luminance >= 0 && luminance <= 0.1) asciiCharacter = "@";
                    if (luminance > 0.1 && luminance <= 0.2) asciiCharacter = "#";
                    if (luminance > 0.2 && luminance <= 0.3) asciiCharacter = "S";
                    if (luminance > 0.3 && luminance <= 0.4) asciiCharacter = "%";
                    if (luminance > 0.4 && luminance <= 0.5) asciiCharacter = "?";
                    if (luminance > 0.5 && luminance <= 0.6) asciiCharacter = "*";
                    if (luminance > 0.6 && luminance <= 0.7) asciiCharacter = "+";
                    if (luminance > 0.7 && luminance <= 0.8) asciiCharacter = ";";
                    if (luminance > 0.8 && luminance <= 0.9) asciiCharacter = ":";
                    if (luminance > 0.9 && luminance <= 1) asciiCharacter = ".";
                    writeFile.writeInLine(asciiCharacter);
            }
                writeFile.writeNewLine();
        }
            writeFile.closeWriter();
        System.out.println("Ascii art created! :D");
    }
}
