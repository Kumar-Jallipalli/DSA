public class INT11_BM2 {
    /*
     *  - WKT,  a<<2 == a*2^2
     *          a<<n == a*2^n
     *  - what if a==1..?
     *          a<<2 = 1<<2 = 2^2
     *          a<<n = 1<<n = 2^n
     * 
     *      Therefore, 2^n = 1<<n
    */


    /*
     *  Right Shift
     *  -----------
     *      - we move the bit towards right side by 1 bit
     *      - Let's assume all numbers will be 8 bit Numbers
     *  
     *                (2^7)   (2^6)   (2^5)   (2^4)   (2^3)   (2^2)   (2^1)   (2^0)
     *      x=10        0       0       0       0       1       0       1       0       -> 2^3 + 2^1 = 10
     *      
     *      x>>1                0       0       0       0       1       0       1       -> 2^2 + 2^0 = 5    = 10/2
     *  
     *      x>>2                        0       0       0       0       1       0       -> 2^1 = 2          = 10/2^2
     * 
     *      x>>3                                0       0       0       0       1       -> 2^0 = 1          = 10/2^3
     * 
     *      x>>4                                        0       0       0       0       -> 0                = 10/2^4
     * 
     *  - Here, we always discard the last bit & we always assume 1st bit as "0"
     * 
     *  Generalise:
     *  -----------
     *      x>>1 = x/2
     *      x>>2 = x/2^2
     *      x>>n = x/2^n
     * 
     *  In Java
     *      int a   --> 4 bytes --> 32 bits --> [31 - 0]
     *      long a  --> 8 bytes --> 64 bits --> [63 - 0]
    */


    /*
     *  Q1: Given N, i. Check if the ith position in N is Set [1] or Un-Set [0]
     *      EX: N = 21 && i=2       
     *                  4   3   2   1   0
     *              N = 1   0   1   0   1       i=2     --> Set
     *          
     *          N = 34 && i=3
     *                  5   4   3   2   1   0
     *              N = 1   0   0   0   1   0   i=3     --> Un-Set
     * 
     *  Brute Force
     *      - Convert Decimal to Binary & store it in a variable
     *      - Check if ith bit is "1" or "0"
     * 
     *  Optimal
     *      - Right shift the number by "i" times   --> N>>i    == x
     *      - Now, ith bit will be at the 0th bit
     *              - if x is odd --> set           (or) [ if 0th bit of a is 0, Then a&1 = 0]
     *              - else x is even --> Un-Set     (or) [ if 0th bit of a is 1, Then a&1 = 1]
     * 
     *                      6   5   4   3   2   1   0
     *      EX: N = 82      1   0   1   0   0   1   0       i=3
     * 
     *                                  6   5   4   3
     *          N>>3                    1   0   1   0       
     *              
     *          Now, 3rd Ind is in 0th Ind position --> Now Compare (N>>i)&1 == 0 (or) 1
    */
    void ithPositionCheck (int N, int i) {
        if ( ((N>>i)&1) == 1 ) {
            System.out.println("Set");
        }
        else {
            System.out.println("Un-Set");
        }
        /*
         *  We can do this as well
         *  1.
         *      int x = N>>i
         *      if ( (x&1) == 1) {
         *          System.out.println("Set");
         *      }
         * 
         *  2. return (N>>i)&1 == 1     // This checks Set bit [ 1==1 --> True, which is Checking Set ]
        */


        /*
         *  We can do the above Q in another way, which is opposite way of above
         *          - we will left shift the "1" by i times
         *          - Now we will do N&(1<<i)
         *                  - if this N&(1<<i) == 0 --> Unset
         *                  - else Set
        */
        if ( (N&(1<<i)) == 0 ) {
            System.out.println("Un-Set");
        }
        else {
            System.out.println("Set");
        }
        // return !(N&(1<<i)) == 0          --> Checks for Set bit
        // return (N&(1<<i)) == (1<<i)      --> Checks for Set bit
    }
    // TC = O(1) || SC = O(1)



    /*
     *  Note:
     *  -----
     *      - All the Operators will take O(1) TC
     *      - Hence, as (N<<i) is also an Operator --> Bit wise Left SHift Operator --> TC = O(1)
     * 
     *      - 1<<5 == pow(2,5)
     *      - But, 1<<5 is faster than pow(2,5)
    */




    /*
     *  Q2: Gievn Integer N, Calculate how many Set bits in N
     *      EX: N = 10      1 0 1 0     ans = 2
     *          N = 27      1 1 0 1 1   ans = 4
     * 
     *  Brute Force
     *      - Convert to Binary
     *      - count 1's
     * 
     *  Optimal
     *      - An integer contains 32 bits
     *      - check each bit is Set or Un-Set by right/Left Shift as seen in above Problem
     *      - make a note of count in each shift
    */
    void countSetBits (int N) {
        int count = 0;

        // 1. An Integer contains 32 bits
        for (int i=0; i<32; i++) {
            if ( ((N>>i)&1) == 1 ) {
                count++;
            }
        }
        System.out.println(count);
        // TC = O(1) || SC = O(1)   || Iterations = 32


        // 2. Optimising above algo
        count = 0;
        while (N>0) {
            if ((N&1) == 1) {
                count++;
            }
            N = N>>1;
        }
        System.out.println(count);
        // TC = O(logN) | SC = O(1) || Iterations = logN
        /*
         *  - In Terms of pure TC, Method-1 is better
         *  - But, Actually, logN is better
         *  - Why..?
         *      - In Worst Case, N can have 2^32 as it's Max value [ Since, N is an Int ] --> log(2^32) == 32
         *      - At Max, TC=logN == 32 == Iterations
         *      - But All the times, it can have less than 32 [which depends on N]
         * 
         *  - Hence, In this case O(logN) > O(1) 
        */
    }



    /*
     *  Q3: Given x, y. Set xth bit & yth bit & return the value
     *      Initially, all bits will be "0"
     *      EX:             7 6 5 4 3 2 1 0
     *                      0 0 0 0 0 0 0 0   
     *          x=3 || y=1          1   1       == 1010 == 10
     *          x=5 || y=2      1     1         == 100100   == 36              
    */
    int setBits (int x, int y) {
        if (x == y) {
            return (1<<x);
        }
        return ( (1<<x) + (1<<y) );
        // (x == y) ? return (1<<x) : return ( (1<<x) + (1<<y) );

        // Method 2 : using Bitwise or
        // return ( (1<<x)|(1<<y) );
        // This works for all cases
    }



    /*
     *  Q4: Given N, Set ith Bit in N
     *      EX:             3   2   1   0
     *          N=10,       1   0   1   0   
     *          i=2             1               == 1110 == 14
     *      
     *                      4   3   2   1   0
     *          N=23        1   0   1   1   1
     *          i=2                 1           == 10111 == 23
    */
    int setIthBit (int N, int i) {
        return (N|(1<<i));
    }



    /*
     *  TO-DO: Given N, Un-Set ith Bit in N
     *      EX:             3   2   1   0
     *          N=10,       1   0   1   0   
     *          i=2             0               == 1010 == 10
     *      
     *                      4   3   2   1   0
     *          N=23        1   0   1   1   1
     *          i=2                 0           == 10011 == 19
    */
    int unSetIthBit (int N, int i) {
        return 1;
    }




    /*
     *  TO-DO: Gievn x, y. Set all x continuous bits & then unset y continuous bits
     *          EX: x=3, y=2 --> 11100  = 28
     *              x=4, y=2 --> 111100 = 60
    */
    int setXUnsetY (int x, int y) {
        int ans = 0;
        for (int i=y; i<x+y; i++) {
            ans += (1<<i);
        }
        return ans;
    }

}
