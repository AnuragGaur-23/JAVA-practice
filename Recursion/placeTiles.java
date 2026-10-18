package Recursion;
//Place tiles of size (1 x m) in a floor of size (n x m)
import java.util.*;
public class placeTiles{
    public static int countTilePlacements(int n, int m){
        if (n==m) {
            return 2; //tiles can only be placed either vertically or horizontally so 2 ways
        }
        if(n<m){
            return 1; //tiles can only be placed horizontally now so only 1 case possible 
        }
        //vertically 
        int verticalPlacements = countTilePlacements(n-m, m);
        //horizontally 
        int horizontalPlacements = countTilePlacements(n-1,m);
        return verticalPlacements + horizontalPlacements;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            System.out.print("Enter the value of n :");
            int n=sc.nextInt();
            System.out.print("Enter the value of m :");
            int m=sc.nextInt();
            System.out.println("Number of ways the 1xm tiles can be placed on nxm floor are : "+placeTiles(n,m));
        }    
    }
}