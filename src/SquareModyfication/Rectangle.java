package SquareModyfication;
import java.util.Arrays;

public class Rectangle
{
    private interface Filler
    {
        int getElement(int x, int y);
    }

    private int[][] array = new int[0][0];

    public int[][] getArray() { return array; }
    Rectangle(int width, int height)
    {
        setSize(width, height);
    }
    Rectangle(int[][] arr) { this.array = arr; }

    public int getWidth() { return array.length; }
    public int getHeight() { return array[0].length; }

    public void setSize(int width, int height)
    {
        if (width <= 0 || height <= 0)
            throw new RuntimeException("Попробуйте еще раз)))");

        this.array = new int[width][height];
    }

    public void fillRandomly()
    {
        for (int i = 0; i < getWidth(); ++i)
            for (int j = 0; j < getHeight(); ++j)
                this.array[i][j] = (int) (Math.random() * 10);
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (int[] ints : array)
        {
            for (int value: ints)
                result.append(value).append(" ");

            result.append("\n");
        }

        return result.toString();
    }

    public Rectangle rotateCw()
    {
        Rectangle rect = new Rectangle(getHeight(), getWidth());
        rect.fill((x, y) -> this.array[this.getWidth() - y - 1][x]);
        return rect;
    }

    public Rectangle rotateCcw()
    {
        Rectangle rect = new Rectangle(getHeight(), getWidth());
        rect.fill((x, y) -> this.array[y][this.getHeight() - x - 1]);
        return rect;
    }

    public Rectangle mirrorHorizontally()
    {
        Rectangle rect = new Rectangle(getWidth(), getHeight());
        rect.fill((x, y) -> this.array[x][this.getHeight() - y - 1]);
        return rect;
    }

    public Rectangle mirrorVertically()
    {
        Rectangle rect = new Rectangle(getWidth(), getHeight());
        rect.fill((x, y) -> this.array[this.getWidth() - x - 1][y]);
        return rect;
    }

    private void fill(Filler filler)
    {
        for (int i = 0; i < getWidth(); ++i)
            for (int j = 0; j < getHeight(); ++j)
                array[i][j] = filler.getElement(i, j);
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        Rectangle rect = (Rectangle) other;

        return  this.getWidth() == rect.getWidth() &&
                this.getHeight() == rect.getHeight() &&
                Arrays.deepEquals(this.array, rect.array);
    }
}
