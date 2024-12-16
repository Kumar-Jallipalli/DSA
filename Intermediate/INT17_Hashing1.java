import java.util.HashMap;
import java.util.HashSet;

public class INT17_Hashing1 {
    /*
     *  HASHMAP:
     *  -------
     *      - Hashmap is a Data Structure which stores data in <key, value> pairs
     *      - in which, keys must be unique & of only { int, long, String, float, double }
     *      - Values can be of any Data Types
     *      - It is an Inbuilt Library
     *      - Advantage:
     *              - Data retrieveal, Searching, Insertion & Updation are super fast with Avg O(1)
     *                      - i.e., Searching an element is Avg O(1) [ unlike Array which is O(N)]
     *      - Disadvanatge
     *              - After Insertion of data, Order is NOT Maintained
     *      - Operations of HasMap
     *              - Insertion <key, value>
     *              - Searching <key>
     *              - Deletion <key> -> Deletes both key & value
     *              - Update value of a key -> Possible
     *              - Update key -> NOT POssible [ X ]
     *              - Size of HashMap
     *      - All the HashMap Operations takes O(1) [ Average ]
    */
    public static void hashMapDeclartion () {
        /*
         *  HashMap Declaration:
         *          - We import the HashMap class from the java.util package    --> import java.util.HashMap;
         *          - We create a HashMap object "hm"   --> HashMap<key, value> hm = new HashMap<>();
         *                  - These key & value requires Wrapper Classes
         * 
         *  Add Items into HashMap
         *          - hm.put(key, value)
         *  Access an Item
         *          - hm.get(key)
         *  Remove
         *          - hm.remove(key)    --> Removes a Single Item
         *          - hm.clear()        --> Removes all Items
         *  Size of HM
         *          - hm.size()         --> Returns how many Items stored in HM
         *  Check Existence
         *          - hm.containsKey(key)       --> Checks if Key exists or not in HM
         *          - hm.containsValue(value)   --> Checks if value exists or not in HM
         *  
         *  How to Iterate over HashMap
         *          1. useing keyset() 
         *              for ( String i : hm.keySet()) {
         *                  // here i represents keys, uisng keys we can get values
         *                  System.out.println(i, hm.get(i));
         *              }
         *          2. forEach() method
         *              hm.forEach( (key, value) -> {
         *                  System.out.println(key + " " + value);
         *              } );
         */
        HashMap<String, Integer> hm = new HashMap<>();

        // Inserting values
        hm.put("Siva", 27);
        hm.put("Sai", 26);
        hm.put("Kumar", 25);

        // Access Item
        System.out.println(hm.get("Sai"));

        // Iterate over a hasmap
        hm.forEach( (key, value) -> {
            System.out.println(key + " " + value);
        } );

        // Iterate over hashmap using keySet()
        for (String i: hm.keySet()) {
            System.out.println(i + " " + hm.get(i));
        }
    }



    /*
     *  Q1: Given an array of Integers, Find the freq of each element
     *      EX:     arr = {2 6 3 8 2 8 2 3 8}   
     *                  2 - 3
     *                  3 - 2
     *                  6 - 1
     *                  8 - 3
    */
    public static void elementsFreq (int[] arr) {
        // Creating a Hashmap Object
        HashMap<Integer, Integer> hm = new HashMap<>();

        // looping through Array to put elements into HM
        for (int i=0; i<arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }

        // Printing the Elements with freq
        for (Integer i: hm.keySet()) {
            System.out.println(i + " : " + hm.get(i));
        }
    }
    // TC = O(N) || SC = O(N)



    /*
     *  Q2: FInd the 1st Non Repeating Element in the array
     *      EX:     arr = {1 2 3 1 2 5}     ans = 3
     *              arr = {4 8 8 5 4 2 1}   ans = 5
    */
    public static void firstNonRepeatingElement (int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }

