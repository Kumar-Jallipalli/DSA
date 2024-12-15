import java.util.Arrays;
import java.util.Collections;

public class INT15_Sorting {
    /*
     *  Sorting
     *  -------
     *      - Sorting -> Arranging things in some order
     *      - What can we sort..?
     *              - Numbers
     *              - Strings
     *              - People [ based on characteristics like age etc.. ]
     *              - Algorithms [ based on TC ]
     *      - In what order can we sort..?
     *              - Ascending/Increasing  -> arr[i] < arr[i+1]    => { 0 3 6 8 12 }
     *              - Descending/Decreasing -> arr[i] > arr[i+1]    => { 12 8 6 3 0 }
     *              - Non-Increasing [ Equal or Decreasing ] -> arr[i] >= arr[i+1]  => { 6 5 3 3 2 0 0 }
     *              - Non-Decreasing [ Equal or Increasing ] -> arr[i] <= arr[i+1]  => { 0 0 2 3 3 5 6 }
     *      - On what basis sort happens..?
     *              - value [ asc/desc ]
     *              - Lexicographic [ dictionary order ]
     *              - by key (arbitary property)
     *                      - sort list of people based on height
     *                      - sort list of strings based on length
     *                      - sort list of integers based on absolute values
     *      - Popular Sorting ALgo's
     *              - Bubble
     *              - Selection Sort
     *              - Insertion sort
     *              - Quick sort
     *              - Merge sort
     *              - Heap sort
     *              - Radix sort
     *              - Counting sort
     *              - Bucket sort
     *              - Tim sort [ Won't be DIscussed ]   --> Used by Python & Java Internally
     *              - Shell sort [ Won't be DIscussed ]
     *      - Stable Sorting 
     *              - If 2 elements compared are same and their relative order before & after sorting is also same
    */




