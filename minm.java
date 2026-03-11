import java.util.*;
public class minm {
    public static void main(String[]args){
        int [] arr = {10,3,6,8,15};
        mini(arr);


    }
    static void mini(int [] arr){
        Arrays.sort(arr);
        int min_diff=Integer.MAX_VALUE;
        int max_diff=arr[arr.length-1]-arr[0];
        for (int i =1 ;i<arr.length;i++){
            min_diff=Math.min(min_diff,arr[i]-arr[i-1]);

        }
        System.out.println(min_diff);
        System.out.println(max_diff);

    }
}