        // Iterate the array to find the ans element
        for (int i=0; i<arr.length; i++) {
            if (hm.get(arr[i]) == 1) {
                System.out.println(arr[i]);
                break;
            }
        }
    }



    /*
     *  Q3: Gievn an Array, Find No. of Distinct Elements
     *      EX:     arr = { 6 3 7 3 8 6 9 }     ans = 5 == { 6 3 7 8 9 }
     *              arr = { 2 9 8 7 6 8 2 7 }   ans = 5 == { 2 9 8 7 6 }
    */
    public static void distictElements (int[] arr) {
        // 1. Using HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            // if (hm.containsKey(arr[i])) {
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }
            // else {
            //     hm.put(arr[i], 1);
            // }

            // This will push all distinct elements, As freq of element is NOT imp
            hm.put(arr[i], 1);
        }


        // 2. To make it simpler, we can use HashSet --> As it only stores unique keys
        HashSet<Integer> hs = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            hs.add(arr[i]);
        }

        // Size of the Hashmap/HashSet gives the Count of distinct elements
        System.out.println(hm.size());
        System.out.println(hs.size());
    }
    // TC = O(N) || SC = O(N)



    /*
     *  Q4: Gievn N array elements, Check if there exists a subarray with sum = 0
     *      EX:            0 1 2  3 4 5 6  7  8 9
     *              arr = {2 2 1 -3 4 3 1 -2 -3 2}      ans =  true
     *              pf  = {2 4 5 2 6 9 10  8  5 7}
     *          here, pf[2] == 5    &&      pf[8] == 5      --> sum [3 - 8] = 0
     *                  pf[2] = sum[0-2] = 5
     *                  pf[8] = sum[0-8] = 5
     *                  pf[8] = sum[0-2] + sum[3-8]
     *                      5 = 5 + sum[3-8]    ==>     sum[3-8] = 0
     *  
     *      Obs:
     *          - If an element in the Prefix array pf[] repeats --> Sun Array sum = 0
     * 
     *      But, there will come one edge case like
     *          EX:     arr = { 3 -1 -2 4 } 
     *                  pf  = { 3  2  0 4 }
     *          here, element in pf[] becomes "0" ==> sum of all the elements until that index is "0"
     * 
     *      Obs:
     *          - check if "0" is present in th pf[]
     *          - If an element in the Prefix array pf[] repeats --> Sun Array sum = 0
     * 
     *      Steps:
     *          - calculate pf[]
     *          - check if "0" is present in the pf[]
     *          - check if element repeats in pf[]
     *                  - This we can check using hs.size() == n or not
     *                  - if hs.size() == n --> All are distinct element --> No repeating elements
    */
    public static void subarraySum0 (int[] arr) {
        int n = arr.length;
        int[] pf = new int[n];

        pf[0] = arr[0];
        for (int i=0; i<n; i++) {
            pf[i] = pf[i-1] + arr[i];
        }

        HashSet<Integer> hs = new HashSet<>();

        // check if "0" is present in the pf[]  && inserting elements into HS
        for (int i=0; i<n; i++) {
            if (pf[i] == 0) {
                System.out.println(true);
                return;
            }

            hs.add(arr[i]);
        }

        // check if element repeats in pf[]
        if (hs.size() != n ) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
    // TC = O(N) || SC = O(N)




    /*
     *  Q5: Find the length of Longest Subarray with sum = 0
     *      EX:            0 1 2  3  4 5 6  7 8  9 10 11 12
     *              arr = {3 3 4 -5 -2 2 1 -3 3 -1 5 -4 -1}
     *              pf  = {3 6 10 5  3 5 6  3 6  5 10 6  5}
     * 
     *              here, 3 is repeating 3 times --> 0, 4 & 7
     *              here, 6 is repeating 4 times --> 1, 6, 8 & 11
     *              here, 5 is repeating 4 times --> 3, 5, 9 & 12
     *          from all the above combinations, only the extreme indices gives the longest subarray
     * 
     *      Obs:
     *          - for every element in pf[], store it's 1st & last occurence
     *          - subtract those to get the longest sub array of all
     * 
     *      Sol:
     *              HashMap         1stOccurence    lastOccuerence      ans
     *              <3, 0>              0               4, 7            4, 7
     *              <6, 1>              1               6, 8, 11        5, 7, 10
     *              <10, 5>             2               10              8
     *              <5, 3>              3               5, 9, 12        2, 6, 9
     *                                                                 -----------
     *                                                                  ans = "10"
     * 
     *      NOTE:
     *          - This is NOT handling the edge case where pf[i] == 0
     *                  EX:         arr = { 4 -3 -1 2 3 }
     *                              pf  = { 4  1  0 2 3 }
     *          1. for this case, we will pre insert <0, -1> in the HashMap [Since it is 0 based ind, we used "-1"]
     *              - It represents, there is subarray with sum 0 at ind "-1"
     *              - whenever, "0" element appears, our normal code will find the ans, which is == i-(-1) == i+1
     *          2. Or lese, we can use another loop & find all the "0" occurences & find it's length 
    */
    public static void longestSubArray (int[] arr) {
        int n = arr.length;
        int[] pf = new int[n];

        pf[0] = arr[0];
        for (int i=0; i<n; i++) {
            pf[i] = pf[i-1] + arr[i];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        // To handle edge case
        hm.put(0, -1);

        int ans = 0;
        for (int i=0; i<n; i++) {
            // If element repeats => Cal length & compare with current longest subarray
            if (hm.containsKey(pf[i])) {
                // calculating the length of subarray [ through repetition ]
                int length = i - hm.get(pf[i]);

                // updating the ans
                if (ans < length) {
                    ans = length;
                }
            }
            else {
                hm.put(pf[i], i);
            }
        }

        System.out.println(ans);
    }
    // TC = O(N) || SC = O(N)




    /*
     *  Q6: Given an Array which contains only 0's & 1's                    [ Google ]
     *      Find max length of sub arrays which contains equal 0's & 1's 
     * 
     *      Sol:
     *          - Replace all 0's with "-1"
     *          - Now total sum which contains equal 0's & 1's == 0
     *          - Now, this becomes above Q5   
    */

}
