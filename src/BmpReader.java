import java.io.*;

class Decoder
{
    public static short decode(short src)
    {
        return (short) ((src & 0xFF) << 8 | ((src >> 8) & 0xFF));
    }

    public static int decode(int src)
    {
        return ((src & 0xFF) << 24) | ((src & 0xFF00) << 8) | ((src & 0xFF0000) >> 8) | ((src >> 24) & 0xFF);
    }
}

class Header
{
    Header(DataInputStream stream) throws IOException
    {
        signature = Decoder.decode(stream.readShort());
        fileSize = Decoder.decode(stream.readInt());
        stream.skipBytes(4);
        offset = Decoder.decode(stream.readInt());
    }

    public short signature;
    public int fileSize;
    public int offset;

    @Override
    public String toString()
    {
        return String.format("Loaded BMP, size is %d bytes, data offset is %d", fileSize, offset);
    }
}

class DibHeader
{
    DibHeader(DataInputStream stream) throws IOException
    {
        size = Decoder.decode(stream.readInt());
        byte[] data = new byte[size - 4];
        if (stream.read(data) != data.length)
            throw new IOException();

        DataInputStream header = new DataInputStream(new ByteArrayInputStream(data));
        width = Decoder.decode(header.readInt());
        height = Decoder.decode(header.readInt());
        header.skipBytes(2);
        bitsPerPixel = Decoder.decode(header.readShort());
        header.skipBytes(4);
        imageSize = Decoder.decode(header.readInt());
        header.skipBytes(8);
        colorTableSize = Decoder.decode(header.readInt());
    }

    public int size;
    public int width;
    public int height;
    public short bitsPerPixel;
    public int imageSize;
    public int colorTableSize;

    @Override
    public String toString()
    {
        return String.format("DIB header size is %d bytes, image size %d x %d (%d bytes), pixel width %d bits",
                             size, width, height, imageSize, bitsPerPixel);
    }
}

public class BmpReader
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream stream = new DataInputStream(new FileInputStream("D://Games//wall1.bmp"));
        Header header = new Header(stream);
        DibHeader dibHeader = new DibHeader(stream);

        System.out.println(header);
        System.out.println(dibHeader);

        stream.close();
    }
}
