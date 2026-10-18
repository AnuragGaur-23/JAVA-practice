package Recursion;
//Print all the subsets of a set of first n natural numbers
import java.util.*;  //calling scanner and arraylist
public class findSubset {
    public static void printSubset(ArrayList<Integer> subset){
        for(int i=0;i<subset.size();i++){
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findNumberOfSubset(int n, ArrayList<Integer> subset){
        if(n==0){  //basecase
            printSubset(subset);
            return;
        }
        //gets added
        subset.add(n);  //adds n to the subset 
        findNumberOfSubset(n-1, subset);  //now calls for n-1 numbers and subset
        //not get added
        subset.remove(subset.size()-1);  //removes the last added item from the subset 
        findNumberOfSubset(n-1, subset);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        ArrayList<Integer> subset = new ArrayList<>();  //creating a new arraylist which can be modified
        System.out.println("--- Values of subsets ---");
        findNumberOfSubset(n, subset);
        }
    }
}
//If you run the program and enter 3, the code will output all 2^3 = 8 subsets printed in descending inclusion order
//The 8th subset is the empty set, which prints as a blank line