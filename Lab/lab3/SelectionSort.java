import java.util.Scanner;  
      
    public class SelectionSort
    {  
       public static void main(String args[])  
       {  

          Scanner c = new Scanner(System.in);

          System.out.println("Enter number of element in the array:");

          int len = c.nextInt();

          int arr [] = new int [len];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

          System.out.println("Element before sorting:");

          for (int i = 0; i<len;i++)
          {

            int j = c.nextInt();

            arr [i] = j;
          } 

           for(int i=0; i<len; i++)  
           {  
               for(int j=i+1; j<len; j++)  
               {  
                   if(arr[i] > arr[j])  
                   {  
                      int temp = arr[i];  
                      arr[i] = arr[j];  
                      arr[j] = temp;  
                   }  
               }  
           }  
             
           System.out.print("Element after sorting:\n");  
           for(int i=0; i<len; i++)  
           {  
               System.out.print(arr[i]+ "  ");  
           }  
       }  
    }  