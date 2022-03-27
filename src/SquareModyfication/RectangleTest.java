package SquareModyfication;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest
{
    @Test
    public void equality()
    {
        Rectangle rect1 = new Rectangle(new int [][] {{1,2,3}, {4,5,6}, {7,8,9}});
        Rectangle rect2 = new Rectangle(new int [][] {{1,2,3}, {4,5,6}, {7,8,9}});
        Rectangle rect3 = new Rectangle(new int [][] {{1,2,3}, {4,5,6}, {7,8,8}});
        Rectangle rect4 = new Rectangle(new int [][] {{1,2}, {4,5}, {7,8}});

        Assert.assertEquals(rect1, rect1);
        Assert.assertEquals(rect1, rect2);
        Assert.assertNotEquals(rect1, rect3);
        Assert.assertNotEquals(rect1, rect4);
        Assert.assertNotEquals(rect1, null);
        Assert.assertNotEquals(rect1, new Object());
    }

    @Test
    public void setSize()
    {
        Rectangle rect = new Rectangle(2,5);
        Assert.assertEquals(rect.getWidth(), 2);
        Assert.assertEquals(rect.getHeight(), 5);
    }

    @Test
    public void getArray()
    {
        int[][] arr = {{1,2}, {4,5}, {7,8}};
        Rectangle rect = new Rectangle(arr);
        Assert.assertArrayEquals(rect.getArray(), arr);
    }

    @Test
    public void rotateCw()
    {
        Rectangle rect1 = new Rectangle(new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}});
        Rectangle rect2 = new Rectangle(new int[][] {{11,6,1}, {12,7,2}, {13,8,3}, {14,9,4}, {15,10,5}});
        Assert.assertEquals(rect1.rotateCw(), rect2);
    }

    @Test
    public void rotateCcw()
    {
        Rectangle rect1 = new Rectangle(new int[][] {{11,6,1}, {12,7,2}, {13,8,3}, {14,9,4}, {15,10,5}});
        Rectangle rect2 = new Rectangle(new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}});
        Assert.assertEquals(rect1.rotateCcw(), rect2);
    }

    @Test
    public void mirrorHorizontally()
    {
        Rectangle rect1 = new Rectangle(new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}});
        Rectangle rect2 = new Rectangle(new int[][] {{5,4,3,2,1}, {10,9,8,7,6}, {15,14,13,12,11}});
        Assert.assertEquals(rect1.mirrorHorizontally(), rect2);
    }

    @Test
    public void mirrorVertically()
    {
        Rectangle rect1 = new Rectangle(new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}});
        Rectangle rect2 = new Rectangle(new int[][] {{11,12,13,14,15}, {6,7,8,9,10}, {1,2,3,4,5}});
        Assert.assertEquals(rect1.mirrorVertically(), rect2);
    }

    @Test
    public void testToString()
    {
        Rectangle rect = new Rectangle(new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}});
        Assert.assertEquals(rect.toString(), "1 2 3 4 5 \n6 7 8 9 10 \n11 12 13 14 15 \n");
    }
}
