package Intermediate;

public class INT06_Arrays3CarryForward {
    public static void main(String[] args) {
        /*
         *  Sub Arrays:
         *  ----------
         *      - Continuous Part of an Array is called Sub-Array
         *              a. A single Element is a Sub-Array
         *              b. Full Array is also a Sub-Array
         *              c. Empty Array [] is also a SUb-Array
        */
    }


    /*
     *  Q1: Count Pairs 'ag'
     *      Given a Char[], Count No. of pairs i,j such that i<j || s[i]=='a' | s[j]=='g' [ All ch are LowerCase]
     *      EX: char[] = {b, a, a, g, d, c, a, g}
     *          pairs = {1, 3} {1, 7} {2, 3} {2, 7} {6, 7}
    */
    public static void countPairsAG (char[] arr) {
        int n = arr.length;
        int count = 0;

        // 1. Brute Force
        for (int i=0; i<n; i++) {
            if (arr[i] == 'a') {
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == 'g') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        // TC = O(N^2) || SC = O(1) 

        /*
         *  2. My Optimized Solution
         *      - Count all the 'a's to left of 'g'
         *              - Make a Variable & count all of 'a's
         *      - Now when ever we found 'g', just check how many 'a's are there to left of that 'g'
         *              - If there are n 'a's to left of 'g' --> n pairs can be made
         *              - Add these count to the existing count
         *                        0   1   2   3   4   5   6   7   8
         *                      [ a   d   g   a   g   a   g   f   g ]
         *  countA                1           2       3 
         *  countA before 'g'             1       2       3       3
         *  Ans = ans + countA            1       3       6       9
        */
        int countA = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == 'a') {
                countA++;
            }
            else if (arr[i] == 'g') {
                count += countA;
            }
        }
        System.out.println(count);
        // TC = O(N) || SC = O(1) || Iterations = N


        /*
         *  3. Sir's Solution [ Optimized ]
         *      - Reverse of my Solution
         *      - Count all the 'g's to right of 'a'
         *              - Make a Variable & count all of 'g's
         *              - Reverse Travers to get the count of 'g's
         *      - Now when ever we found 'a', just check how many 'g's are there to right of that 'a'
         *              - If there are n 'g's to right of 'a' --> n pairs can be made
         *              - Add these count to the existing count
        */
    }



    /*
     *  Q2: Leaders in an Array
     *      Given an Array[], you have to count leaders in Array
     *      Any Element is a Leader, If it is Strictly Greater than Max of Elements to it's right
     *          EX:     0    1  2   3   4   5   6   7
     *                [ 15  -1  7   2   5   4   2   3 ]
     *          Ans: 5 [ Elements = {15, 7, 5, 4, 3} ]
     * 
     *          EX:     0   1   2   3   4   5   6
     *                [ 10  7   9   3   2   2   4 ]
     *          Ans: 3 [ Elements = {10, 9, 4} ]
     * 
     *          EX:       0 1 2
     *                  [10 8 8] 
     *          Ans: 3 [Elements = {10, 8} ]
     * 
     *      NOTE: Last Element will always be Leader
     * 
     *  Sole:
     *      - We need to get the greatest element to the right of current element --> Hence, we will loop from Right [ Reverse ]    
     *      - Calculate the greatrest element to the right of current element from each iteration 
     *              - by comparing it with current element & updating 
     *      - In this way, we can calculate the Greatest element to it's right & update the count
    */
    public static void leaderElements (int[] arr) {
        int n = arr.length;

        // 1. Brute Force
        int count = 0;
        for (int i=0; i<n; i++) {
            int max = arr[i+1];
            for (int j=i+2; j<n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            if (arr[i] > max) {
                count++;
            }
        }
        System.out.println(count);
        
        // Since, Last element will always be Leader
        int ans = 1;
        int currentGreatest = arr[n-1];

        for (int i=n-2; i>=0; i--) {
            if (arr[i] > currentGreatest) {
                ans++;
                currentGreatest = arr[i];
            }
        }
        System.out.println(ans);
    }
    // TC = O(N) || SC = O(1) || Iterations = O(N)



    /*
     *  Q3: Closest min max
     *      Given an Array, Find the length of smallest sub-array which contains both min & max of array
     *          EX:     0   1   2   3   4   5   6   7   8   9
     *                [ 1   2   3   1   3   4   6   4   6   3 ]     --> min = 1 | max = 6
     *                  Ams:    4 [ sub-array = {1 3 4 6} ]
     * 
     *      Obs:    
     *          - We need only 1 min & 1 max
     *          - Always min & max will be corner elements --> [min ... max] or [max ... min]
     * 
     *      Sol-1:
     *          - Find the min & max elements in the array
     *          - Itereate over the elements using "i"
     *                  - If max is found --> Iterate over remaining elements using "j" until you find the min
     *                          - Once you find the min from the remaining elemnts --> cal length = j-i+1
     *                          - COmpare the length to the ans & update the ans
     *                  - Do the same, if you find the min value
     * 
     *      sol-2:
     *          - This is similar to that of count pairs 'ag'
     *          - calculate the min & max of the array
     *          - Iterate over elements using 'i'
     *                  - Maintain 2 variable --> minIndex & MaxIndex to store the nearest/latest min & max
     *                  - if you find the min element --> cal the length = i-maxInd+1
     *                  - if you find the max element --> cal the length = i-minInd+1
     *                  - Compare with ans variable & update the ans
    */
    public static void countMinMaz (int[] arr) {
        int n = arr.length;

        int min = arr[0];
        int max = arr[0];
        for (int i=0; i<n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 1. Logic
        int ans = n;

        // If min & max are equal
        if (min == max) {
            ans = 1;
            System.out.println(ans);
            return;
        }

        // If min & max are NOT equal
        for (int i=0; i<n; i++) {
            int currAns = 0;
            if (arr[i] == max) {
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == min) {
                        currAns = j-i+1;
                        break;
                    }
                }
                if (currAns < ans) {
                    ans = currAns;
                }
            }
            else if (arr[i] == min) {
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == max) {
                        currAns = j-i+1;                    
                    }
                }
                if (currAns < ans) {
                    ans = currAns;
                }
            }
        }
        System.out.println(ans);
        // TC = O(N^2) || SC = O(1) 


        // 2. Optimized
        if (min == max) {
            System.out.println(1);
            return;
        }

        int minInd = -1;
        int maxInd = -1;
        int sol = n;
        for (int i=0; i<n; i++) {
            if (arr[i] == min) {
                if (maxInd != -1) {
                    sol = Math.min(sol, i-maxInd+1);
                }
                minInd = i;
                
            }
            else if (arr[i] == max) {
                if (minInd != -1) {
                    sol = Math.min(sol, i-minInd+1);
                }
                maxInd = i;
            }
        }
        System.out.println(sol);
        // TC = O(N) || SC = O(1)
    }
    
}
