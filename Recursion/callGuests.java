package Recursion;
//Find the number of ways in which you can invite n people to your party in single or in n pairs 
import java.util.Scanner;
public class callGuests {
    public static int countWays(int n){
        if(n<=1){ //stops the error of index out of bound exception
            return 1; //if there is only 1 guest then the no.of ways to call is 1 only 
        }
        //single guest
        int ways1=countWays(n-1); //selects and calls guests one by one 
        //paired guest 
        int ways2=(n-1)*countWays(n-2); //selects pair of guest from n-1 people and then give call to the rest of n-2 people
        return ways1 + ways2;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            System.out.print("Enter the number of guests : ");
            int n = sc.nextInt();
            System.out.println("The number of ways of calling guests are : "+countWays(n));
        }
    }
}
