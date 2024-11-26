package Intermediate;

public class INT07_Arrays4SubArrays {
    public static void main(String[] args) {
        /*
         *  Sub Arrays:
         *  ----------
         *      - Continuous Part of an Array is called Sub-Array [ Left to Right only ]
         *              a. A single Element is a Sub-Array
         *              b. Full Array is also a Sub-Array
         *              c. Empty Array [] is also a SUb-Array
        */
    }

    public static void printSubArraysStoE (int[] arr, int s, int e) {
        for (int i=s; i<=e; i++) {
            System.out.println(arr[i]);
        }
    }
    // TC = O(N) || SC = O(1)



    /*
     *  Q1: Given an Array of Size N, How many Sub-Arrays are Possible..?
     *      EX: arr[] = {1, 3. 2, 4} 
     *      Sub Arrays      
     *         [0, 0] -> 1              [1, 1] -> 3          [2, 2] -> 2         [3, 3] -> 4
     *         [0, 1] -> 1 3            [1, 2] -> 3 2        [2, 3] -> 2 4
     *         [0, 2] -> 1 3 2          [1, 3] -> 3 2 4
     *         [0, 3] -> 1 3 2 4
     * 
     *      Total No. of Sub-Arrays = 10
     * 
     *      EX: arr[n] = {1, 2, 3, 4, ... N-1, N}
     *      Indices Start at 0      Start at 1      Start at 2      Start at n-2    Start at n-1
     *          [0, 0]                  [1, 1]          [2, 2]          [n-2, n-2]      [n-1, n-1]
     *          [0, 1]                  [1, 2]          [2, 3]          [n-2, n-1]      ----------
     *          [0, 2]                  [1, 3]                          ----------          1
     *             .                        .                            (n-1)-(n-2)+1
     *             .                        .                                   2
     *          [0, n-2]                [1, n-2]        [2, n-2]
     *          [0, n-1]                [1, n-1]        [2, n-1]
     *        -----------             -----------     -----------
     *          (n-1)-0+1               (n-1)-1+1       (n-1)-2+1
     *              n                       n-1             n-2
     * 
     *          Total No. of Sub-Arrays = [ n + (n-1) + (n-2) + ... + 2 + 1]
     *                                  = n*(n+1)/2
     * 
     *          Verification = n == 4
     *          Total No. of Sub-Arrays = n*(n+1)/2 = 4*5/2 = 10
    */  



