package sortingAlgs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	static int count = 0;
	public static void swap(int[] arr, int left, int right) {
		if (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}

	}

	public static int partition(int[] a, int left, int right) {
		int pivot = a[left];
		int i = left - 1;
		int j = right + 1;
		int k = 0;

		for (; k < a.length; k++) {
			i++;
			while (a[i] < pivot) {
				count++;
				i++;
			}
			j--;
			while (j > left && a[j] > pivot) {
				count++;
				j--;
			}
			if (i < j)
				swap(a, i, j);
			else
				return j;
		}
		return k;
	}

	public static void quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int p = partition(arr, left, right);
			quicksort(arr, left, p);
			quicksort(arr, p + 1, right);

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//int c =
		System.out.println("Specify file with path to be read:");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		scan.close();

		BufferedReader file = new BufferedReader(new FileReader(userInput));
		
		String i;
		ArrayList<Integer> array = new ArrayList<Integer>();
		while ((i = file.readLine()) != null) {

			array.add(Integer.parseInt(i));
		}
		int in[] = new int[array.size()];
		for (int j = 0; j < array.size(); j++) {
			in[j] = ((Integer) array.get(j)).intValue();
		}
		double start = System.currentTimeMillis();
		quicksort(in, 0, in.length - 1);
		double end = System.currentTimeMillis();
		double time =end - start;
		System.out.println("total time is:" + time);
		System.out.println(Arrays.toString(in));
		System.out.print("total comparisons:"+count);
	}

}
