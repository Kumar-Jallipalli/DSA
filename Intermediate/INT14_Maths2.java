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
         *          - Find nearest power of 2 [ <= N ]  == y
         *                  - This will make sure No of people remaining will be power of 2
         *                  - To reach this, we will kill y people
         *                  - for every people killed, sword will be moved by 2 places
         *          - Hence, ans = 2y + 1
        */
    }
}
