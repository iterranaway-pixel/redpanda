import java.util.*;
public class ad1{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int f=sc.nextInt();
        int[] arr=new int[f];
        for(int i=0; i<f; i++){
            arr[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0; i<n; i++){
            arr1[i]=sc.nextInt();
        }
        int l=n+f;
        int[] arr2=new int[l];
        int i=0;
        int j=0;
        for(int k=0;k<(n*f);k++){
            if(arr[i]<arr1[j]){
                arr2[k]=arr[i];
                i++;
            }else{
                arr2[k]=arr1[j];
                j++;
            }
        }
        for(int k=0;k<(n+f);k++){
            System.out.print(arr2[k]+" ");
        }
        sc.close();

    }
}