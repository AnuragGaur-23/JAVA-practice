//MERGE SORT IS BASED ON DIVIDE AND CONQUER RULE
public class MergeSort {

    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1]; //indexing starts from zero that's why we used +1
        int idx1 = si;   //tracks first divided array
        int idx2 = mid + 1;   //tracks second divided array
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {   //comparing elements of both divided arrays and putting them into the merged array which is now sorted 
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {   //if the no. of elements are not equal in the divided array then we have to use these single while statements to sort them into merged array
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {  //same as above single while statement
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i]; //copying the merged array into the original array 
        }
    }

    public static void divide(int arr[], int si, int ei) {
        //base case
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;  //(si + ei) / 2 causes integer overflow for large indices (time/space complexity remains identical).
        divide(arr, si, mid);  //divided array 1 from starting index si to mid 
        divide(arr, mid + 1, ei); //divided array 2 from the next element after mid to the ending index ei
        conquer(arr, si, mid, ei);  //calling conquer to join divided array 1 and 2 after sorting 
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n - 1); //si is 0 and make sure the ei is n-1 not n
        //printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}