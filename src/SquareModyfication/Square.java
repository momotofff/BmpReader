package SquareModyfication;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Square
{
    private interface Modifier
    {
        void modify(Square src, Square dest, int x, int y);
    }

    private int[][] array = new int[0][0];
    public int[][] getArray() { return array; }

    Square(int size)
    {
        setSize(size);
    }

    public void setSize(int size)
    {
        if (size <= 0)
            throw new RuntimeException("Квадрата с длиной " + size + " не существует!!! Попробуйте еще раз)))");

        this.array = new int[size][size];
    }

    public void fillRandomly()
    {
        for (int i = 0; i < array.length; ++i)
        {
            for (int j = 0; j < array.length; ++j)
            {
                this.array[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (int[] ints : array)
        {
            for (int j = 0; j < array.length; ++j)
            {
                result.append(ints[j]).append(" ");
            }

            result.append("\n");
        }

        return result.toString();
    }

    public Square rotateRight()
    {
        /* With anonymous class
        return this.modify(new Modifier() {
            @Override
            public void modify(Square src, Square dest, int x, int y) {
                dest.array[y][array.length - x - 1] = src.array[x][y];
            }
        });
        */

        // Modern, with lambda
        return this.modify((src, dest, x, y) -> dest.array[y][array.length - x - 1] = src.array[x][y]);
    }

    public Square rotateLeft()
    {
        return this.modify((src, dest, x, y) -> dest.array[y][x] = src.array[x][src.array.length - y - 1]);
    }

    public Square mirrorHorizontally()
    {
        return this.modify((src, dest, x, y) -> dest.array[x][y] = src.array[x][src.array.length - y - 1]);
    }

    public Square mirrorVertically()
    {
        return this.modify((src, dest, x, y) -> dest.array[dest.array.length - 1 - y][x] = src.array[y][x]);
    }

    public Square modify(Modifier modifier)
    {
        Square sq = new Square(array.length);

        for (int i = 0; i < array.length; ++i)
            for (int j = 0; j < array.length; ++j)
                modifier.modify(this, sq, i, j);

        return sq;
    }

    public void fillManually() throws Exception
    {
        int length = 0;
        System.out.println("Введите размер квадрата.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            length = Integer.parseInt(reader.readLine());
        }
        catch (Exception ignored)
        {
            throw new RuntimeException("Вводите только числа!!!");
        }

        setSize(length);

        System.out.println("Отлично! А теперь его нужно заполнить.");

        for (int i = 0; i < length; ++i)
        {
            for (int j = 0; j < length; ++j)
            {
                array[i][j] = Integer.parseInt(reader.readLine());
            }
        }
    }
}
