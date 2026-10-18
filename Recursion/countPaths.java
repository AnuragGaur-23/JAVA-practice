package Recursion;
//Count the total number of paths to move from (0,0) to (n,m)
import java.util.*;
public class countPaths{
    public static int countPaths(int n,int m,int i,int j){
        if(i==n || j==m){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        return countPaths(n, m, i+1, j)+countPaths(n, m, i, j+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int n=sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int m=sc.nextInt();
        System.out.println("Total paths : "+countPaths(n, m, 0, 0));
    }
}