package Intermediate;

import java.util.Scanner;

public class INT04_Arrays1 {
    public static void main (String[] args) {

        // Creating An Array using user input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

    }

    // Printing an Array Elements
    public static void printArray (int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // TC = O(N) && SC = O(1)


    /*
     *  Q1: Given N Array Elements, Count No. of Elements having atleast 1 element greater than itself
     *      ex: arr[7] = {-3, -2, 6, 8, 4, 8, 5}    --> Ans = 5 --> {-3, -2, 6, 4, 5}
     *          arr[8] = {2, 3, 10, 7, 3, 2, 10, 8} --> Ans = 6 --> {2, 3, 7, 3, 2, 8}
     *          arr[8] = {8, 8, 8, 8}               --> Ans = 0
     * 
     * 
     *  Obs:    Largest Array Element cannot have any other element greater than it
     *          Rest of the Elements will have atleast 1 greater element, which is Largest Array Element
     * 
     *  STeps:
     *      1. Iterate & get the count of Max elements, [ let's say count = c ]
     *      2. Ans = Toatl Number of Array Elements - c
    */
    public static void countElementsGreaterThanItself (int[] arr) {
        // Total No. of Elements
        int n = arr.length;

        // max element
        int max = arr[0];
        for (int i=1; i<n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // count No. of max elements
        int countMax = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == max) {
                countMax++;
            }
        }

        int ans = n - countMax;
        System.out.println(ans);
    }
    /*
     *  TC = O(N) && SC = O(1)
     *  Optimization -> This is the best TC
     *  why..? -> we need to go through each element at least once to find out the ans
     *            Hence it will definitely take O(N) 
    */

    // HW --> Try to solve the above Q in a Single for Loop



