import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*

                  abc
abc          bac              cba

 */


public class Solution{

    static int counter=1;

    public static void main(String[] args) {

        String str="mahes";

        printCombinations(str.toCharArray(),0);


    }

    public static void printCombinations(char array[], int startIndex){

        int length=array.length;

        if (startIndex==length){
            System.out.println(" "+counter+" "+ String.valueOf(array));
            counter++;
        }

        for(int i=startIndex;i<length;i++){
            swap(array,startIndex,i);
            printCombinations( array,  startIndex+1);
            swap(array,i,startIndex);
        }

    }

    public static void swap(char array[], int from, int to){

        Character temp=array[from];
        array[from]=array[to];
        array[to]=temp;

    }




}