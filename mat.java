public class mat {

 
        public static void main(String[] args) {
        int [] arr = {1,2,4,6,7,8,10};
        int [] arr2 = {2,2,0,6,3,4,10};
        int k = 4;

        dupli(arr, arr2, k);
     

    
}
    static void dupli(int[] arr,int [] arr2,int k){

  
        if (arr.length==arr2.length){
        for (int i = 0; i < arr.length; i++) {
                
                if (arr[i]-arr2[i]==k){
                      
                      System.out.println(arr[i]+":"+arr2[i]);

                }
            }   
            }

        }



        
    }
    

    

