public class INT14_Maths2 {
    public static void main(String[] args) {
        
    }


    /*
     *  Q1: Joseph's Problem        [ Google/Adobe Problem ]
     *      N people will be in a circle, 1st person will kill his next [2nd] person & hand over the sword to next [3rd] person
     *      This repeats until the last reamining man standing. We need to find which person will be remaining every time.
     * 
     *      EX: N=5                 1   2   3   4   5
     *              step - 1 : sword is at "1" & he kilss "2" and passes the sword to "3" 
     *              step - 2 : sword is at "3" & he kilss "4" and passes the sword to "5"
     * 
     *                              1       3       5
     *              step - 3 : sword is at "5" & he kilss "1" and passes the sword to "3"   [ Since they were in circle]
     *              step - 4 : sword is at "3" & he kilss "5" and he will be last man standing
     *                              
     *                                      ans = 3
     *              
     * 
     *      EX: N=13                1   2   3   4   5   6   7   8   9   10  11  12  13
     *              step - 1 : sword is at "1" & he kilss "2" and passes the sword to "3" 
     *              step - 2 : sword is at "3" & he kilss "4" and passes the sword to "5"
     *              step - 3 : sword is at "5" & he kilss "6" and passes the sword to "7"
     *              step - 4 : sword is at "7" & he kilss "8" and passes the sword to "9"
     *              step - 5 : sword is at "9" & he kilss "10" and passes the sword to "11"
     *              step - 6 : sword is at "11" & he kilss "12" and passes the sword to "13"
     * 
     *                              1       3       5       7       9       11      13
     *              step - 7 : sword is at "13" & he kilss "1" and passes the sword to "3"   [ Since they were in circle]
     *              step - 8 : sword is at "3" & he kilss "5" and passes the sword to "7"
     *              step - 9 : sword is at "7" & he kilss "9" and passes the sword to "11"
     *              step - 10 : sword is at "11" & he kilss "13" and passes the sword to "3"    [ Since they were in circle]
     *                              
     *                                      3               7               11
     *              step - 11 : sword is at "3" & he kilss "7" and passes the sword to "11"
     *              step - 12 : sword is at "11" & he kilss "3" and he will be last man standing
     *          
     *                                      ans = 11
    */
    public static void josephProblem (int[] arr) {
        /*
         *          N       ans
         *         ---      ---
         *          1       1
         *          2       1
         *          3       3
         *          4       1
         *          5       3       Obs
         *          6       5       ---
         *          7       7           - Only ODD No's are ans [Since in 1st iteration all even No's will be killed]
         *          8       1           - For N=2^x, ans = 1 [ i.e., ans = 1 for every power of 2 ]
         *          9       3                   - This is beacuse 1st person holding sword is "1"
         *          10      5                   - If ith person holds sword at start, then ith person will remain at last
         *          11      7                   - This is beacause, for every iterations numbers will be halfed [ divide by 2]
         *          12      9           - S0, whenever No. of people remaining are power of 2 --> Ans = that ith person
         *          13      11                  - How..?
         * 
         * 
         *      EX:     N=11        1   2   3   4   5   6   7   8   9   10  11  
         *                      remaining People    Starting Place
         *                      ----------------    --------------
         *                          11                  1
         *                          10                  3
         *                          9                   5
         *                          8                   7
         *      Now let's say, there are 8 people & the sowrd is at 7th person --> ans = 7
         * 
         * 
         *      EX:     N=13        1   2   3   4   5   6   7   8   9   10  11  12  13
         *                      remaining People    Starting Place
         *                      ----------------    --------------
         *                          13                  1
         *                          12                  3
         *                          11                  5
         *                          10                  7
         *                          9                   9
         *                          8                   11
         *      Now let's say, there are 8 people & the sowrd is at 7th person --> ans = 11
         *      Hence, whenever No. of people remaining are power of 2 --> Ans = that ith person
         *              - If after y steps, we reach to nearest power of 2
         *                      - for every remaining people, places will be shifted by 2
         *              - Then, ans will be 2y+1 --> ans = 2y + 1
         *              
         *      STEPS:
         *      ------
         *          - Find nearest power of 2 [ <= N ]  == p
         *                  - This will make sure No of people remaining will be power of 2
         *                  - To reach this, we will kill (N-p) people  == y
         *                  - for every people killed, sword will be moved by 2 places
         *          - Hence, ans = 2y + 1   [ Since starting place is 1 ]
         *                  - { 1 + kill1 = 3 + kill2 = 5 + kill3 = 7 + kill4 = 9 + kill5 = 11}
         *                  - here, for 5 kills, we moved from place 1 to place 11 -> which is "2y+1"
        */

        // Logic
        int p = 1;
        while ( p<=arr.length ) {
            p *= 2;
        }
        
        // we do this because loop exits only after it crosses the condition
        p = p/2;


        int y = arr.length - p;
        System.out.println(2*y + 1);
    }




