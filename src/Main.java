import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ImageProcessor imgProcessor = new ImageProcessor("src/github.png");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}