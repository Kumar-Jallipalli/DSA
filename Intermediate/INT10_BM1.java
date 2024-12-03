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
     *      "^"     - XOR   [ If both same -> 0 || If both NOT same -> 1 ]
     *      "~"     - Inverse   [ Opposite of itself ]
     *      "<<"    - Left Shift
     *      ">>"    - Right Shift
     * 
     *  Truth Table
     *  -----------
     *          a       b       a&b     a|b     a^b     ~a
     *         ---     ---      ---     ---     ---     -- 
     *          0       0       0       0       0       1
     *          0       1       0       1       1       1
     *          1       0       0       1       1       0
     *          1       1       1       1       0       0
     */
}
