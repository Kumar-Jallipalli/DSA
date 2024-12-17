import java.util.HashMap;
import java.util.HashSet;

public class INT18_Hashing2 {
    public static void main(String[] args) {
        
    }


    /*
     *  Q1: Given N Array Elements, Check if exists a pair (i, j) 
     *      Such That arr[i] + arr[j] == k && ( i != k )
     *      EX:     arr = { 8 9 1 -2 4 5 11 -6 7 5 }
     *                          i   j
     *          if  k = 11      4   8
     *              k = 6       0   3
     *              k = 22      -   -   False
    */
    public static void twoSum (int[] arr, int k) {
        int n = arr.length;

        // 1. Brute Force
        for (int i=0; i<n; i++) {
            int a = arr[i];
            int b = k-a;
            for (int j=i+1; j<n-1; j++) {
                if ( arr[j] == b ) {
                    System.out.println(true);
                    return;
                }
            }
        }
        // TC = O(N^2) || SC = O(1)

        /*
         *  2. Hash Map
         *          - Store freq of each element in HM
         *          - iterate over array & find the element such that ele = k-arr[i] exists in HM
         *                  - Here, we have chosen freq because (i != j) 
         *                  - if arr[i] = 11 & k = 22, now we need to search for 11 in HM
         *                  - But, 11 is present only once in the array
         *                  - Yet, HM will say, it contains ele "11" in HM 
         *                  - which is i == j i.e., arr[i] + arr[i] = k case [ which needs to be avoided ]
         *          - If ele != k-a --> search in hasmap
         *          - else search if ele's freq > 1
        */
        HashMap<Integer, Integer> hm = new HashMap<>();
        for ( int i=0; i<n; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(i, arr[i]);
            }
        }

        for (int i=0; i<n; i++) {
            int a = arr[i];
            int b= k-a;
            if ( a != b ) {
                if (hm.containsKey(b)) {
                    System.out.println(true);
                    return;
                }
            }
            else {
                if (hm.get(b) > 1) {
                    System.out.println(true);
                    return;
                }
            }
        }
        // TC = O(N) || SC = O(N) || Iterations = O(2N)


        /*
         *  3. Usinh HashSet
         *          - Generally hashset fails for the same case of HashMap which is a == b
         *          - Hence, we will insert elements until current element into HashSet
         *          - i.e., we first check the condition and then insert into HashSet
         *                  arr = arr = { 8 9 1 -2 4 5 11 -6 7 5 }
         *                          a       b               HS      k = 22
         *                          8       14              -   
         *                          9       13              {8}
         *                          1       21              {8 9}
         *                          -2      24              {8 9 1}
         *                          4       18              {8 9 1 -2 }
         *                          .       .                   .
         *                          .       .                   .
         *                          5       17              {8 9 1 -2 4 5 11 -6 7}      ans = false
         *          - In this way, we can Avoid the same element addition which is i==j
        */
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0; i<n; i++) {
            int a = arr[i];
            int b = k-a;
            if (hs.contains(b)) {
                System.out.println(true);
                return;
            }
            else {
                hs.add(arr[i]);
            }
        }
        // TC = O(N) || SC = O(N) || Iterations = O(N)

        System.out.println(false);
    }



    /*
     *  Q2: Calculate No. of (i, j) S.T., arr[i] + arr[k] == k && (i != j)      [ TODO ]
    */



    /*
     *  Q3: Cal if there exists a pair S.T.,arr[i] - arr[j] == k && ( i!=j )    [ TODO ]
    */



    /*
     *  Q4: Given N array Elements, Cal No. of distinct elements in every sub-array of size k
     *      EX:     arr = { 2 4 3 8 3 9 4 9 4 10 }      k = 4
     *                  sub-array       distinct ele
     *                  [0, 3]              4
     *                  [1, 4]              3
     *                  [2, 5]              3
     *                    .                 .
     *                  [6, 9]              3       ans = { 4 3 3 ... 3 }
    */
    public static void distinctElementsSubArray (int[] arr, int k) {
        int n = arr.length;

        // 1. For every window, we will find the distinct elements using HS
        for (int i=0; i<=n-k; i++) {       // SInce last sub array = [n-k, n-1]
            HashSet<Integer> hs = new HashSet<>();
            for (int j=i; j<i+k; j++) {
                hs.add(arr[j]);
            }
            System.out.println(hs.size());
        }
        // TC = O((N-k-1)*K) || SC = O(K)

        /*
         *  2. From the above sol, we will just remove the 1st ele from window & add latest ele
         *          arr = { 2 4 3 8 3 9 4 9 4 10 }      k = 4
         *              sub-array       Remove  Add     HS          distinct ele
         *              [0, 3]                          {2 4 3 8}       4
         *              {1, 4}          2       3       {4 3 8}         3       
         *              {2, 5}          4       9       {3 8 9}         3       
         *              {3, 6}          3       4       {8 9 4}         3   
         *          - The problem here is, 3 got totally removed
         *          - i.e., if we remove an element, indirectly all of the occurence of the element is removed
         *          - Hence, we will go for HashMap instead of HashSet
         * 
         *  HashMap with Sliding Window
         *          arr = { 2 4 3 8 3 9 4 9 4 10 }      k = 4
         *              sub-array       Remove  Add     HM                  distinct ele
         *              [0, 3]                          {2:1 4:1 3:1 8:1}       4
         *              {1, 4}          2       3       {4:1 3:2 8:1}           3       
         *              {2, 5}          4       9       {3:2 8:1 9:1}           3       
         *              {3, 6}          3       4       {3:1 8:1 9:1 4:1}       3       Problem Solved
        */
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Adding 1st sub-array elements in HM
        for (int i=0; i<k; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i],1);
            }
        }
        // Printing 1st sub-array distinct elements
        System.out.println(hm.size());

        // Traversing the array to print all sub-arrays
        for (int i=k; i<n; i++) {
            // removing (i-k)th element
            if (hm.get(arr[i-k]) > 1) {
                hm.put(arr[i-k], hm.get(arr[i-k])-1);
            }
            else if (hm.get(arr[i-k]) == 1) {
                hm.remove(arr[i-k]);
            }

            // adding ith element
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }

            // Printing sub-array's distinct elements
            System.out.println(hm.size());
        }
        // TC = O(N) || SC = O(N)

        // Sir's Code: Simplifying the above for loop for easy understanding
        for (int i=1, j=k; i<=n-k; i++, j++) {
            // removing (i-1)th element
            hm.put(arr[i-1], hm.get(arr[i-1])-1);
            // If freq == 0, remove from hashmap
            if (hm.get(arr[i-1]) == 0) {
                hm.remove(arr[i-1]);
            }

            // adding jth element
            if (hm.containsKey(arr[j])) {
                hm.put(arr[j], hm.get(arr[j])+1);
            }
            else {
                hm.put(arr[j], 1);
            }

            // Printing sub-array's distinct elements
            System.out.println(hm.size());
        }
    }
}