    /*
     *  Q2: Majority Element            [ Google/Microsoft/Adobe/Meta/GoldmanSachs Problem]
     *      Given an array, return if there exists a number with freq > N/2 [ strictly greater than N/2]
     *      EX:
     *              arr = { 1   6   1   1   2   1 }                         ans = 1 [ since 6/2 = 3 & freq of 1 is 4]
     *              arr = { 3   4   3   6   1   3   2   5   3   3   3 }     ans = 3
     *              arr = { 4   6   5   3   4   5   6   4   4   4}          ans = none  [ No element's freq is > N/2 ]
    */
    public static void majorityElement (int[] arr) {
        /*
         *  Brute Force:
         *  -----------
         *      1. Call freq of all the elements using 2 loops 
         *         TC = O(N^2) || SC = O(1)
         *      2. Sort the array & find the freq of all elements in a single loop
         *         TC = O(NlogN) || SC = O(1)
         *      3. Use Hashmaps to store the freq in a single loop
         *         TC = O(N) || SC = O(N)
        */

        /*
         *  Observations:
         *  ------------
         *      - Majority Element will always be atmost 1 [i.e., 0 or 1]
         *      - Hence, freq ( majority ) > freq ( others )
         *      - Removing 2 distinct elements will not effect the majority element
         * 
         *  conclusion -> if we remove any 2 distinctive elements, Majority element still remains same
         * 
         *  ex:     arr = { 3   4   3   6   1   3   2   5   3   3   3 }
         *      majority = 1   1   1   1   1   1    = 6
         *             4 = 1
         *             6 = 1
         *             1 = 1
         *             2 = 1
         *             5 = 1
         *      here, if we remove any 2 distinct elements, let's say majority & 4, then
         *          majority = 1   1   1   1   1    = 5
         *             6 = 1
         *             1 = 1
         *             2 = 1
         *             5 = 1
         *      similarly, if we remove 2 distinctive elements again for 4 times like (3, 6), (3, 1), (3, 2), (3, 5)
         *          majority = 1  = 1
         *      Still majority element "3" won;t be get changed
         *  
         *  Approach:
         *  ---------
         *      - we traverse the array & calculate freq in such a way that 
         *              if any distinctive element is found, we reduce/increaese the freq
         * 
         *      EX:     arr = { 3   4   3   6   1   3   2   5   3   3   3 }
         *          Iteration           1   2   3   4   5   6   7   8   9   10  11      N -> Cancelled by distinct element
         *          Majority Element    3   N   3   N   1   N   2   N   3   3   3
         *          frequnecy           1   0   1   0   1   0   1   0   1   2   3       ans = 3
         * 
         *      whenever, the freq is 0 --> Majority element DOESN'T exists
         *                    freq is 1 --> Majority element exists
         *      
         *      But this fails for 
         *              arr = { 1   1   1   2   2   2   3 } 
         *              Iteration   1   2   3   4   5   6   7
         *              Majority    1   1   1   1   1   N   3
         *              freq        1   2   3   2   1   0   1       ans = 3 [ which is wrong as freq(3) < N/2 ]
         * 
         *  NOTE:
         *  -----
         *      - This algorithm is called "Moore's Voting Algorithm"
        */

        int majority = arr[0];
        int freq = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == majority ) {
                freq++;
            }
            else if (freq == 0) {
                majority =  arr[i];
                freq ++;
            }
            else {
                freq --;
            }
        }
        System.out.println( majority );
        // This above code only works if majority element is always present
        // If majority element doesn't always present, then we need check the freq of majority element & compare
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == majority) {
                count++;
            }
        }
        if (count > arr.length/2) {
            System.out.println(majority);
        }
        else {
            System.out.println("NO Majority Element");
        }
    }
    // TC = O(N) || SC = O(1)




    /*
     *  Q3: Doors Problem
     *      There are N doors, initially all are closed
     *      All the doors having 1 as their multiple, will be toggled
     *      All the doors having 2 as their multiple, will be toggled
     *      All the doors having 3 as their multiple, will be toggled and so on..
     *      Find the No. of doors opened
     *      
     *      EX      N = 7       1   2   3   4   5   6   7
     *              Initially   0   0   0   0   0   0   0           0 -> Closed
     *              1's mul     1   1   1   1   1   1   1           1 -> Opened
     *              2's         1   0   1   0   1   0   1
     *              3's         1   0   0   0   1   1   1
     *              4's         1   0   0   1   1   1   1
     *              5's         1   0   0   1   0   1   1
     *              6's         1   0   0   1   0   0   1
     *              7's         1   0   0   1   0   0   0       ans = 2
     * 
     *      EX      N = 20      1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20
     *              Initially   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     *              1's         1   1   1   1   1   1   1   1   1   1   1   1   1   1   1   1   1   1   1   1
     *              2's         1   0   1   0   1   0   1   0   1   0   1   0   1   0   1   0   1   0   1   0
     *              3's         1   0   0   0   1   1   1   0   0   0   1   1   1   0   0   0   1   1   1   0
     *              4's         1   0   0   1   1   1   1   1   0   0   1   0   1   0   0   1   1   1   1   1
     *              5's         1   0   0   1   0   1   1   1   0   1   1   0   1   0   1   1   1   1   1   0
     *              6's         1   0   0   1   0   0   1   1   0   1   1   1   1   0   1   1   1   0   1   0
     *              7's         1   0   0   1   0   0   0   1   0   1   1   1   1   1   1   1   1   0   1   0
     *              8's         1   0   0   1   0   0   0   0   0   1   1   1   1   1   1   0   1   0   1   0
     *              9's         1   0   0   1   0   0   0   0   1   1   1   1   1   1   1   0   1   1   1   0
     *              10's        1   0   0   1   0   0   0   0   1   0   1   1   1   1   1   0   1   1   1   1
     *          From 11's multiple onwards, only 1 element is available to toggle in each iteration
     *          Hence, we will directly toggle all doors from 11th onwards in a single loop
     *              remaining   1   0   0   1   0   0   0   0   1   0   0   0   0   0   0   1   0   0   0   0   
     *              ans = 4
     * 
     *      Obs:    door 9 is effected by   -> 1    3   9               -> Open
     *              door 15 is effected by  -> 1    3   5   15          -> Close
     *              door 18 is effected by  -> 1    2   3   6   9   18  -> Close
     *          - i.e., All the doors whoose having even no. of factors are CLOSED
     *          - i.e., All the doors whoose having ODD no. of factors are OPENED
     *          - But, only perfect squares will have odd no. of factors
     *                  - why..?    
     *                  - Only perfect sqaure will have one of the factor as (x, x) which we will consider as 1 factor
     *                  - Hence, we will get odd No. of factors
     *                  - This we have seen in 1st class as well
     * 
     *      Logic:
     *      ------
     *          - we need to find out all the perfect sqaures in the arrays
    */
    public static void doorProblem (int n) {
        int ans = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            ans ++;
        }

        System.out.println(ans);
    }
    // TC = O(sqrt(N)) ||| SC = O(1)
}
