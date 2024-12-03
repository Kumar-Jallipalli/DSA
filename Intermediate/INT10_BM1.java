public class INT10_BM1 {
    /*
     *  Number System Basics:
     *  ---------------------
     *      - 6594 == (6*10^3) + (5*10^2) + (9*10^1) + (4*10^0)
     *              == 6000 + 500 + 90 + 4
     *              == 6594
     *      - This is called Decimal System
     * 
     *  Decimal System
     *      - Base is 10
     *      - Contains [ 0 to 9 ] numbers
     * 
     *  Octal System
     *      - Base is 8
     *      - Contains [ 0 to 7 ] numbers
     * 
     *  Hexa-Deimal System
     *      - Base is 16
     *      - Contains [ 0 to 9 && A B C D E F ] numbers
     * 
     *  Binary System
     *      - Base is 2
     *      - Contains [ 0 & 1 ] numbers only
     * 
     *  Any System to Decimal:
     *  ---------------------
     *      - To Convert any Number System to Decimal Number System, 
     *              - Mark the indices in Reverse order
     *              - Multiply each digit with it's corresponding Number System's Base to power of digit's Index
     *      EX:
     *          (10100) -> Binary to Decimal
     *                  4       3       2       1       0
     *              [   1       0       1       0       0   ]       -> Base = 2
     *                  1*2^4   0*2^3   1*2^2   0*2^1   0*2^0
     *                  16      0       4       0       0
     *              = 16+4 == 20
     *          (10100) in Binary == (20) in Decimal
     * 
     *          (127) -> Octal to Decimal
     *                  2       1       0
     *              [   1       2       7   ]       -> Base = 8
     *                  1*8^2   2*8^1   7*8^0   
     *                  64      16       56       
     *              = 64+16+56 == 136
     *          (127) in Binary == (136) in Decimal
     * 
     *          (9A) Hexa to Decimal
     *                  1       0   
     *                  9       A           -> Base = 16
     *                  9*16^1  10*16^0
     *                  144     10
     *                  = 144+10 == 154
     *          (9A) in Hexa == (154) in Decimal
     * 
     * 
     *  Any System to Binary:
     *  ---------------------
     *      - To Convert any Number System to Decimal Number System, 
     *              - Divide the Number with 2 until the Number itself becomes to 0 (or) 1
     *              - Write the Reminders of each division Numbers in Revers Order
     *      EX:
     *          (37) -> Decimal to Binary
     *                  | 37
     *                  -----
     *                2 | 18    1   -> 5
     *                  -----
     *                  | 9     0   -> 4            (37) == (100101)
     *                  -----
     *                  | 4     1   -> 3
     *                  -----
     *                  | 2     0   -> 2
     *                  -----
     *                  | 1     0   -> 1
     *                  -----
     *                    0     1   -> 0
     *      
     *          (25) -> Decimal to Binary
     *                  | 25
     *                  -----
     *                2 | 12    1   -> 4
     *                  -----
     *                  | 6     0   -> 3            (37) == (11001)
     *                  -----
     *                  | 3     0   -> 2
     *                  -----
     *                  | 1     1   -> 1
     *                  -----
     *                    0     1   -> 0
     *          
     * 
     *  Adition of 2 Decimal Numbers
     *  ----------------------------
     *      - Let'a add 2 Decimal Numbers 7839 & 3948
     *  
     *                             (8+9)/10   (9+8)/10
     *              carry Forward       1   0   1           
     *                                  7   8   3   9
     *                                  3   9   4   8
     *                                  --------------
     *              Ans                 11  7   8   7
     *                                              (9+8)%10 = 7
     * 
     *      - Carry Forward = (a+b)/10
     *      - digit = (a+b)%10
     *      Since "10" is base for Decimal
     * 
     *  Addition of 2 Binary Numbers
     *  ----------------------------
     *      - Let'a add 2 Binary Numbers 10110 & 00111
     *                            (1/2)   (3/2)   (2/2)   (1/2)
     *                              0       1       1       0
     *                              1       0       1       1       0
     *                              0       0       1       1       1
     *                              ---------------------------------
     *                             (1%2)  (1%2)    (3%2)   (2%2)   (1%2)
     *                              1       1       1       0       1
     * 
     *      - Carry Forward = (a+b)/2
     *      - digit = (a+b)%2
     *      Since "2" is base for Decimal
     * 
     *  Generalization:
     *  ---------------
     *      - Carry Forward = (a+b)/base
     *      - digit = (a+b)%base
    */


    /*
     *  Bitwise Operators:
     *  ------------------
     *      "&"     - And   [ If both 1 -> 1 | esle 0]
     *      "|"     - Or    [ If any one has 1 -> 1 | else 0]
     *      "^"     - XOR - Addition without Carry  [ If both same -> 0 || If both NOT same -> 1 ]
     *      "~"     - Inverse   [ Opposite of itself ]
     *      "<<"    - Left Shift
     *      ">>"    - Right Shift
     * 
     *  Truth Table
     *  -----------
     *          a       b       a&b     a|b     a^b     ~a      ~b
     *         ---     ---      ---     ---     ---     --      --
     *          0       0       0       0       0       1       1
     *          0       1       0       1       1       1       0
     *          1       0       0       1       1       0       1
     *          1       1       1       1       0       0       0
     * 
     *  EX: 
     *      if a=29, b=19 then print a&b
     *          a = 1 1 1 0 1
     *          b = 1 0 0 1 1
     *         --------------
     *        a&b = 1 0 0 0 1 == 17
     *        a|b = 1 1 1 1 1 == 31
     *        a^b = 0 1 1 1 0 == 14
     * 
     *  Propertie:
     *  ----------
     *      1. a&1 = 0/1 [ if a is even -> 0 || if a is odd -> 1 ]
     *               i.e., simply check the last digit of a
     *                  if last digit of a is 1 [odd] -> 1 
     *                  else if last digit is 0 [even] -> 0
     * 
     *      2. a&0 = 0     
     *      3. a&a = a
     * 
     *      4. a|0 = a
     *      5. a|1 = 
     *      6. a|a = a
     * 
     *      7. a^0 = a
     *      8. a^1 = (a-1)/(a+1) [ if odd = a-1 || else even = a+1] 
     *      9. a^a = 0
     * 
     *      10. a&b == b&a      => a&b&c == b&c&a == c&b&a
     *      11. a|b == b|a      => a|b|c == b|c|a == c|b|a
     *      12. a^b == b^a      => a^b^c == b^c^a == c^b^a
     * 
     * 
     *  EX:
     *      1. a^b^a^d^c ==?
     *              = (a^b)^(a^b)^d 
     *              = 0^d 
     *              = d
     *      
     *      2. e^f^a^f^e^g^f
     *              = (a^a)^(e^e)^{f^f}^g   
     *              = 0^0^0^g
     *              = g
    */


    /*
     *  Q: Given N array Elements, Every element repeats twice except 1, find the unique element
     *      Ex: arr = { 6 9 10 6 9 }            --> Ans = 10
     *          arr = { 12 9 8 12 8 7 9 8 }     --> Ans = 7
    */
    public static void main (int[] arr) {
        int n = arr.length;
        // Brute force [ loop through every element & find the unqiue ]
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(arr[i]);
                break;
            }
        }
        // TC = O(N^2) || Sc = O(1)

        // Optimal [ use XOR operator ]
        int ans = 0;
        for (int i=0; i<n; i++) {
            ans = ans^arr[i];
        }
        System.out.println(ans);
        // TC = O(N) || SC = O(1)
    }


    /*
     *  Left Shift:
     *  ----------
     *      - Let's assume or numbers are 8-bit numbers
     *  Ex:                 7   6   5   4   3   2   1   0
     *      a=10            0   0   0   0   1   0   1   0   = 10 -> 10*2^0
     *                    /    /   /   /   /   /   /   /
     *      a<<1    discard   0   0   0   1   0   1   0   0 -> This is added  
     *                  ans = 00010100  = 20 -> 10*2^1
     *                  - "o" is always added to last digit & First digit is always discarded
     *      
     *      a<<2            0   0   1   0   1   0   0   0   -> 40   = 10*2^2
     *      a<<3            0   1   0   1   0   0   0   0   -> 80   = 10*2^3
     *      a<<4            1   0   1   0   0   0   0   0   -> 160  = 10*2^4
     *      a<<5            0   1   0   0   0   0   0   0   -> Here, we lost important bit due to discard --> OverFlow
     * 
     *      a<<1 = a*2^1
     *      a<<2 = a*2^2
     *      a<<3 = a*2^3            =>      a<<n = a*2^n    [ until Overflow ]
     *      a<<4 = a*2^4
    */ 
}
