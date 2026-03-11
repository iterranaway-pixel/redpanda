import java.util.*;
public class bubble {


    public static void main(String[] args) {
        int [] arr ={36,19,29,12,9};
        bs(arr);
        for(int num:arr){
            System.out.println(num);

        }

    }
    static int[] bs(int []arr){
        // int temp;
        int n= arr.length;
        for (int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if (arr[j] > arr[j + 1]) {
                int temp =arr[j];
                arr[j]= arr[j+1];
                arr[j+1]=temp;
                }

            }
        
        }
        return arr;
    }
    
}
