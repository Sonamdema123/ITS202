import java.util.*;
public class BubbleSort{
    public static void Bubble(int arr[])
    {
        int n = arr.length;   
        for(int i=0; i < n; i++)
        {  
            for(int j=1; j < (n-i); j++)
            {  
                if(arr[j-1] > arr[j])
                {  
                int temp = arr[j-1];  
                arr[j-1] = arr[j];  
                arr[j] = temp;  
                 }  
             }  
        }  
    }
    public static void printarray(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
     
    Scanner cin =new Scanner(System.in);  
    System.out.println("Enter the number of elements in the array:");  
    int n=cin.nextInt(); 

    int[] arr = new int[n]; 

    System.out.println("Enter "+n+" elements:");  
    
    for(int i=0; i<n; i++)  
    {  
        arr[i]=cin.nextInt();
    }
 
        System.out.println("Element before sorting: "); 
        printarray(arr);
        Bubble(arr);
        System.out.println( "\nElement after sorting: "); 
        printarray(arr);    
    }
}