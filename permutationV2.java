package permutation;

import java.util.Arrays;
public class permutationV2 {
	
	public static void main(String[]args) {
		long startTime = System.nanoTime();
		permute("aasdkjkan","hhhlajkjgabckkkkcbakkdfjknbbca");
	    long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        double milliseconds = totalTime / 1000000.00;
		System.out.println("Run-time duration is of: "+milliseconds+"ms");
	}
	public static void permute(String shortStr, String longStr){
        char[] temp = shortStr.toCharArray();
        // Step 1. Sort the string
        Arrays.sort(temp);
        int foundIndex = longStr.indexOf(String.valueOf(temp));
        if (foundIndex != -1)
    		System.out.println("Found one match: " + shortStr +  " is in " + longStr + " at location " + foundIndex);
        System.out.println("String " + String.valueOf(temp));
        int index = 0;
        int lowest = 0;
        while(true){  
            // Step 2. Rightmost char smallest than its neighbour
            for(int i = 0; i < temp.length - 1; i++){
                if(temp[i] < temp[i+1]){
                    lowest = i;               
                }
            }
            
            // index of CHAR1
            index = lowest;
            // Step3. Find the smallest character which is greater than the index
            int j = findCeiling(temp, index);
            // Breaking condition at this juncture
            // all permutations are printed
            if(j == index) break;
            
            swap(temp, index, j);
            String a = String.valueOf(temp);
            // Step4. Sort the substring
            char[] b = a.substring(index + 1).toCharArray();
            Arrays.sort(b);
            a = a.substring(0, index + 1) + String.valueOf(b);
            temp = a.toCharArray();
            System.out.println(String.copyValueOf(temp));
            foundIndex = longStr.indexOf(String.valueOf(temp));
            if (foundIndex != -1)
        		System.out.println("Found one match: " + shortStr +  " is in " + longStr + " at location " + foundIndex);
            System.out.println( "String " + String.valueOf(temp));
            //}
        }                        
    }
	/**
	 * 
	 * @param temp char [] parameter attribute to set calling object to
	 * @param index parameter to set calling object to
	 * @return will return respective index
	 */
	/*The findCeiling function will return the index of the smallest character
		after the indicated index in the given array.
	*/
	public static int findCeiling(char[] temp, int index){
        int k = index; 
        char test = temp[index];
        while (k < temp.length - 1){
            if(temp[index] < temp[k + 1]){ //if the character is smaller than the char of the given index
                index = k + 1; 
                break;
            }
            k++;
        }
        k = index;
        while (k < temp.length - 1){ //check if it is indeed the smallest char bigger than the corresponding char of given index
            if((temp[index] > temp[k + 1]) && (temp[k + 1] > test)){
                index = k + 1;
            }
            k++;
        }
        return index;
    }
	
		/**
		 * 
		 * @param str parameter attribute to set calling object's to
		 * @param i parameter attribute to set calling object's to
		 * @param j parameter attribute to set calling object's to
		 */
	//swap function to swap content of two elements in an array
	  private static void swap(char[] str, int i, int j){
	        char temp = str[i];
	        str[i] = str[j];
	        str[j] = temp;
	    }
}
