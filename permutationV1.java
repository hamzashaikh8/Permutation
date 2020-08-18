package permutation;


public class permutationV1{

	private String longStr;
	
	public static void main(String[] args) 
    { 
		long startTime = System.nanoTime();
        String shortString = "ckkkkabcde";
        String longString = "hhhlajkjgabckkkkcbakkdfjknbbca";
        int n = shortString.length(); 
        permute(longString, shortString, 0);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        double milliseconds = totalTime / 1000000.00;
        System.out.println("Your total time: " + milliseconds + " ms" );
    }
	
	
    /** 
     * permute function 
     * @param String shortStr - the string to be searched for in the long string
     * @param int leftIndex - the leftmost index that will be swapped in the string
     */
	//The time complexity of this function is of O(n!)
    private static void permute(String longStr, String shortStr, int leftIndex) { 
        if (leftIndex == shortStr.length()) {
            System.out.println(shortStr);
        	int foundIndex = longStr.indexOf(shortStr);
        	if(foundIndex != -1) {
        		System.out.println("Found one match: " + shortStr +  " is in " + longStr + " at location " + foundIndex);
        	}
        }
        else { 
            for (int i = leftIndex; i < shortStr.length(); i++) { 
                String swapped = swap(shortStr,leftIndex,i);
                permute(longStr,swapped, leftIndex + 1);
            } 
        }
    }
  
    /** 
     * Regular swap method to swap characters at indices I and J
     * 
     * @param String a - string that will have two of its characters swapped
     * @param int i - first swapped index in the string
     * @param int j - second swapped index in the string
     * @return string with both characters swapped
     */
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }
}

