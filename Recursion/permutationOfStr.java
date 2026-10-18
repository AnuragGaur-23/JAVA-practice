package Recursion;
import java.util.Scanner;

public class permutationOfStr {
    public static void PrintPermutation(String str,int idx,String perm){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            PrintPermutation(newStr,idx+1,perm+currChar);
        }
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            String str=sc.next();
            PrintPermutation(str,0,"");
        }
    }
}
