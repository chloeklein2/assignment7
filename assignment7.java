import java.util.Random;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
public class assignment7 {

    public static int[] createRandomArray(int arrayLength){
        Random rand = new Random();
        int i;
        int[] ra= new int[arrayLength];
        for  (i=0; i<arrayLength;i++){
            int num= rand.nextInt(100);        
            ra[i]=num;
            
        }
        return ra;
    }
    public static void writeArrayToFile(int[] array, String filename) throws IOException{
        FileWriter writer = new FileWriter(filename);
        BufferedWriter buffer = new BufferedWriter(writer);            
        
        buffer.write(Arrays.toString(array));       
        buffer.close();
    }
    public static int[] readFileToArray(String filename) throws Exception{
        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        int lines=0;
        while (line!=null) lines++;
        int[] arr = new int[lines];
        for  (int i =0; i<lines; i++){
            line = br.readLine();
            arr[i]=Integer.parseInt(line);
            
        }
        reader.close();
        return arr;         

    }
    public static void bubbleSort(int[] arr, int n){
        if (arr == null || n <=1){
            return;
        }
        for (int i =0; i<n; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr [i +1];
                arr[i+1]=temp;
            }
        }
        bubbleSort(arr, n-1);
    }
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.println("if you wish to generate and sort an array please enter");
        System.out.println("if you wish to read and sort an array from a file please press 2");
        int user = scnr.nextInt();
        if (user == 1){
            System.out.println("please input the desired array length");
            int num=scnr.nextInt();
            int[] arr = createRandomArray(num);
            System.out.println("array before sorting:");
            System.out.println(Arrays.toString(arr));
            System.out.println("array after sorting:");
            bubbleSort(arr, arr.length-1);
            System.out.println(Arrays.toString(arr));
            System.out.println("please enter the desired name for the sorted array to be saved to");
            String filename= scnr.next();
            writeArrayToFile(arr, filename);
        }
        if (user==2){
            System.out.println("please enter the file name");
            String filename = scnr.next();
            int[] arr= readFileToArray(filename);
            System.out.println("array before sorting:");
            System.out.println(Arrays.toString(arr));
            System.out.println("array after sorting:");
            bubbleSort(arr, arr.length-1);
            System.out.println(Arrays.toString(arr));
            System.out.println("please enter the desired name for the sorted array to be saved to");
            String name= scnr.next();
            writeArrayToFile(arr, name);

        }
        scnr.close();
    }
}