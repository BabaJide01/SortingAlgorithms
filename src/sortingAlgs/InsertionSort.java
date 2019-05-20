package sortingAlgs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort {
	
	static int count = 0;
	public static void RecSort(int[] arr,int elements){
		//count = 0;
		if (elements <= 0)
				return;
		else{
			
		RecSort(arr,elements-1);
			int lastE = arr[elements-1];
			int n = elements-2;
			while(n >= 0 && arr[n] > lastE){
				arr[n+1]=arr[n];
				n--;
				count++;
			}
			
				arr[n+1]=lastE;
				//System.out.print(count);
	}	
	
	}
	
	public static void main(String[] args) throws IOException {
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
		file.close();
		double start = System.currentTimeMillis();
		RecSort(in,in.length);
		double end = System.currentTimeMillis();
		double time =end - start;
		System.out.println("total time is:" + time);
		System.out.println(Arrays.toString(in));
		System.out.print("total comparisons:"+count);
	
	}
	

}

