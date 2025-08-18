import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {
    FileWriter myWriter;
    public WriteFile() throws IOException {
        myWriter = new FileWriter("filename.txt");
    }

    public void writeInLine(String AsciiCharacter) throws IOException {
        myWriter.write(AsciiCharacter);
    }

    public void writeNewLine() throws IOException {
        myWriter.write(String.format("%n"));
    }

    public void closeWriter() throws IOException {
        myWriter.close();
    }
}