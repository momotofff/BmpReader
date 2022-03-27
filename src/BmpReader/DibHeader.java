package BmpReader;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

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