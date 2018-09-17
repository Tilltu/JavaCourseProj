import java.time.*;
import java.util.*;
import java.math.*;
public class Population {
   private long pop = 312032486;

   void humanBorn(){
       pop++;
   }
   void humanDie(){
       pop--;
   }
   void humanImmigrant(){
       pop++;
   }
   static long humanBornPerDay(){
       return (long)(24*60*60/7.0);
   }
   static long humanDiePerDay(){
       return (long)(24*60*60/13.0);
   }
   static long humanImmigrantPerDay(){
       return (long)(24*60*60/45.0);
   }
   void alterPopulation(long num){
       pop += num;
   }
   public static void main(String [] args){
       int year;
       Population p = new Population();
       for(year = 1;year <= 5; year++){
           p.alterPopulation(year * 365 * (humanBornPerDay() + humanImmigrantPerDay() - humanDiePerDay()));
           System.out.println("The approximate population in "+ year + " year " + "is " + p.pop);
       }

   }

}

