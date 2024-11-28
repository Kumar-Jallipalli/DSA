public class INT09_Arrays6Questions {
    public static void main(String[] args) {
        
    }
    

    /*
     *  Q1: Max Consecutive 1's
     *      Given a Binary Array, We can atmost replace a single "0" with "1",
     *      Find, max consecutive 1's we can get
     *      EX:             0 1 2 3 4 5 6 7 8 9 10
     *              arr = { 0 1 1 1 0 1 1 0 1 1 0 }
     *          Ans: if we change the ind-4 --> we will get max 1's = 6
    */
    public static void maxConsecute1s (int[] arr) {
        int n = arr.length;
        int ans = 0;

        // FOr edge case --> arr = { 1 1 1 1 1 1 }
        int count1s = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == 1) {
                count1s++;
            }
        }
        if (n == count1s) {
            System.out.println(n);
            return;
        }

        // For Normal cases
        for (int i=0; i<n; i++) {
            int total = 0;

            if (arr[i] == 0) {
                int left = 0;
                // Calculate the left 1's
                for (int j=i=1; j>=0; j--) {
                    if (arr[j]==1) {
                        left++;
                    }
                    else {
                        break;
                    }
                }

                int right = 0;
                // Calculate the right 1's
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == 1) {
                        right++;
                    }
                    else {
                        break;
                    }
                }

                total = left + right + 1;
            }

            if (total > ans ) {
                ans = total;
            }
        }

        System.out.println( ans );
    }
    /*
     *  TC = O(N^2) || SC = O(1)
     *  NO, This is wrong
     *      - Here, Every Element "1" is being visited only 2 times [ 2*n == O(n)]
     *              - If each Element "1" is being visited n times, Then TC = O(n^2)
     *      - And, Every Element "0" is being visited only 1 time
     *              - ex: arr = {0 0 0 0 0} --> TC = O(N)
     *              - ex: arr = {1 1 1 1 1} --> TC - O(N)
     *  - Here, Each element is not visited "n" times [ n*n == n^2]
     * 
     *  Hence, TC = O(N)
    */



    /*
     *  Q2: Given a Binary Array, We can atmost swap a single "0" with "1"
     *      Find max maximum consecutive "1"s we can get
     *      EX:             0 1 2 3 4 5 6 7 8
     *              arr = { 1 1 0 1 0 1 0 1 1 }
     *                          ^   ^   ^
     *                          4   3   4
     *              ans = 4 -> [ L + R + 1 --> Since we have extra 1 to use as ]
     *  
     *              arr = { 1 1 1 0 1 1 1 }
     *              ans = 5 -> [ L + R --> Here, we don;t have an extra 1 to add]
     *      
     *              arr = { 1 1 0 1 1 1 0 0 }
     *              ans = 5
     * 
     *      Obs:
     *          - This is same as previous one [ instead of replacing, we will swap withe existing one's]
     *          - Here, if we have spare 1's [ i.e., we have an extra 1 which is not part of consecutive left & right ] 
     *                      -> same as previous --> Cal left & right add the spare one == L+R+1
     *          - If we don't have a spare one, i.e., all the 1's are either consecutive to left or right 
     *                      -> In this case, we need to swap with the 1 from either left or right consecutive 1's
     *                      -> which makes --> L+R+1-1 [ this minus 1 is the 1 taken from either of side ] == L+R
     *          - If we only have all 1's --> Same as previous ones
     * 
     *      How to calculate, whether we have an spare or not..?
     *          - we will use the count of 1's
     *          - if 1's count > L+R --> we have a spare 1
     *          - else we don't have a spare
    */
    public static void getMaxConsecutive1s (int[] arr) {
        int n = arr.length;
        int ans = 0;

        int count1s = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == 1) {
                count1s++;
            }
        }
        if (count1s == n) {
            System.out.println(n);
            return;
        }

        for (int i=0; i<n; i++) {
            int total = 0;

            if (arr[i] == 0) {
                int left = 0;
                for (int j=i-1; j>=0; j--) {
                    if (arr[j] == 1) {
                        left++;
                    }
                    else {
                        break;
                    }
                }

                int right = 0;
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == 1) {
                        right ++;
                    }
                    else {
                        break;
                    }
                }

                if (count1s > left+right) {
                    total = left + right+ 1;
                }
                else {
                    total = left + right;
                }
            }

            if (total > ans) {
                ans = total;
            }
        }
    }



    /*
     *  Q3: Find No. of Triplets (i, j, k), Such That i<j<k && arr[i]<arr[j]<arr[k]
     *          EX:             0 1 2 3 4 
     *                  arr = { 3 4 6 9 2 }     ans: (0 1 2), (0 1 3), (0 2 3), (1 2 3) --> 4
    */
    public static void printTriplets (int[] arr) {
        int n = arr.length;
        int count = 0;

        // 1. Brute Force
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (arr[i]>arr[j] && arr[j]>arr[k]) {
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);
        // TC = O(N^3) || SC = O(1)


        /*
         *  2. Optimisation:
         *  -------------       0 1 2 3  4 5  6 7 8
         *      - ex:   arr = { 3 6 9 12 5 16 8 7 11 }
         * 
         *  Obs: we will use the Q1's approach, 
         *       i.e., find how many i's to left of j & how many k's to right of j
         *              - let's take middle term j = 3 --> arr[j] = 12
         *              - we will find how many i's can be found to left of j --> l
         *              - we will find how many k's can be found to right of k --> r
         *              - Now, total triplets for ind "j" == l*r
        */
        int ans1 = 0;

        for (int j=1; j<n-1; j++) {
            int left = 0;
            for (int i=j-1; i>=0; i--) {
                if (arr[i] < arr[j]) {
                    left ++;
                }
            }

            int right = 0;
            for (int k=j+1; k<n; k++) {
                if (arr[j] < arr[k]) {
                    right++;
                }
            }

            ans1 += left*right;
        }
        System.out.println(ans1);
        // TC = O(N^2) || SC = O(1)
                // Because for every iteration,we will traverse every element except itself
                // Every element will be visited n-2 times --> n*n-2 == O(N^2)
        // Previously, in Q1


        /*
         *  3. More Optimization
         *  --------------------
         *      - Here, we are always finding 
         *              - elements lesser than current
         *              - elements Greater than Current
         *      - Can't we use prefix array to solve this
         *              - here, prefix array stores elements leesse & greater than current
         * 
         *  - This won't work at all
         *      ex: arr = { 3 6 9 12 5 16 8 7 11 }
         *                         ^
         *      - here, for 12, prefix will store 3
         *      - But for 5..?
         *      - It Totally fails, as it cannot carry forward that ans=3 to 5
         * 
         *  NOTE:
         *  -----
         *      - we can do with O(nlogn) using
         *              1. Balanced BST
         *              2. Segement Trees
        */
    }




    /*
     *  Q3: Given N array Elements, replace every Element arr[i] with product of all array elements except itself
     *      You cannot use "/" in the code.
    */
    public static void replaceElementswithProduct (int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];

        for (int i=0; i<n; i++) {
            int left = 1;
            for (int j=i-1; j>=0; j--) {
                left *= arr[j];
            }
            int right = 1;
            for (int j=i+1; j<n; j++) {
                right *= arr[j];
            }

            ans[i] = left*right;
        }
        // TC = O(N^2) || SC = O(N)


        // 2. we can use prefix method here
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1]*arr[i];
        }

        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            suffix[i] = suffix[i+1]*arr[i];
        }

        for (int i=0; i<n; i++) {
            if (i==0) {
                ans[i] = suffix[i+1];
            }
            else if (i==n-1) {
                ans[i] = prefix[i-1];
            }
            else {
                ans[i] = prefix[i-1]*suffix[i+1];
            }
        }
        // TC = O(N) || SC = O(N)
    }
}