    /*
     *  Q2: Print all Sub-Arrays in the Array
     *      EX: arr[] = {1, 3. 2, 4} 
     *      Sub Arrays      
     *         [0, 0] -> 1              [1, 1] -> 3          [2, 2] -> 2         [3, 3] -> 4
     *         [0, 1] -> 1 3            [1, 2] -> 3 2        [2, 3] -> 2 4
     *         [0, 2] -> 1 3 2          [1, 3] -> 3 2 4
     *         [0, 3] -> 1 3 2 4
     * 
     *      Total No. of Sub-Arrays = 10
    */
    public static void printAllSubArrays (int[] arr) {
        // To Set the start Index
        for (int s=0; s<arr.length; s++) {
            // To Set the End Index
            for (int e=s; e<arr.length; e++) {
                // To Print the sub-Array between start & end Indices
                for (int i=s; i<=e; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
        // TC = O(N^3) || SC = O(1)
        // We Cannot reduce the TC, as we need to print each sub-array & it's elements as well
    }



    /*
     *  Q3: Print Maximun of the sub-arrays sum
    */
    public static void maxSubArraySum (int[] arr) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for (int s=0; s<n; s++) {
            for (int e=s; e<n; e++) {
                int sum = 0;
                for (int i=s; i<=e; i++) {
                    sum += arr[i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        // TC = O(N^3) || SC = O(1)


        // 2. Optimized
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int ans =Integer.MIN_VALUE;
        for (int s=0; s<n; s++) {
            for (int e=s; e<n; e++) {
                int sum = 0;

                if (s == 0) {
                    sum = prefix[e];
                }
                else {
                    sum = prefix[e]-prefix[s-1];
                }

                if (sum > ans) {
                    ans = sum;
                }
            }
        }
        System.out.println(ans);
        // TC = O(N^2) || SC = O(N)
    }



    /*
     *  Q4: Print all Sub-Array's sum stating at Index 'P'
     *      EX: arr[8] = { 7 3 2 -1 6 8 2 3 }   ||  ind = 2
     *              [2, 2]  --> { 2 }               --> 2
     *              [2, 3]  --> { 2 -1 }            --> 1
     *              [2, 4]  --> { 2 -1 6 }          --> 7
     *              [2, 5]  --> { 2 -1 6 8 }        --> 15
     *              [2, 6]  --> { 2 -1 6 8 2 }      --> 17
     *              [2, 7]  --> { 2 -1 6 8 2 3 }    --> 20
    */
    public static void printSubArraySumfromIndp (int[] arr, int p) {
        int n = arr.length;
        int sum = 0;

        for (int i=p; i<n; i++) {
            sum += arr[i];
            System.out.println(sum);
        }
    }
    // TC = O(N) || SC = O(1)   --> It uses Carry Forward [ carrying the previous sum to current ]



    /*
     *  Q5: Print sum of all Sub-Arrays
     *          - We will use the Carry Forward discussed above to print optimised Version
    */
    public static void printSubaArraysSum (int[] arr) {
        int n = arr.length;

        // 1. Brute Force
        for (int s=0; s<n; s++) {
            for (int e=s; e<n; e++) {
                int sum = 0;
                for (int i=s; i<=e; i++) {
                    sum += arr[i];
                    System.out.println(sum);
                }
            }
        }
        // TV = O(N^3) || SC = O(1)


        // 2. Prefix Array 
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int s=0; s<n; s++) {
            int sum = 0;
            for (int e=s; e<=n; e++) {
                if (s == 0) {
                    sum = prefix[e];
                }
                else {
                    sum = prefix[e] - prefix[s-1];
                }

                System.out.println(sum);
            }
        }
        // TC = O(N^2) | SC = O(1)


        // 3. Carry Forward
        for (int s=0; s<n; s++) {
            int sum = 0;
            for (int e=s; s<n; s++) {
                sum += arr[e];
                System.out.println(sum);
            }
        }
        // TC = O(N^2) || SC = O(1)
    }



    /*
     *  Q5: Print Max of sub-array's Sum
    */
    public static void printMaxOfSubaArraysSum (int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        // 1. Brute Force
        for (int s=0; s<n; s++) {
            for (int e=s; e<n; e++) {
                int sum = 0;
                for (int i=s; i<=e; i++) {
                    sum += arr[i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        // TV = O(N^3) || SC = O(1)


        // 2. Prefix Array 
        max = Integer.MIN_VALUE;

        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int s=0; s<n; s++) {
            for (int e=s; e<=n; e++) {
                int sum = 0;

                if (s == 0) {
                    sum = prefix[e];
                }
                else {
                    sum = prefix[e] - prefix[s-1];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        // TC = O(N^2) | SC = O(1)


        // 3. Carry Forward
        max = Integer.MIN_VALUE;

        for (int s=0; s<n; s++) {
            int sum = 0;
            for (int e=s; s<n; s++) {
                sum += arr[e];

                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        // TC = O(N^2) || SC = O(1)



        /*
         *  4. Kadane's Algorithm
         *      - TC = O(n) || SC = O(1)
         *      - Will be seen in Advance Classess
        */
    }



    /*
     *  Q6: Print Sum of All Sub-Array's Sum
    */
    public static void printSumOfAllSubArraysSum (int[] arr) {
        int n = arr.length;

        int totalSum = 0;
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += arr[i];
                totalSum += sum;
            }
        }
        System.out.println(totalSum);
        // TC = O(N^2) || SC = O(11)



        /*
        *  Q7.1: In How many Sub-Arrays, Index 3 is present..?
        *          Ex:   0 1 2  3  4 5   
        *              { 3 2 4 -1  2 6 }
        *          Possible Start Indices                          Possible End Indices
        *      where Ind 3 can be a part of Sub-Array          Where Ind 3 can be a part of Sub-Array
        *                  S                                               E
        *                  0                                               3
        *                  1                                               4
        *                  2                                               5
        *                  3
        *      Total Possible Sub-Arrays = S*E = 4*3 == 12 
        * 
        * 
        *  Q7.2: In How many Sub-Arrays, Index 1 is present..?
        *          Ex:   0 1 2  3  4 5   
        *              { 3 2 4 -1  2 6 }
        *          Possible Start Indices                          Possible End Indices
        *      where Ind 1 can be a part of Sub-Array          Where Ind 1 can be a part of Sub-Array
        *                  S                                               E
        *                 {0 1}                                          {1 2 3 4 5} 
        *      Total Possible Sub-Arrays = S*E = 2*5 == 10 
        * 
        * 
        * 
        *  Q7.3: In How many Sub-Arrays, Index 0 is present..?
        *          Ex:   0 1 2  3  4 5   
        *              { 3 2 4 -1  2 6 }
        *          Possible Start Indices                          Possible End Indices
        *      where Ind '0' can be a part of Sub-Array          Where Ind '0' can be a part of Sub-Array
        *                  S                                               E
        *                 {0}                                          {0 1 2 3 4 5} 
        *      Total Possible Sub-Arrays = S*E = 1*6 == 6 
        * 
        * 
        *  Generalization:
        *  ---------------
        *      -> Gievn an Array of Size N, In How many Sub-Arrays, Index i is present..?
        *              -> Possible Start Indices        Possible End Idices 
        *                      { 0 1 2 3 .. i }            { i i+1 i+2 ... n-2 n-1}
        *                          i-0+1                            n-1 -i +1
        *                           i+1                                n-i   
        *              -> Possible Sub-Arrays = s*e ==  (i+1)*(n-i)
        */

        // Optimizing the above Q6
        totalSum = 0;

        for (int i=0; i<n; i++) {
            // This IndexRepeated will clculate how many times that Ind will be repeated in the all of Sub-Arrays
            int IndexRepeated = (i+1)*(n+i);
            totalSum += IndexRepeated*arr[i];
        }
        System.out.println(totalSum);
        // TC = O(N) || SC = O(1)
        /*
         *  Explanation:
         *  ------------
         *      EX:       0 1 2  3  4 5  
         *              { 3 2 4 -1  2 6 }
         *      sub-array indices       sub-array           sum
         *          [0, 0]               3                  3
         *          [0, 1]               3 2                5
         *          [0, 2]               3 2 4              9
         *          [0, 3]               3 2 4 -1           8
         *          [0, 4]               3 2 4 -1 2         10
         *          [0, 5]               3 2 4 -1 2 6       16
         * 
         *          [1, 1]               2                  2
         *          [1, 2]               2 4                6
         *          [1, 3]               2 4 -1             5
         *          [1, 4]               2 4 -1 2           7
         *          [1, 5]               2 4 -1 2 6         13
         * 
         *          [2, 2]               4                  4
         *          [2, 3]               4 -2               2
         *          [2, 4]               4 -2 2             4
         *          [2, 5]               4 -2 2 6           10
         * 
         *          [3, 3]               -2                 -2
         *          [3, 4]               -2 2               0
         *          [3, 5]               -2 2 6             6
         * 
         *          [4, 4]               2                  2
         *          [4, 5]               2 6                8
         * 
         *          [5, 5]               6                  6
         *                       -------------------    ---------
         *                    Sum of all the Elements
         *                     of the each sub-arrays  ==   124
         * 
         *      - Hence, we will find out How many times each element will be reapeated in all of sub-arrays
         *      - Then we will add all of those elements to find sum of all sub-arrays
         * 
         *      Basically, sum of all sub-arrays == sum of all individual elements in all the sub-arrays
         */
    } 
}