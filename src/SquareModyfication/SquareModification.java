package SquareModyfication;

public class SquareModification
{
    public static void main(String[] args)
    {
        Square sq = new Square(5);
        sq.fillRandomly();
        System.out.println(sq);
        System.out.println(sq.mirrorHorizontally());
        System.out.println(sq.rotateRight());


    }
}