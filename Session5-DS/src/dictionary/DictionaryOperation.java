package dictionary;

import java.util.ArrayList;

/**
 * Driver class for dictionary
 * @author Ashish
 *
 */
public class DictionaryOperation {

	public static void main(String[] args){
		DictionaryImpl dictObj = new DictionaryImpl();
		dictObj.insertPair(84, 10);
		dictObj.insertPair(58, 11);
		dictObj.sortedList();
		System.out.println("----------Value On Key---------");
		System.out.println(dictObj.getValue(84));
		System.out.println(dictObj.getValue(70));

		System.out.println("---------sorted in range (k1, k2)-----------");
		ArrayList<BSTNode> sorted = dictObj.sortedListInRange(30, 70);

		for(int i =0; i<sorted.size(); i++){
			System.out.println(sorted.get(i).getKey());
		}
	}
}
