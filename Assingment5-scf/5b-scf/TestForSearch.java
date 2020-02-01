import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestForSearch {

	@Test
	public void testCaseForLinear() {
		Search search = new Search();
		int result;
		result = search.linearSearch(new int[] {1,3,2,4,0},2);
		assertEquals(2,result);	
	}

	@Test
	public void testCaseForBinary() {
		Search search = new Search();
		int result;
		result = search.binarySearch(new int[] {0,1,2,3,4},0,4,2);
		assertEquals(2,result);


		result = search.binarySearch(new int[] {0,1,2,3,4},0,4,5);
		assertEquals(-1,result);

	}
}
