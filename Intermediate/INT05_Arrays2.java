// package Intermediate;

import java.util.Scanner;

public class INT05_Arrays2 {
    public static void main (String[] args) {
    }

    /*
     *  Q1: Given an Array of Size N & Q queries of format s & e
     *      Return the sum of elements from s to e
     *      EX: {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1}    Q=4 
     *              s   e   sum
     *              1   3   12
     *              2   4   12
     *              4   8   9
     *              0   2   5
    */
    public static void arraySumQuery (int[] arr) {
        Scanner sc = new Scanner (System.in);
        int q = sc.nextInt();

        for (int i=1; i<=q; i++) {
            
            int s = sc.nextInt();
            int e = sc.nextInt();

            int sum = 0;

            for (int j=s; j<=e; j++) {
                sum += arr[j];
            }

            System.out.println(sum);
        }

        // Closing resource leak
        sc.close();
    }
    // TC = O(Q*N) | SC = O(1) | Iterations = q*(e-s+1)   [ in worst case e-s = n && q is independent of n]



    /*
     *  Q: Given the Totaol Score after Each Over for the last 10 Overs
     *          Overs:   41      42      43      44      45      46      47      48      49      50
     *          Score:   288     312     330     349     360     383     394     406     436     439
     * 
     *      Calculate the Score made in the Last 5 Overs [46 to 50]
     *              = Runs[50] - Runs[45]   
     *              = 439 - 360
     *              = 79
     * 
     *      Calculate the Score made in the 50th Over only
     *              = Runs[50] - Runs[49]
     *              = 439 - 436
     *              = 3
     * 
     *      Calculate the Score made in the 49th Over only
     *              = Runs[49] - Runs[48]
     *              = 436 - 406
     *              = 30
     * 
     *      Calculate the Score made from 42 to 45 overs
     *              = Runs[45] - Runs[41]
     *              = 360 - 288
     *              = 72
     * 
     *  NOTE: 
     *      - As the data given in this Q is Cumulative data, we are able to cal scores in single step
     *      - But if the scores are given for individual Over like in previous array Q1, 
     *              - Then, we need to sum all the scores [using loop]
     *      - This cumulative data is called Prefix Sum in Arrays
     * 
     * 
     *  Prefix Sum Array : Sum of All Elements from 0 to ith Index
     *      ex:             0  1  2  3  4  5  6   7  8  9
     *              arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1}
     *              pf  = {-3, 3, 5, 9, 14, 16, 24, 15, 18, 19}
     * 
     *      Advantage of this is:
     *              pf[4] = A[0] + A[1] + A[2] + A[3] + A[4]
     *              pf[5] = A[0] + A[1] + A[2] + A[3] + A[4] + A[5]
     *                 --> pf[5] = p[4] + A[5]
     * 
     *      i.e.,   pf[i] = pf[i-1] + A[i]
     *                              pf[i] -> Sum of [0 to i] elements
     *                              pf[i-1] -> Sum of [0 to i-1] elements
     *                              A[i] -> ith Element
     * 
     *      But, This will fail for oth Element --> pf[0]
     *              pf[0] = A[0]
     *      Hence,
    */
    public static void prefixArray (int[] arr) {
        int n = arr.length;
        int[] pf = new int[n];

        // Prefix Array
        pf[0] = arr[0];
        for (int i=1; i<n; i++) {
            pf[i] = pf[i-1] + arr[i];
        }
    }
    // TC = O(N) || SC = O(N) [ For Creating Prefix Array ]


    // With this Prefix Array, We can Optimize the Q1
    public static void arraySumQueryOptomized (int[] arr) {
        int n = arr.length;

        int[] pf = new int[n];
        for (int i=0; i<n; i++) {
            if (i==0)
                pf[i] = arr[i];
            else
                pf[i] = pf[i-1] + arr[i];
        }

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for (int i=1; i<=q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (s==0) {
                System.out.println(pf[e]);
            } else {
                System.out.println(pf[e]-pf[s-1]);
            }
        }

        sc.close();
    }
    // TC = O(N+Q) || SC = O(N) || Iterations = N+Q



