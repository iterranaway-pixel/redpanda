import java.util.*;
public class linearsearch {
       public static void main(String [] args) {
    int arr[]= {2,3,4} ;      
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
  
    // int a=0;
    // int b =1;
    // int temp;
    for(int i =0; i<arr.length;i++){
        // temp=b;
        // b=a+b;
        // a=temp;
        // System.out.print(a + "\t" );
        if (x == arr[i]){
            System.out.println(i);
            
             
        } 
    }    
} 
    
}
