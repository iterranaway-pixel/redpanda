import java.util.*;
public class maxf {
    public static void main(String[] args) {
        int [] arr = {1,2,4,6,7,8,10,2};
        mf(arr);

    }
    static void mf(int[]arr){
        HashMap<Integer,Integer> Freq = new HashMap <>();
        for(int num:arr){
            Freq.put(num,Freq.getOrDefault(num, 0)+1);
        }
        int mcnt=0;
        int m=arr[0];
        for (int num:Freq.keySet()){
            if(Freq.get(num)>mcnt){
                  mcnt=Freq.get(num);
                  m=num;
        }

        }
              System.out.println(m);
    }   
       
    
}
