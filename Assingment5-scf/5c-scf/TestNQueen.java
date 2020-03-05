import static org.junit.Assert.*;

import org.junit.Test;

public class TestNQueen {
	@Test
	public void testNQueen()
	{
		NQueen queen = new NQueen();
		int result[][]=queen.printElement(new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}});
		for(int i=0;i<result.length;i++)
		{
			
		}
		int expected[][] ={{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}};
		assertArrayEquals(expected, result);
		int [][]result1=queen.printElement(new int[][]{{0,0,0},{0,0,0},{0,0,0}});
		int expect[][]={{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expect, result1); 
	}

}