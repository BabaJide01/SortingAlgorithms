package sortingAlgs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	static int count =0;
	
	public static int[] Splitter(int[] Array) {
		  if(Array.length == 1) {
		    return Array;
		  }
		  int mid =Array.length/2;
		  int[] leftside = new int[mid];
		  int[] rightside = new int[Array.length - mid];
		  for(int i=0, j=0; i<Array.length-1; i+=2,j++)
		     {
			  leftside[j]=Array[i];
			  rightside[j]=Array[i+1];
		     }
		  if(Array.length%2==1)
			  rightside[mid]=Array[Array.length-1];
		  Splitter(leftside);
		  Splitter(rightside);
		  merge(leftside, rightside, Array);
		  //count++;
		  return Array;
		}
	
	
	 public static void merge(int[] onehalf, int[] sechalf, int[] Arraysorted) {
			  int leftArrayLength = onehalf.length;
			  int rightArrayLength = sechalf.length;
			  int i = 0; 
			  int j = 0;
			  int k=0;
			  while(i < leftArrayLength && j < rightArrayLength) {
				  count++;
			    if(onehalf[i] < sechalf[j]) {
			    	Arraysorted[k] = onehalf[i];
			      i++;
			   } else {
			    	Arraysorted[k] = sechalf[j];
			      j++;
			  }
			    k++;
			}
			  while(i < leftArrayLength) {
				 count++;
				  Arraysorted[k] = onehalf[i];
				  k++;
			    i++;
			  }
			  while(j < rightArrayLength) {
				  count++;
				  Arraysorted[k] = sechalf[j];
				  k++;
			    j++;
			    
			  }
			}
	public static void main(String[] args) throws IOException{
		System.out.println("Specify file with path to be read:");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		scan.close();
		BufferedReader file = new BufferedReader(new FileReader(userInput));
		
		String i;
		ArrayList<Integer> array = new ArrayList<Integer>();
		while((i = file.readLine()) != null){
			
			array.add(Integer.parseInt(i));
		}
		int in[] = new int[array.size()];
		for(int j = 0 ; j < array.size() ; j++){
		in[j] = ((Integer) array.get(j)).intValue();
		}
		double start = System.currentTimeMillis();
		Splitter(in);
		double end = System.currentTimeMillis();
		double time =end - start;
		System.out.println("total time is:" + time);
		System.out.println(Arrays.toString(in));
		System.out.print("total comparisons:"+count);
	}
	

}
