import java.util.HashSet;
import java.util.*;
public class missingq {
        public static void main(String[] args) {
        int [] arr = {1,2,4,6,7,8,10};
        dupli(arr);
    
}
    static void dupli(int[] arr){
        int n=arr[arr.length-1];
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();
        for (int num:arr){
            seen.add(num);
            
        }


        for (int i = 1 ; i<= n ; i++){
            
            if (seen.add(i)){
                dups.add(i);
              }
        }
        System.out.println(dups);


        
    }
    
}
