public class INT12_BM3 {
    /*
     *  Storing -ve Numbers
     *  -------------------
     *  1. Let's say, we will use MSB [Most SIgnificant Bit] to store the sign of the Number [8-bit]
     *              EX:     10 :    0 0 0 0 1 0 1 0
     *                     -10 :    1 0 0 0 1 0 1 0
     * 
     *                       4 :    0 0 0 0 0 1 0 0
     *                      -4 :    1 0 0 0 0 1 0 0
     * 
     *      - Add 2 numbers     -4 :    1 0 0 0 0 1 0 0
     *                          10 :    0 0 0 0 1 0 1 0
     *                                 -----------------
     *                                  1 0 0 0 1 1 1 0  = -14
     * 
     *      - i.e., if we add (-4)+10, we are getting (-14) which is wrong
     * 
     *      - Similarly, we have    0 0 0 0 0 0 0 0     = 0
     *                              1 0 0 0 0 0 0 0     = -0    [This is also wrong]
     * 
     *      - Hence, this way of storing -ve Numbers is Wrong
     * 
     *  
     *  2. We use 2's Compliment to store -ve Numbers
     *      - Let's say we need to find the -ve number of a, Then
     *                  (-a) = 2's compliemt            [ 2's compliment = 1's compliment + 1 ]
     *                       = 1's compliemnt + 1       [ 1's compliment = inverse of all bits ]
     *                       = (~a) + 1
     * 
     *      EX: -10     10 :    0 0 0 0 1 0 1 0
     * 
     *                 ~10 :    1 1 1 1 0 1 0 1
     *                   1 :    0 0 0 0 0 0 0 1
     *                         -----------------
     *                 -10 :    1 1 1 1 0 1 1 0     -> This is how machine stores (-10)
     * 
     *      But wkt, 11110110 = (1*2^7) + (1*2^6) + (1*2^5) + (1*2^4) + (0*2^3) + (1*2^2) + (1*2^1) + (0*2^0) 
     *                        = 276
     * 
     *      But Actually, Machine stores MSB base value (2^n) as -ve => (-2^n), 
     *          - i.e., in 8-bit Number --> MSB == (-2^7) 
     *          - i.e., in 4-bit Number --> MSB == (-2^3) 
     *                  
     *      Then, 11110110 = (1*-2^7) + (1*2^6) + (1*2^5) + (1*2^4) + (0*2^3) + (1*2^2) + (1*2^1) + (0*2^0)
     *                           = -10
     * 
     *      Similarly, -4   =>  4 : 0 0 0 0 0 1 0 0
     * 
     *                         ~4 : 1 1 1 1 1 0 1 1
     *                          1 : 0 0 0 0 0 0 0 1
     *                              ---------------
     *                              1 1 1 1 1 1 0 0 = -4
     *      
     *      Now, we add 10 & -4    10 : 0 0 0 0 1 0 1 0
     *                             -4 : 1 1 1 1 1 1 0 0
     *                                 -----------------
     *                                1 0 0 0 0 0 1 1 0
     *      Here, upon adding 2 8-bit numbers, we got a 9-bit umber --> Hence, we will discrd the MSB
     *              Then 10+(-4) = 0 0 0 0 0 1 1 0  == 6
     * 
     *  - Hence, This is how we store the -ve negative Numbers [ by making the MSB base value as Negative ]
     * 
     *              Convert Binary to Decimal of these 4-bit signed numbers
     *                         (-2^3) (2^2) (2^1) (2^0)
     *                              1   0   1   1   --> -5
     *                              1   0   1   0   --> -6
     *                              0   0   1   1   -->  3
     *                              1   0   0   0   --> -8
     *                              1   1   1   1   --> -1
     * 
     *              Convert Binary to Decimal of these 8-bit signed numbers
     *                           (-2^7)   (2^6)   (2^5)   (2^4)   (2^3)   (2^2)   (2^1)   (2^0)
     *                              0       0       0       1       0       1       0       1   =   21
     *                              1       0       0       1       0       1       0       1   =   -107
     *                              1       0       0       1       0       0       0       1   =   -111
     *                              0       0       0       1       0       0       0       1   =   17
     * 
     * 
     *              Similarly, In an N-bit Number
     *                          (-2^(n-1)) ...  (2^6)   (2^5)   (2^4)   (2^3)   (2^2)   (2^1)   (2^0)
     *                          ----------      -----   -----   -----   -----   -----   -----   -----
     *          
     *              - Here, only MSB is contributing to -ve Value
     *              - Rest of all bits are contributing to +ve Value
     * 
     *              - Hence, Max -ve Number = [ 1 0 0 0 .. 0 0 0 ] = -2^(n-1)
     *              - Max +ve Number        = [ 0 1 1 1 .. 1 1 1 ] = 2^(n-1) - 1
    */
    

    /*
     *  Will MSB base value always be -ve..?
     *      - NO, It is based on type of Number
     *              - If Number is Signed Number --> NO, Base Value won't be Negative
     *              - If Number is UnSigned Number --> Yes, Base Value will be Negative
     * 
     *      - But in java, we don't have flexibility of signed & un-signed
     *              - All Numbers are signed only  
     *              - MSB will always be -ve in Java
     * 
     *      - In C, C++ & C#, we have flexibilty of signed & un-signed
     *              - So in these languages, MSB won;t be always -ve
    */


    /*
     *  Ranges in Signed Data Types
     *  ---------------------------
     *      - 2 bit Signed Numbers  == [-2, 1]
     *                  -2^1    2^0
     *                  -----   ---
     *                   0      0      =   0
     *                   0      1      =   1
     *                   1      1      =   -2
     *                   1      1      =   -1
     * 
     *      - 3 bit Signed Numbers == [-4, 3]
     *                  -2^2    2^1     2^0
     *                  ----    ---     ---
     *                   0       0       0      =   0
     *                   0       0       1      =   1
     *                   0       1       0      =   2 
     *                   0       1       1      =   3
     *                   1       0       0      =   -4
     *                   1       0       1      =   -3
     *                   1       1       0      =   -2
     *                   1       1       1      =   -1
     * 
     *      - We will get min value, when only the MSB is present and rest all are "0"s = -2^(n-1)
     *      - We will get max value, when all the bits excfept MSB are "1"s = [2^0 + 2^1 + 2^2 + .. + 2^n-2] = 2^(n-1) - 1
     * 
     *  Hence, Range in Signed bits = [-2^(n-1), 2^(n-1) - 1]
     * 
     *      Data Type       Bytes       Bits        Range
     *      ---------       -----       ----        -----
     *      Byte/Char       1           8           [-2^7, 2^7-1]   == [-18, 127]
     *      short int       2           16          [-2^15, 2^15-1] == [-32768, 32767]
     *      int             4           32          [-2^31, 2^31-1] == [-2*10^9, 2*10^9]   Approx
     *      long            8           64          [-2^63, 2^63-1] == [-8*10^18, 8*10^18]
     * 
     *      wkt, 2^10 = 1024 ~ 1000
     *              (2^10)^3 ~ (1000)^3
     *              2^30 ~ 10^9                 2^60 ~ 10^18
     *              2^31 ~ 2*10^9               2^63 ~ 8*10^18
    */
}
