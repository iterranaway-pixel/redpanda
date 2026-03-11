import java.util.*;
public class factorial {
        public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int s=1;

    for(int i =n; i>0;i--){
        s*=i;
    }
    System.out.println(s);
}
    
}
