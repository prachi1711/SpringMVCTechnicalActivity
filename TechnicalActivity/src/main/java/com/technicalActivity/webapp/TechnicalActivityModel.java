package com.technicalActivity.webapp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TechnicalActivityModel
{
	
	/**Method converts the semicolon seperated list of integers to the ArrayList of integers and also removes the duplicates
	 * @param strList : semicolon seperated list of integers entered by user
	 * @return : ArrayList of integers
	 */
	public ArrayList<Integer> createListAndRemoveDuplicates(String strList)
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		String[] strArr = strList.split(";");
		for(int i = 0; i<strArr.length; i++)
		{
			if(!inputList.contains(Integer.parseInt(strArr[i])))	// Complexity is O(N) where N is the total number of elements in list
			inputList.add(Integer.parseInt(strArr[i]));			   // Complexity is O(1) as lookup in ArrayList is done in constant time
		}
		
	  return inputList;
	}
	
	/** Method sorts the input list and finds the Nth largest element from it
	 * @param inputList : List of integers
	 * @param N : Nth largest element to find in the list
	 * @return : Nth largest integer
	 */
	public int searchNthLargetElement(ArrayList<Integer> inputList, int N)
	{
		int nthMaxNo = 0;		
		Collections.sort(inputList);                        // Complexity is O(NlogN) where N is the total number of elements in the list		
		nthMaxNo = inputList.get(inputList.size()-N);		//Complexity is O(1) as look up in ArrayList is done in constant time
		return nthMaxNo;
	}
	
	/** Method checks if the integer N entered is valid
	 * @param n : Nth largest element to find in the list
	 * @param inputListSize : Size of the list of integers
	 * @return : true if valid, false if not valid
	 */
	public boolean checkNValidity(int n, int inputListSize)
	{
		if(n <= 0 || n > inputListSize) // check for Nth integer value : should be greater than 0 and less than the list size 
		{
			 return false;
		}
		return true;
	}
	
	/** Method checks if the input string is in a correct format
	 * @param inputString: String input by the use
	 * @return : true if valid, false if not valid
	 */
	public boolean checkInputStringValidity(String inputString)
	{
		if(inputString.matches("[0-9]+(;[0-9]+)*")) // to check if the string list entered is in valid format
		{
			return true;
		}
		return false;
	}
			    	 	    		 	    				
}