    /*
     *  Q1: Elements Removal
     *      Given Integer array, Find the Minimun cost of removing all the elements from the array
     *      Cost of removing the element arr[i] = sum of all the elements left in the array before removing arr[i]
     * 
     *      EX:     arr = { 2   1   4 }
     *              cost of 2 = 2+1+4 = 7           cost of 1 = 2+1+4 = 7       cost of 4 = 2+1+4 = 7
     *              cost of 1 = 1+4 = 5             cost of 4 = 2+4 = 6         cost of 2 = 2+1 = 3
     *              cost of 4 = 4 = 4               cost of 2 = 2 = 2           cost of 1 = 1 = 1
     *              Total Cost = 7+5+4 = 16         Total cost = 7+6+2 = 15     Total cost = 7+3+1 = 11     ans = 11
     *      EX:     arr = { 4   6   1 }
     *              we can remove in 3! ways == 6
     *              4   6   1   -> 11+7+1 = 19
     *              4   1   6   -> 24
     *              1   4   6   -> 11+7+6 = 27
     *              6   4   1   -> 17
     *              6   1   4   -> 11+5+4 = 20
     *              1   6   4   -> 11+10+4 = 25         ans = 17
     * 
     *      Obs:
     *              let arr = { a   b   c   d   e }
     *                  removed             cost            remainig elements
     *                      a               a+b+c+d+e           bcde     
     *                      b               b+c+d+e             cde
     *                      c               c+d+e               de
     *                      d               d+e                 e
     *                      e               e                   -
     *              Toatl cost = (a+b+c+d+e) + (b+c+d+e) + (c+d+e) + (d+e) + e
     *                         = 1*a + 2*b + 3*c + 4*d + 5*e
     *              Here, cost of e is 5 times, since it got removed at 5th step
     *              similarly, cost of c is 3 times, since it got removed at 3rd step
     * 
     *          1. If an element arr[i] is removed at kth step, cost associated with that element arr[i] = k*arr[i]
     *             Hence, the later the element got removed, the more the cost associated with it
     *          2. Hence we will remove the larger elements 1st
     *          3. Hence we will sort the elements in descending order
     * 
     *      Steps
     *      -----
     *          1. sort in descending order'
     *          2. After sorting if the array is {a b c d e},
     *             then rerturn (a*1 + b*2 + c*3 + d*4 + e*5)
    */
    public static void minCost ( int[] arr) {
        // sort in descending order
        Integer[] desc = new Integer[arr.length];
        for (int i=0; i<arr.length; i++) {
            desc[i] = arr[i];
        }
        Arrays.sort(desc, Collections.reverseOrder());

        // logic
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            ans = ans + arr[i]*(i+1);
        }
        System.out.println(ans);
    }
    // TC = O(NlogN) due to sorting || SC = O(N) for Integer array




    /*
     *  Q2: Noble Integers
     *      Given N inetegers, count the No. of Noble Inetegers present
     *      Noble Integer -> X is a Noble Integer, if No. of elements less than X are equal to X
     * 
     *      EX:     arr = { 1  -5  3   5   5   -10   4 }
     *              ans = 4 { elements are 3 5 5 4 }
     * 
     *              arr = { -10  1   1   3   100 }
     *              ans = 3 { elements are 1 1 3 }
     * 
     *              arr = { -3  0   2   5 }
     *              ans = 1 { element is 2 }
     * 
     *      Brute Force:
     *      ------------
     *              - run 2 loops
     *              - count the noble elements
     * 
     *      Obs:
     *          1. Negative elements can never be Noble 
     *          2. for Non repetion case
     *                  - If we sort the array, element's position will give us how many elements < arr[i]
     *                  - Hence, we can directly get the Noble elements while array is sorted
     *                  EX:     arr = { 10  1   3   -5  4   -10 }
     *                       sorted = { -10  -5     1   3   4   10 } 
     *                      ele < i      0   1      2   3   4   5       --> ans - 2
     *                  - Steps:
     *                          - sort the array
     *                          - if arr[i] == i --> Increment the Noble count
     *          3. for Repetitive case
     *                  EX:     arr = { -10     1   1   2   4   4   4   8   10 }    --> Already sorted
     *                         index    0       1   2   3   4   5   6   7   8
     *                      ele <       0       1   1   3   4   4   4   6   7
     *                  - Here also for all the 1st occurence of elements, it is same as non-repetitive case
     *                  - except the 1st occurence of repetitive elements, remaining elements are only failing
     *                  - hence we will use another variable to keep track for repetitve ones 
    */
    public static void nobleIntegers ( int[] arr) {
        int[] arr2 = arr;
        Arrays.sort(arr2);

        int noble = 0;
        int lesser = 0;
        for (int i=0; i<arr.length; i++) {
            if (i>0 && arr2[i]==arr2[i-1]) {
                // This if part tracks the repetitive elements & does nothng
                // Hence, for all the repetitive elements lesser variable will become the index
            }
            else {
                // for all non-repetitive elements, lesser varibale will be updated to index
                lesser = i;
            }

            if (arr2[i] == lesser) {
                noble ++;
            }
        }
        System.out.println( noble );
    }



    /*
     *  Custom Sorting:
     *  ---------------
     *      - Sort the following array based on the No. of Factors
     *              arr = { 49 16 25 30 10 5}
     *          factors =   3  5  3  8  4  2
     *              ans = { 5 49 25 10 16 30 }
     *      - sort the array based on the sum of digits
     *      - sort the string array based on length of string
     *      - etc...
     *      - These type of sorting is called custome sorting where the sorting algo's fail
     *      - In these cases, we use "Comparators"
     *      - Comparator tells machine how to compare 2 things
     * 
     *  Comparators in C++
     *  ------------------
     *      bool compare(int a, int b) {
     *          if a should appear before b then return true
     *          else return false
     *          Caution: if a and b compare equal, then return false
     *      }
     * 
     *      sort(v.begin(), v.end(), compare)   
     *          -> This sort function will sort the array based on the compare function
     * 
     *  Comparators in Java
     *  -------------------
     *      Comparator customComparator = (Integer a, Integer b) -> {
     *          if a should appear before b then return -1
     *          if a and b compare equal, then return 0
     *          else, return 1
     *      }
     * 
     *      Collections.sort (items, customComparator)   
     *          -> This sort function will sort the array based on the compare function
     * 
     *  Comparators in Python (similar to Java)
     *  ---------------------------------------
     *      from functools import cmp_to_key
     * 
     *      def compare(a, b):
     *          if a should appear before b, then return -1
     *          elif a and b compare equal, then return 0
     *          else, return 1
     * 
     *      A.sort(key=cmp_to_key (compare) )
     *          -> This sort function will sort the array based on the compare function
     * 
     * 
     *  EX: Sort the following array based on the No. of Factors
     *              arr = { 49 16 25 30 10 5}
     *          factors =   3  5  3  8  4  2
     *              ans = { 5 49 25 10 16 30 }
     * 
     *  ans: public static boolean compare (int a, int b) {
     *              int fact1 = factors(a);
     *              int fact2 = factors(b);
     *              if (a < b) {
     *                  return true;
     *              } 
     *              else { 
     *                  return false;
     *              }
     *       }
     *      
     *      Collections.sort(arr, compare);
    */
}
