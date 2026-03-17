import java.util.*;
public class number {

    // 1. Check if a Number is Prime: 
// Problem: Write a function to check if a given number is prime. 
// Input: Number: 29 
// Output: True 
// Explanation: 29 is a prime number

    public static void main(String[] args) {
        int n = 29 ; 
        boolean isprime = true ;

        for(int i =2 ; i< n ; i++){
            if(n%i ==  0){
                isprime = false ;
                break ;
            }
        }

        if(isprime){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }
}


