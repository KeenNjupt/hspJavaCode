// "package" keyword is used to declare the package where
// the current class is located
// The package statement must be placed the first line of file
// A class can have only one package statement
package com.hspedu.pkg;

// import statement must be placed between the package statement
// and the definition of class
import java.util.Arrays;

//import java.util.Scanner; // only import java.util.Scanner class, recommended
//import java.util.*; //import all class in java.util
public class importExercise {
    public static void main(String[] args) {
        int[] arr = {5,8,3,2,4,1,6};
        Arrays.sort(arr); //use Arrays.sort function to sort the int array
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
