package computerScience.algorithms.sort;

public class BubbleSort { // O(n^2)
	
	public static void bubble_sort(int[] arr) {
		bubble_sort(arr, arr.length);
	}

	private static void bubble_sort(int[] arr, int size) {
		if (size > 0) {
			for(int i=1; i<size; i++) {
				if(arr[i-1] > arr[i]) {
					swap(arr, i-1, i);
				}
			}
			bubble_sort(arr, size-1);
		}
	}

	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,6,1,5,7};
		printArray(arr);
		bubble_sort(arr);
		printArray(arr);
	}
}
