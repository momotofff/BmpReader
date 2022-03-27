package BmpReader;
import java.io.DataInputStream;
import java.io.IOException;

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