    /*
     *  Q2: Given N Array Elements, Check if there exists a Pair [i, j] such that arr[i]+arr[j]==k && i!=J
     *      EX: arr = {3, -2, 1, 4, 3, 6, 8}    k = 10      ans: true [i=3, j=5]
     *          arr = {2, 4, -3, 7}             k=5         ans: false
     *          arr = {2, 4, -3, 7}             k=8         ans: false
    */
    public static boolean pairSum (int[] arr, int k) {
        int n = arr.length;

        /*
         *  Brute Force : Make all pairs & check sum
         *      n = 4       -->         
         *      i=0     j=0->3          [0,0] [0,1] [0,2] [0,3]
         *      i=1     j=0->3          [1,0] [1,1] [1,2] [1,3]
         *      i=2     j=0->3          [2,0] [2,1] [2,2] [2,3]
         *      i=3     j=0->3          [3,0] [3,1] [3,2] [3,3]
         * 
         *      - here, we don't require i==j cases 
        */
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i]+arr[j]==k && i!=j) {
                    return true;
                }
            }
        }
        // TC = O(N*N)  SC = O(1)       [ No. of Iteartions = N^2 ]

        /*
         *  Brute Force Optimized : Make all unique pairs & check sum
         *      - From the above Brute's Force algo, we remove the duplicate
         *      - i.e., only take the upper (or) Lower triangle from the matrix
         *      n = 4
         *      i=0     j=1->3          [0,1] [0,2] [0,3]
         *      i=1     j=2->3                [1,2] [1,3]
         *      i=2     j=3->3                      [2,3]
        */
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i]+arr[j] == k) {
                    return true;
                }
            }
        }
        /*
         *      i          j           Total Iteration in that loop
         *      0       [1, n-1]            n-1
         *      1       [2, n-1]            n-2
         *      2       [3, n-1]            n-3
         *      .       .                   .       
         *      .       .                   .
         *      n-2     [n-1, n-1]          1
         *                              -----------
         *                  Total iterations = 1+2+3+...+(n-3)+(n-2)+(n-1) == sum of 1st (N-1) terms
         *                                   = (N-1)([N-1]+1)/2
         *                                   = N(N-1)/2
         * 
         * 
         *      TC = O(N*N)  && SC = O(1)
         * 
         *  NOTE:
         *      - As both the Algo's TC is same, we will go with Iterations
         *      - Hence, Algo-2 is Better Algo
        */

        return false;
    }


    /*
     *  Q3: Given an Array, Reverse the entire Array [ Array itself should change ]
     *      EX: arr[8] = {-1, 4, 7, 3, 9, 2, 10}
     *          Ans = {10, 2, 9, 3, 7, 4, -1}
     * 
     *  Sol: Two Pointer
     *      - Make 2 pointers i & j at start & end of the element respectively
     *      - now swap the 2 elements
     *      - increase & decrease the i & j respectively to move to Inner elements
     *  EX:
     *          1st    -1, 4, 7, 3, 9, 2, 10
     *                  i                  j       -> Swap these 2 elements
     * 
     *          2nd     10, 4, 7, 3, 9, 2, -1
     *                      i           j           -> Swap
     * 
     *          3rd     10, 2, 7, 3, 9, 4, -1  
     *                         i     j              -> Swap
     * 
     *          4th     10, 2, 9, 3, 7, 4, -1
     *                           i,j                -> Exit
     * 
    */
    public static void arrayReverse (int[] arr) {
        int n = arr.length;

        // 2 Pointer Approach
        int i=0, j=n-1;

        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; j--;
        }
        // TC = O(N) || SC = O(1) || Iterations = N/2


        // My Approach
        for (int p=0; p<n/2; p++) {
            int temp = arr[p];
            arr[p] = arr[n-1-p];
            arr[n-1-p] = temp;
        }
        // TC = O(N) || SC = O(1) || Iterations = N/2
    }



    /*
     *  Q4: Given N Array Elements & [s, e] where s<=e, Reverse the Array from s to e [ Array itself should change ]
     *      EX: arr[8] = {-1, 4, 7, 3, 9, 2, 10, -3, 14, 6}     s=3 e=7
     *          Ans = {-1, 4, 7, -3, 10, 2, 9, 3, 14, 6}
    */
    public static void subArrayReverse (int[] arr, int s, int e) {
        int i = s, j = e;

        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; j--;
        }
    }



    /*
     *  Q5: Gievn N Array Elements, Rotate array from Last to First by k times [ Google & Amazon ]
     *      EX: 
     *      1.) arr[8] = {-1, 4, 7, 3, 9, 2, 10}        k=3
     *              for k=1     ->      10, -1, 4, 7, 3, 9, 2
     *              for k=2     ->      2, 10, -1, 4, 7, 3, 9
     *              for k=3     ->      9, 2, 10, -1, 4, 7, 3
     *          ans = {9, 2, 10, -1, 4, 7, 3}
     *      
     *      2.) arr[9] = {4, 1, 6, 9, 2, 14, 7, 8, 3}    k=4
     *          ans: {14, 7, 8, 3, 4, 1, 6, 9, 2}
     * 
     *      3.) arr[4] = {2, 5, 3, 7}       k=6
     *          ans: {3, 7, 2, 5}
     * 
     *  Sol: let arr = {a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12}    k = 5
     * 
     *      initial -> a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12
     *      Final   -> a8, a9, a10, a11, a12, a0, a1, a2, a3, a4, a5, a6, a7
     * 
     *      Obs: Last k elements will be moved to First
     * 
     *      1. Seperate the last k elements -> a0, a1, a2, a3, a4, a5, a6, a7 | a8, a9, a10, a11, a12
     *      2. Reverse the entire array     -> a12, a11, a10, a9, a8 | a7, a6, a5, a4, a3, a2, a1, a0
     *      3. Reverse the 1st array part   -> a8, a9, a10, a11, a12 | a7, a6, a5, a4, a3, a2, a1, a0
     *      4. Reverse the last array part  -> a8, a9, a10, a11, a12 | a0, a1, a2, a3, a4, a5, a6, a7
     *      5. Got the ans
     * 
     *  NOTE:
     *      - The above works only when k<n
     *      - If k>n -> It faile
     *      - Hence --> k=k/n
    */
    public static void arrayReverseKTimes (int[] arr, int k) {
        if (k == arr.length) {
            return;
        }
        
        if ( k > arr.length) {
            k = k%arr.length;
        }

        // Reverse the entire array
        int i=0, j=arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; j--;
        }

        // reverse the 1st part
        i=0; j=k-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; j--;
        }

        // reverse last part
        i=k; j=arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; j--;
        }
    }
    // TC = O(N) || SC = O(1) || Iterations = N/2 + K/2 + (N-k)/2 == N
}
