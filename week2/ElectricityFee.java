import java.util.*;
import java.math.*;
public class ElectricityFee{
   final static float fee1 = 0.538f;
   final static float fee2 = 0.568f;
   final static float fee3 = 0.638f;

   public static float getFee(int num_of_electricity){
       if(num_of_electricity <= 50){
           return num_of_electricity * fee1;
       }
       if(num_of_electricity <= 200){
           return (num_of_electricity-50) * fee2 + 50 * fee1;
       }
       return (num_of_electricity-200) * fee3 + 50 * fee1 + 150 * fee2;
   }

   public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
           int   input  = in.nextInt();
           float output = getFee(input);
           System.out.printf("您应缴纳的电费为: %.3f\n",output);
       }
   }


}
