
import java.util.HashSet;


class missing{
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,6,6};
        dupli(arr);
    
}
    static void dupli(int[] arr){
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();
        for(int num:arr){
            if (!seen.add(num)){
                dups.add(num);
            }

        }
        System.out.println(dups);


        
    }

}
