package org.hackathon.samples;

public class MergeSortedArrays {
	public static void main(String[] args) {

		int a[] = { 1, 3, 5, 9, 12 };
		int b[] = { 2, 3, 6, 11, 13, 14, 15 };

		mergeSortArrays(a, b);
		
		mergeSortArraysSinglewhile(a, b);

	}

	private static void mergeSortArrays(int[] a, int[] b) {
		int i = 0, j = 0, k = 0;
		int[] c = new int[a.length + b.length];

		while ((i < a.length) && (j < b.length)) {
			c[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}
		System.out.println("Merge sort array with Three while loops");
		for (int element : c) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
/////////////////////////////////////////////////////////////////////
	private static void mergeSortArraysSinglewhile(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = a.length-1, j = b.length-1, k = c.length;

		while(k>0)
			c[--k]=(j<0 || (i>=0 && a[i] >= b[j])) ? a[i--] : b[j--];
		
			System.out.println("Merge sort  with Single while loop");
			for(int element: c){
				System.out.print(element+" " );
			}
			
			System.out.println();
	}
}