    /*
     *  Q2: Given an Array of Size N, Find the Euiqllibrium Index
     *      Euiqllibrium ind => sum of all elements to it's left == sum of all elemnets to it's right
     *      EX:        0  1  2  3  4   5   6
     *          arr = {1, 2, 3, 4, 8, 10}       ans = 4
     *          arr = {-7, 1, 5, 2, -4, 3, 0}   ans = 3 & 6
     * 
     *      Obs: 
     *          - For any index i, 
     *                  - cal sum of [o -> i-1] indices    --> pf[i-1]
     *                  - cal sum of [i+1 -> n-1] indices  --> pf[n-1]-pf[i]
     *                  - Compare both
    */
    public static void equillibriumIndex (int[] arr) {
        int n = arr.length;

        int[] pf = new int[n];
        pf[0] = arr[0];
        for (int i=0; i<n; i++) {
            pf[i] = pf[i-1] + arr[i];
        }

        for (int i=0; i<n; i++) {
            if (i==0) {
                int leftSum = 0;
                int rightSum = pf[n-1]-pf[i];
                if(leftSum == rightSum) {
                System.out.println("Equillibrium Index :" + i);
                }
            }
            else {
                int leftSum = pf[i-1];
                int rightSum = pf[n-1]-pf[i];
                if (leftSum == rightSum) {
                    System.out.println("Equillibrium Index :" + i);
                }
            }
        }
    }
    // TC = O(N) || SC = O(N) || Iterations = O(N)



