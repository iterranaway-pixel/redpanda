import java.util.*;
public class sumdistinct {
        public static void main(String[] args) {
        int [] arr = {1,2,4,6,7,8,10,10};
        dupli(arr);
    
}
    static void dupli(int[] arr){
        int n=arr[arr.length-1];
        HashSet<Integer> seen = new HashSet<>();

        int sum = 0;
        for (int num:arr){
            if(seen.add(num)){
                sum+=num;


            }
            
        }


        System.out.println(sum);


        
    }
    
}
