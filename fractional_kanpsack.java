import java.util.Arrays;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
import java.util.Arrays;
class item
{
    double value;
    double weight;
    item(int value,int weight)
    {
        this.value=value;
        this.weight=weight;
    }
}

public class fractional_knapsack {
    
    public static void main(String[] args) {
        Comparator<item> c;
        c = new Comparator<item>() {
            
           @Override
           public int compare(item a1, item a2) {
             double r1= (a1.value/a1.weight);
             double r2= (a2.value/a2.weight);
           if(r1>r2)
               return -1;
           else
               return 1;
             //      return 0;

                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            } 
            
        };
        item arr[]= new item[3];
        arr [0]= new item(60,10);
        arr [1]= new item(120,30);
        arr [2]= new item(100,20);
     
        Arrays.sort(arr,c);
        
     for(int i=0;i<3;i++)
     {
         System.out.println((double)(arr[i].value/arr[i].weight));
     }
     double profit=0.0;
     int knapsack=50;
     for(int i=0;i<3 ;i++)
     {
         if(arr[i].weight<=knapsack && knapsack>0)
         {
             profit+=arr[i].value;
             
             knapsack-=arr[i].weight;
             System.out.println(profit+"  "+knapsack+":");
         }
         else
         {
             double temp=arr[i].value/arr[i].weight;
             profit+=temp*knapsack;
             knapsack-=knapsack;
         }
         
     }
        System.out.println("maximized profit: "+profit);
        
    }
}
