package BmpReader;

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
