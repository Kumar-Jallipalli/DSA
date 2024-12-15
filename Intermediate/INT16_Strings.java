public class INT16_Strings {
    /*
     *  STRINGS:
     *  --------
     *      - Strings -> Sequence of Characters
     *      - ASCII [ AMerican Standard Code for Information Interchange] of various characters are
     *              - 'A' == 65     'a' == 97       '0' == 48
     *              - 'Z' == 90     'z' == 122      '9' == 57
     *      - Immutable Strings -> Strings cannot be Changed/Modified
     *              - Java, Python & other Languages follows this immutability
     *              - EX:   String str = "abc";
     *                      str[0] = "d";
     *                      print(str);     --> dbc
     *                      String str2 = "abc";
     *                      String str3 = "abc";
     *              - Here, "abc" string gets created in a special memory called String Pool & str will point to it
     *              - Now if we modify the str, a new string will be created with the modification "dbc"
     *              - str will now point to new string "dbc"
     *              - String str2 = "abc"; --> This doesn't create a new string "abc", but uses the existing one
     *              - String str3 = "abc"; --> This too points to the same existing "abc"
     *                      - If Nothing is assigned to Old string "abc", It will be collected by Garbage Collector 
     *              - str[0] = "d"  --> This actually is NOT O(1) Operation
     *                      - This operation costs O(N), as all the lements needs to be copied to make a new string
     *      - String Pool
     *              - Whenever a new String gets created
     *                      - String pool will 1st check whether that string is available in the pool or not
     *                      -  If the string is available, it will use that string to assign
     *                      - Else, it will create a new String
     *              - In this way, String Pool is used to Save memory in these languages
     * 
     *  Appending char to an Immutable String
     *              - String s1 = 'a';
     *              - s1 = s1 + 'b';        -> A new String "ab" gets Created & s1 will point to it     -> Costs O(N)
     *              - s1 = s1 + 'c';        -> A new String "abc" gets Created & s1 will point to it    -> Costs O(N)
     *              - s1 = s1 + 'd';        -> A new String "abcd" gets Created & s1 will point to it   -> Costs O(N)
     *              - Hence, If we Append "n" times --> 
     *                      - TC = O(N^2) -> Since each append costs O(N) & there are n appends
     *                      - SC = O(N^2) -> Each Append creates a New String which takes O(1) space & there are n appends
     *                                    -> But if we consider char's at each append, there will be n*(n+1)/2 -> O(N^2)
     * 
     *  Problem:
     *      - Modifying the String costs O(N) --> Costly
     *      - Hence, StringBuilder is developed in Java
    */


    public static void main(String[] args) {
        /*
        *  StringBuilder:
        *  -------------
        *              - In StringBuilder, Strings are NOT Immutable
        *              - Hence, Modification of String Costs O(1)
        *               - It comes with java.lang package
        *               - StringBuilder sb = new StringBuilder();   --> Creates a SB Object
        *               - Now we cab perform operations on this SB Object
        */
        // StringBuilder sb = new StringBuilder("abc");
        // sb.append('d');           // TC = O(1)
        // System.out.println(sb);     // Datatype = Object [ NOT String ]
        // System.out.println(sb.toString());     // Now Datatype = String
        // sb.setCharAt(1, 'f');      // To modify a char in a String
        /*
         *  Why SB operations costs only O(1)..?
         *          - Because, behind the Scenes, SB uses Array of Characters [ Not the "String pool" unlike String ]
         *          - Hence, Operations costs only O(1)
        */

        char[] arr = { 'h', 'e', 'r', 'e', ' ', 'i', 's', ' ', 'a', ' ', 'b', 'o', 'y' };
        reverseWords( arr );
    }



    /*
     *  Q1: Given a String S, Toggle the case of every Character
     *      Upper Case -> Lower Case        Lower Case -> Upper Case
     *      EX:     S = aBcDEf      -> Ans = AbCdeF
    */
    public static void toggleChar (String S) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i)>='A' && S.charAt(i)<='Z') {
                sb.append(S.charAt(i)+32);
            }
            else {
                sb.append(S.charAt(i)-32);
            }
        }
        System.out.println(sb.toString());

        /*
         *  Using Bit Manipulation:
         *  ----------------------
         *          - WKT, difference between 'A' & 'a' is 32
         *          - Why..?
         *                  - It is due to the 5th bit 
         *                  - In ‘A’ 5th bit is OFF
         *                  - In ‘a’ 5th bit is ON
         *          - Range of 'a' && 'z' --> 97 to 122
         *                  - for the numbers to be in this range, bits must be like
         *                          0   0   1   1                       -> Remaining bits change according to numbers
         *                          _   _   _   _   _   _   _   _   _   
         *                          8   7   6   5   4   3   2   1   0
         *          - Range of 'A' && 'Z' --> 65 to 90
         *                  - for the numbers to be in this range, bits must be like
         *                          0   0   1   0                       -> Remaining bits change according to numbers
         *                          _   _   _   _   _   _   _   _   _   
         *                          8   7   6   5   4   3   2   1   0
         *          - The only difference between caps & Small letters is the 5th bit ON/OFF
         * 
         *          - So, if we toggle that particular 5th bit, case will be toggled
         *          - Hence, do char^(1<<5)
        */
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<S.length(); i++) {
            ans.append(S.charAt(i)^(1<<5));
        }
        System.out.println(ans.toString());
    }
    // TC = O(N) || SC = O(N)




    /*
     *  Q2: Given a String of Lowercase char, Sort it in Dictionary Order
     *      EX:     S = dabaedb     ans = aabbdde
     * 
     *      Logic:
     *          - We store all the repeating char's as a freq in an int[]
     *          - Here, each ind in the int[] represents the alphabets in sequence
     *          - Once we get the freq of each alphabet, we will print each alphabet base on freq
    */
    public static void sortChar (String S) {
        // getting the freq of each alphabet
        int[] count = new int[26];
        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            int ind = ch - 'a';
            count[ind] ++;
        }

        // Sorting the STring by appending the each char based on freq
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            for (int j=0; j<count[i]; j++) {
                char ch = (char) (i + 'a');
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
    // TC = O(N) || SC = O(N)
    /*
     *  Why TC = O(N) [ instead of O(NlogN) ] ..?
     *      - Because, we have worked only on 26 char's
     *      - This is called Count SOrting
    */



    /*
     *  Q3: Given a String S and 2 indices l & r, Reverse the substring from l to r
     *      EX:     S = abdeagf     l=2 & r=5       ans = abgaedf
    */
    public static void reverseSubString ( String S, int l, int r) {
        StringBuilder sb = new StringBuilder(S);

        while (l<r) {
            // Swap
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++; r--;
        }

        System.out.println(sb.toString());
    }
    // TC = O(N) || SC = O(N)




    /*
     *  Q4: Given a Char Array storing a Sentence, Reverse it word by word
     *              No extra space is allowed
     *              Every word is separated by a single white space
     *              Noo inbuilt method can be used
     *      EX: char[] arr = { h, e, r, e,  , i, s,  , a,  , b, o, y }   ans = boy a is here 
     *                 ans = { b, o, y,  , a,  , i, s,  , h, e, r, e }
     * 
     *      logic:
     *          - 1st we will reverse the whole string "ereh si a yob"
     *          - Now we will reverse the individual words whenever we find the spcae
     *          - "here is a boy"
     *      No extra space is allowed --> Cuz, they have given char[] instead of String
    */
    public static void reverseWords (char[] arr) {
        // reverse the whole array
        int l = 0;
        int r = arr.length-1;
        while (l<r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }

        // reverse the individual words
        l=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == ' ') {
                r=i-1;

                // reversing the word
                while (l<r) {
                    char temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++; r--;
                }

                // updating the start ind
                l = i+1;
            }
        }

        // for the last word --> Since there wont be a " "
        r = arr.length-1;
        while (l<r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }



    /*
     *  Arraylist's TC
     *  --------------
     *      - Arraylist behind the scenes uses Array
     *      - At 1st, it will have some predefined capacity let's say 4
     *      - Now, if we insert 4 elements into arraylist & start inserting 5th one
     *              - Then Arraylist size will double now
     *              - after doubling the size, 5th element is inserted into arraylist
     *              - So, will the TC for 5th element insertion is O(1) --> NO
     *              - 5th element insertion takes O(N)
     *              - But 6th, 7th & 8th elements are still O(1) & 1st to 4th are also O(1)
     *      - Hence TC of Arraylist is Ammortised O(1) --> Avg O(1)
    */
}
