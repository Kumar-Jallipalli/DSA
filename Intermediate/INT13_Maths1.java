public class INT13_Maths1 {
    /*
     *  Modulus/Remainder Operator ( % ):
     *  --------------------------------
     *      - WKT,      Dividend = Divisor * Quotient + Remainder
     *              EX:
     *                      10%4 = ?    --> 10 = 4 * (10/4) + r     => 10 = 8 + r   => r=2
     *                      13%5 = ?    --> 13 = 5 * (13/5) + r     => 13 = 10 + r  => r=3
     *                      150%7 = ?   --> 150 = 7 * (150/7) + r   => 150 = 147 + r    => r=3
     *  
     *                      -60%9 = ?   --> -90 = 9 * (-60/9) + r   => -60 = -54 + r    => r = -6
     *      - This is how machine does calculation [ we can verify via IDE as well ]
     * 
     * 
     *  Why we need %..?
     *  ----------------
     *      - We required % to limit the range of numbers when we divide
     *              - i.e., if we divide any rumber from -infinity to +infinity with 10 -> we will always get [0, 9] as remainder 
     *              - i.e., if we divide any rumber from -infinity to +infinity with m -> we will always get [0, m-1] as remainder 
     *                      - But in the above case of (-60%9), we are getting -6 [ instead of [0, 8] ] 
     *      - This % is Used in consistet Hashing, cryptography etc..
     * 
     * 
     *  Conceptually
     *  ------------
     *                  Remainder = Dividend - (Divisor*Quotient)
     *      here, (Divisor*Quotient) == (greatest multiple of the Divisor <= Dividend)
     *      EX:     10%4    --> How cloase can we get to 10     => 10-( greatest multiple of 4 <= 10 ) = 10-8    ans=2
     *              150%7   --> How cloase can we get to 150    => 150-147  ans=3
     * 
     *              -60%9   --> How cloase can we get to -60    
     *                      => -60-( greatest multiple of 9 <= -60 ) 
     *                                  greatest multiple of 9 nearer to -60 are -63 & -54
     *                                  But out of -63 & -54, -63 <= -60
     *                      => -60 - (-63) 
     *                      => ans = 3  [ i.e., we are 3 steps closer to -60 when we divide with 9]
     *                              [ Logically this "3" is correct. But previously, we got ans as -6 
     *                                              => we are -6 steps closer to -60 when we divide with 9 => Totally Wrong] 
     *                              => Logically/Conceptually = 3
     *                                 In Language [ i.e., from IDE ] = -6
     * 
     *              -40 % 7 --> -40 - ( greatest multiple of 7 <= -40 )
     *                      => -40 - (-42)
     *                      => 2
     *  
     *              -80 % 9 --> -80 - ( greatest multiple of 9 <= -80 )
     *                      => -80 - (-81)
     *                      => 1    [ But we got -8 in java & 1 in python ]
     *                                  => Logically/Conceptually = 1
     *                                     In Language [ i.e., from IDE ] = -8  [ Wrong ]
     * 
     *      - Hence, to make it Right in Language as well
     *                  if ( x < 0 ) --> { x%p + p }              
     * 
    */
    public static void main(String[] args) {
        System.out.println(-40%9);
    }



    /*
     *  Modular Arithmatic:
     *  -------------------
     *      1. (a + b) % M = (a % M) + (b % M)          --> WRONG   [ Range = [0, 2M-2] ]
     *                     = ((a % M) + (b % M)) % M    --> RIGHT   [ Range = [0, M-1] ]
     *      EX: a=6, b=13, M=7
     *          (a + b) % M == 19 % 7 == 5
     *          (a % M) + (b % M) == (6 % 7) + (13 % 7) == 6 + 6 == 11
     *          ((a % M) + (b % M)) % M == ((6 % 7) + (13 % 7)) % 7 == (6 + 6) % 7 == 12 % 7 == 5
     * 
     *      2. (a * b) % M = (a % M) * (b % M)          --> WRONG   [ Range = [0, (M-1)^2] ]
     *                     = ((a % M) * (b % M)) % M    --> RIGHT   [ Range = [0, M-1] ]
    */ 



    /*
     *  Q1: Given a, n, p. Calculate (a^n)%p
     *      Constrains:     1 <= N <= 10^5      1 <= a <= 10^9      1 <= p <= 10^9
     *      EX: a=3, n=4, p=7   => (3^4)%7  == 81%7 ==4
    */
    public static void modulusOfPower (int n, int a, int p) {
        long ans = 1;
        for (int i=0; i<n; i++) {
            ans = (ans*a)%p;    // To stop overflow
        }

        System.out.println(ans%p);  // we can also print ans
    }
    // TC = O(N) || SC = O(1)



    /*
     *  Divisibility of 3:
     *  ------------------
     *      - WKT, to check divisibility of 3, we need to check whether sum of all digits is divisible by 3
     *      - But why..?
     *              - 3456 % 3
     *              - ((3*10^3) + (4*10^2) + (5*10^1) + (6*10^0)) % 3
     *              - ( (3*10^3)%3 + (4*10^2)%3 + (5*10^1)%3 + (6*10^0)%3 ) % 3
     *              - ( (3%3 * 10^3%3 )%3 + (4%3 * 10^2%3 )%3 + (5%3 * 10^1%3 )%3 + (6%3 * 10^0%3 )%3 ) % 3
     *              - ( (3%3 * 1 )%3 + (4%3 * 1 )%3 + (5%3 * 1 )%3 + (6%3 * 1 )%3 ) % 3
     *              - ( (3%3 )%3 + (4%3 )%3 + (5%3 )%3 + (6%3 )%3 ) % 3
     *              - ( (3%3 ) + (4%3 ) + (5%3 ) + (6%3 ) ) % 3
     *              - ( (3) + (4) + (5) + (6) ) % 3
     *              - ( 3 + 4 + 5 + 6 ) % 3
     * 
     * 
     *  Divisibility of 4
     *  -----------------
     *      - Divisibility of == (last 2 digits divisible by 4)
     *      - Why..?
     *              - abcdef % 4
     *              - ( (a*10^5) + (b*10^4) + (c*10^3) + (d*1o^2) + (ef) ) % 4
     *              - ( (a*10^5)%4 + (b*10^4)%4 + (c*10^3)%4 + (d*1o^2)%4 + (ef)%4 ) % 4
     *              - ( (a%4 * 10^5%4 )%4 + (b%4 * 10^4%4)%4 + (c%4 * 10^3%4)%4 + (d%4 * 1o^2%4)%4 + (ef)%4 ) % 4
     *              - ( (a%4 * 0 )%4 + (b%4 * 0)%4 + (c%4 * 0)%4 + (d%4 * 0)%4 + (ef)%4 ) % 4
     *              - ( 0 + 0 + 0 + 0 + (ef)%4 ) % 4
     *              - ( (ef)%4 ) % 4
     *              - (ef)%4 
     * 
     *  Divisibility of 9
     *  -----------------
     *      - WKT, to check divisibility of 9, we need to check whether sum of all digits is divisible by 9
    */



    /*
     *  Q2: Given 1 Number as an Array where each element in array is each digit of number, Cal number % p
     *      Constrains:     0 <= arr[i] <= 9        1 <= N <= 10^5      1 <= p <= 10^9
     *      EX: arr = {7, 8, 6, 9 2}    ans = 78692%p
    */
    public static void numberArrayModulus (int[] arr, int p) {
        /*
         *  Constrain:
         *          if N = 3    => 9 9 9        == 999      == 10^3 -1
         *          if N = 4    => 9 9 9 9      == 9999     == 10^4 -1
         *          if N = 10     == 10^10 -1
         *          if N = 10^5     == (10)^(1o^5) -1   --> Cannot be stored i a long
         * 
         *      arr[5] -> arr[0], arr[1], arr[2], arr[3], arr[4]
         *      Number = ( arr[0]*10^4 + arr[1]*10^3 + arr[2]*10^2 + arr[3]*10^1 + arr[4]*10^0 ) % p
         * 
         *      - Here, we have 2 problems
         *              1. Sum of all terms
         *              2. for each terms, power of 10 is increaing from 0 [10^0] to 10^5 [10^(10^5)]
         * 
         *      1. sum of all terms can be solved by 
         *              ( arr[0]*10^4 + arr[1]*10^3 + arr[2]*10^2 + arr[3]*10^1 + arr[4]*10^0 ) % p
         *                              Using (a + b) % m = (a%m + b%m)%m
         *              ( (arr[0]*10^4)%p + (arr[1]*10^3)%p + (arr[2]*10^2)%p + (arr[3]*10^1)%p + (arr[4]*10^0)%p ) % p
         *              ( ( arr[0]%p * 10^4%p )%p + .... + ( arr[4]%p * 10^0%p )%p )
         * 
         *      2. power of 10
         *              ans = 1
         *              ans = (ans*10) % p      -> this always stores value (p-1) in ans variable even after 10^5 iterations
        */
        int ans = 0;
        int power = 1;
        int ten = 1;
        for (int i=arr.length-1; i>=0; i--) {
            power = (power*ten)%p;
            ans = ans + (arr[i]%p * power )%p;

            ten = ten*10;
        }
        System.out.println(ans);
        // TC = O(N) || SC = O(1)


        // 2. Sir's solution
        int sol = 0;
        int pow = 1;
        for (int i=arr.length-1; i>=0; i--) {
            sol = sol + (arr[i]%p * pow%p )%p;
            sol = sol%p;    // This is to be safe for ans variable not to be overflown

            pow = (pow*10)%p;
        }
        System.out.println(sol);
        // TC = O(N) || SC = O(1)
    }

}
