package BmpReader;
import java.io.*;

public class BmpReader
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream stream = new DataInputStream(new FileInputStream("D://wall1.bmp"));
        Header header = new Header(stream);
        DibHeader dibHeader = new DibHeader(stream);
        System.out.println(header);
        System.out.println(dibHeader);
        stream.close();

        SimpleGui app = new SimpleGui();
        app.setVisible(true);
    }
}
