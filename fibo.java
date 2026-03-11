import java.util.Scanner;

public class fibo {
        public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a=0;
    int b =1;
    int temp;
    for(int i =1; i<=n;i++){
        temp=b;
        b=a+b;
        a=temp;
        System.out.print(a + "\t" );
    }    
}    
}