    /*
     *  Q3: Given an Array of Size N, asked q Queries
     *      each query can be of 2 types
     *      Type-1 : sum of all Even indices between s & e
     *      Type-2 : sum of all Odd indices between s & e
     *                      Ex:      0  1  2   3  4  5  6  7
     *                              {2  3  1  -1  0  8  5  4}
     *                      Type    s   e   ans
     *                        I     3   6   5
     *                        II    1   5   10
     * 
     *      Obs: As the Q mentions revolves only on odd & even indices between s & e
     *          - Instead of taking prefix array for all indices, we will take prefix for even & odd indices
     *          - pfEven array: clculate the sum of all even indices till now
     *          - pfOdd array: clculate the sum of all Odd indices till now
     *                          Ex:      0  1  2   3  4  5  6  7
     *                                  {2  3  1  -1  0  8  5  4}
     *                          pfEven  {2  2  3   3  3  3  8  8}
     *                          pfOdd   {0  3  3   2  2  10 10 14}
     *          - Now for Type-1 : pfEven[e]-pfEven[s-1]
     *          - Now for Type-2 : pfOdd[e]-pfOdd[s-1]
    */
    public static void arrayQueryTypes (int[] arr) {
        int n = arr.length;

        int[] pfEven = new int[n];
        int[] pfOdd = new int[n];

        pfEven[0] = arr[0];
        pfOdd[0] = 0;
        for (int i=1; i<n; i++) {
            if (i%2 == 0 ) {
                pfEven[i] = pfEven[i-1] + arr[i];
                pfOdd[i] = pfOdd[i-1];
            }
            else {
                pfEven[i] = pfEven[i-1];
                pfOdd[i] = pfOdd[i-1] + arr[i];
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i=0; i<q; i++) {
            int type = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (type == 1) {
                if (s == 0) {
                    System.out.println(pfEven[e]);
                }
                else {
                    System.out.println(pfEven[e] - pfEven[s-1]);
                }
            }
            else {
                if (s == 0) {
                    System.out.println(pfOdd[e]);
                }
                else {
                    System.out.println(pfOdd[e] - pfOdd[s-1]);
                }
            }
        }

        sc.close();
    }



    /*
     *  Q4: Given an Array of Size N, Count No. of Special Indices                  [ GOOGLE ]
     *      If we delete that index, sum of odd indices == sum of even indices
     *              EX:     0  1  2  3  4   5
     *                    { 4  3  2  7  6  -2 }     EvenSum      OddSum     count
     *      delete i = 0    3  2  7  6  -2              8           8         1
     *             i = 1    4  2  7  6  -2              9           8         
     *             i = 2    4  3  7  6  -2              9           9         2
     *             i = 3    4  3  2  6  -2              4           9
     *             i = 4    4  3  2  7  -2              4           10
     *             i = 5    4  3  2  7   6              12          10
     * 
     *      Ans: 2
     * 
     *      Obs: After Deleting the index, even indices become Odd & Odd indices become Even
     *                                               i
     *                                      4  3  2  7  6  -2       
     *      Before deleting index "i":
     *          - pfEven[i-1]               = sum of all the Even indices to left of i  --> x
     *          - pfEven[n-1]-pfEven[i]     = sum of all the Even Indices to right of i --> y
     *          - pfOdd[i-1]                = sum of all the Odd indices to left of i  --> z
     *          - pfOdd[n-1]-pfOdd[i]       = sum of all the Odd Indices to right of i --> w
     * 
     *          - Total Sum of all Even indices = x + y
     *          - Total Sum of all Odd indices = z + w
     * 
     *      After deleting index "i": 
     *          - pfEven[i-1]               = sum of all the Even indices to left of i  --> x
     *          - pfEven[n-1]-pfEven[i]     = sum of all the Odd Indices to right of i --> y
     *          - pfOdd[i-1]                = sum of all the Odd indices to left of i  --> z
     *          - pfOdd[n-1]-pfOdd[i]       = sum of all the Even Indices to right of i --> w
     * 
     *          - Total Sum of all Even indices = x + w
     *          - Total Sum of all Odd indices = z + y
     * 
     *      if (x+w == z+y) --> Count++
    */
    public static void arraySpecialIndices (int[] arr) {
        int n = arr.length;

        // Prefix Arrays
        int[] pfEven = new int[n];
        int[] pfOdd = new int[n];

        pfEven[0] = arr[0];
        pfOdd[0] = 0;
        for (int i=1; i<n; i++) {
            if (i%2 == 0) {
                pfEven[i] = pfEven[i-1] + arr[i];
                pfOdd[i] = pfOdd[i-1];
            }
            else {
                pfEven[i] = pfEven[i-1];
                pfOdd[i] = pfOdd[i-1] + arr[i];
            }
        }

        // Logic
        int count = 0;
        for (int i=0; i<n; i++) {
            int evenSum = 0;
            int oddSum = 0;
            
            if (i == 0) {
                evenSum = pfOdd[n-1] - pfOdd[i];
                oddSum = pfEven[n-1] - pfEven[i];
            }
            else {
                evenSum = pfEven[i-1] + ( pfOdd[n-1] - pfOdd[i] );
                oddSum = pfOdd[i-1] + ( pfEven[n-1] - pfEven[i] );
            }

            if(evenSum == oddSum) {
                count++;
            }
        }

        System.out.println("Total Special Indices : " + count);
    }
    // TC = O(N) || SC= O(N) || Iterations = N



    /*
     *  HW:
     *      - Find th 2nd Max element in the array
    */
    public static void secondMax (int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Brute Force
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > firstMax) {
                firstMax = arr[i];
            }
        }
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > secondMax && arr[i] < firstMax) {
                secondMax = arr[i];
            }
        }
        // TC = O(N^2)

        // Single Loop
        for (int i=0; i<arr.length; i++) {
            // Updates the SecondMax to Previous FirstMax when Current FirstMax is Updated
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            }
            // Checks if the element is < Current FirstMax and > Current SecondMax simultaneously
            else if (arr[i] < firstMax && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        // TC = O(N)
    }

}
