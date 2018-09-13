/*  Author: Nicholas Wojcik
 *  Assignment: 0906
 *  GitHub URL: 
 *  
 *  Description: A console application that creates a character array of size 1000.
 *               It parses the array in record sizes of 60, and breaks each record 
 *               into three fields of 20.  It creates three records, outputs each 
 *               record independently, then prints the first 200 indexes of the 
 *               array.
 * 
 */


public class RecordModel {

	// ****************************************** VARIABLES ************************
	private static int[] recordArray = new int[1000];
	private static int endOfData = 0;
	private static int index = 0;
	private static int recordNumber = 0;
	
	// ****************************************** MAIN-LOOP ************************
	public static void main(String[] args) {
		
		// Insert three records into the recordArray
		INSERT("A", "a", "0");
		INSERT("B", "b", "1");
		INSERT("C", "c", "2");
		System.out.println();
		
		
		
		// Output the first three records from recordArray
		OUTPUT(0);
		OUTPUT(1);
		OUTPUT(2);
		System.out.println();
		
		
		
		// Output the first 200 indexes of recordArray
		for(int i = 0; i < 200; i++) {
			System.out.print((char)recordArray[i]);
		}
	}

	// ******************************************* FUNCTIONS ***********************
	// Insert a single record into the recordArray
	private static void INSERT(String fieldOne, String fieldTwo, String fieldThree) {
		int loopIterator = 0;
		
		
		
		//Check if first field exceeds 20 characters
		if(fieldOne.length() > 20) {
			loopIterator = 20;
		}else {
			loopIterator = fieldOne.length();
		}
		//Insert fieldOne into current record
		index = endOfData;
		for(int i = 0; i < loopIterator; i++) {
			recordArray[index] = fieldOne.charAt(i);
			index++;
		}
		//increment endOfData to the next field and reset the loopIterator
		index = endOfData + 20;
		loopIterator = 0;
		
		
		
		//Check if second field exceeds 20 characters
		if(fieldTwo.length() > 20) {
			loopIterator = 20;
		}else {
			loopIterator = fieldTwo.length();
		}
		//Insert fieldTwo into current record
		for(int i = 0; i < loopIterator; i++) {
			recordArray[index] = fieldTwo.charAt(i);
			index++;
		}
		//Increment endOfData to the next field and reset the loopIterator
		index = endOfData + 40;
		loopIterator = 0;
		
		
		
		
		//Check if third field exceeds 20 characters
		if(fieldThree.length() > 20) {
			loopIterator = 20;
		}else {
			loopIterator = fieldThree.length();
		}
		//Insert fieldThree into current record
		for(int i = 0; i < loopIterator; i++) {
			recordArray[index] = fieldThree.charAt(i);
			index++;
		}
		//calculate the record number, increment endOfData to next record location
		if(endOfData == 0)
			recordNumber = 0;
		else
			recordNumber = endOfData/60;
		endOfData = endOfData + 60;	
		
		
		
		//Confirm record storage
		System.out.println("Record store successful at location " + recordNumber + ".");
	}
	
	//Output the provided record number
	private static void OUTPUT(int recordNumber) {
		//output each character in the requested record number, the ASCII character is casted to be output
		for(int i = recordNumber*60; i < (recordNumber*60)+60; i++) {
			System.out.print((char)recordArray[i]);
		}
		
		System.out.println();
	}
	
}
