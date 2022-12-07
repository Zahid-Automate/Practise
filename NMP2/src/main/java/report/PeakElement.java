package report;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={13,3,5,20,10,-1,-100};
        int n=arr.length;
        int max = arr[0];
        for (int i=0;i<n;i++) {
            if (arr[i] > max)
            max = arr[i];
        }
        System.out.println(max);
        PeakElement p1 = new PeakElement();
        p1.removeDuplicatesInArray();
        p1.removeRepeatedChar();
       
    }
    
    public void removeDuplicatesInArray() {
        ArrayList<Integer> list = new ArrayList<>(Arrays
                .asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
        // Print the Arraylist
        System.out.println("ArrayList with duplicates: "+ list);
        // Remove duplicates
        // Create a new ArrayList
        ArrayList<Integer> newList = new ArrayList<Integer>();
        // Traverse through the first list
        for (int element : list) {
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        System.out.println(newList);
    }
    
    public void removeRepeatedChar() {
        String str ="aaabbbcccd";
        StringBuilder sb = new StringBuilder();
        if(!str.isEmpty()) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            sb.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i - 1]) {
                    sb.append(chars[i]);
                }
                System.out.println(sb);
            }
        }
    }
   
}
