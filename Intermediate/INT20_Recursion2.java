public class INT20_Recursion2 {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(34678));
        System.out.println(powerAtoN(3, 4));
    }


    /*
     *  Q1: Sum of the digits of a number using recursion
    */
    public static int sumOfDigits (int n) {
        // Base Condition
        if (n == 0) {
            return 0;
        }

        // Logic 
        int digit = n%10;
        n = n/10;
        int ans = sumOfDigits(n) + digit;

        return ans;
    }
    /*
     *  TC = ?
     *          T(N) = T(N-1) + remaining code's TC
     *          T(N) = T(N-1) + 1
     *                  Similarly, T(N-1) = T(N-2) + 1
     *          T(N) = T(N-2) + 2
     *          T(N) = T(N-3) + 3
     *      Generalizing
     *          T(N) = T(N-k) + k
     *      WKT, T(0) = 1 && put k = N
     *          T(N) = T(0) + N
     *          T(N) = 1 + N
     *      => TC = O(N)
     */



    /*
     *  Q2: Cal power (a, n) --> i.e., cal a^n
     *      EX: a=3 | n=4 => 3^4 = 81
    */
    public static long powerAtoN (int a, int n) {
        //Base Condition
        if (n == 0) {
            return 1;
        }

        // Logic   --> a^n = a^(n-1) * a
        long ans = powerAtoN(a, n-1) * a;

        return ans;
    }
    /*
     *  Tracing:
     *      n=4     pow(3, 3) * 3   -> 3*3*3 * 3 == 81
     *      n=3     pow(3, 2) * 3   -> 3*3 * 3
     *      n=2     pow(3, 1) * 3   -> 3 * 3
     *      n=1     pow(3, 0) * 3   -> 3
     *  TC = O(N)
    */

    /*
     *  2. Optimised Recursion:
     *  -----------------------
     *          - Before, we are using a^n = a^(n-1) * a
     *          - Now, we will use
     *                  a^10 = a^5 * a^5
     *                  a^11 = a^5 * a^5 * a
     *                  a^12 = a^6 * a^6 * a
     *                  a^13 = a^6 * a^6 * a
    */
    public static long powerAtoNOpt (int a, int n) {
        // Base Condition
        if (n == 0) {
            return 1;
        }

        // logic
        long split = powerAtoNOpt(a, n/2);
        long ans = split*split;
        if (n%2 == 0) {
            return ans;
        }
        else {
            return ans*a;
        }
    }
    /*
     *  Tracing:
     *      n=8     pow(3, 4)   -> (3*3 * 3*3) * (3*3 * 3*3) == 81
     *      n=4     pow(3, 2)   -> (3*3) * (3*3)
     *      n=2     pow(3, 1)   -> (1*1) * (1*1) * 3
     *      n=1     pow(3, 0)   -> 1*1
     *  
     *  TC ..?
     *          T(N) = T(split) + remaining code's TC
     *          T(N) = T(N/2) + 1
     *              similarly, T(N/2) = T(N/4) + 1
     *          T(N) = T(N/4) + 2
     *          T(N) = T(N/8) + 3
     *      Generalize
     *          T(N) = T(N/(2^k)) + k
     *      WKT, T(0) = 1
     *      But, we cannot get N/(2^k) == 0 for any value of k
     *      And we also know T(1) = 1
     *      To get T(1), we need to put k = logN
     *          T(N) = T(N/(2^logN)) + logN
     *          T(N) = 1 + logN
     *  TC = logN
     * 
     *  - Everytime it is halfing => TC = O(logN)
     *          EX:     inpu    N       log(N)
     *                  10^9    10^9    30          
     *                          10s     3*10^(-7) s     => That much differeence
     * 
     *  - This is called "FAST EXPONENTIATION" Method
    */




    /*
     *  Q3: Cal (a^n)%p
     *      constaints :    1 < (a,n,p) < 10^9
    */
    public static long modPowerAtoN (int a, int n, int p) {
        // Base Condition
        if (n == 0) {
            return 1;
        }

        // logic
        long split = powerAtoNOpt(a, n/2) % p;

        /*
         *  Here, split*split == 10^9 * 10^9 == 10^18
         *  Hence to avoid overflow, we will make "split" as long data type
        */
        long ans = (split%p * split%p) % p;
        if (n%2 == 0) {
            return ans;
        }
        else {
            return (ans%p * a%p)%p;
            /*
            *  Here, ans*a == 10^9 * 10^9 == 10^18
            *  Hence to avoid overflow, we will make "ans" as long data type
            */
        }
    }



    /*
     *  TC for fact(N) ..?
     *          code: return fact(n-1) * n
     *          T(N) = T(N-1) + 1       T(N-1) time will be taken by fact(N-1)
     *          T(N) = T(N-k) + k
     *              WKT, T(0) = 1 && put k=n
     *          T(N) = 1+N
     *  TC = O(N) 
    */

    /*
     *  Solve Eq:   T(N) = 2T(N/2) + 1
     *      let's assume, 2T(N/2) will be sub-problem's TC & 1 will be the remaining's TC
     *                  Then T(N/2) = 2T((N/2)/2) + 1 == 2T(N/4) + 1
     *              T(N) = 2*(2T(N/4)+1) + 1
     *              T(N) = 4T(N/4) + 3
     * 
     *              T(N) = 4T(2T(N/8)+1) + 3
     *              T(N) = 8T(N/8) + 7
     *      Generalize
     *              T(N) = (2^k)*T(N/2^k) + 2^k-1
     * 
     *      if we assume T(1) = 1 -> Then put k = logN
     *              T(N) = N*T(1) + N-1
     *              T(N) = 2N-1
     *              T(N) = N
    */

    /*
     *  Solve Eq:   T(N) = 2T(N-1) + 1
     *                      T(N-1) = 2T(N-2) + 1
     *                      T(N) = 2[2T(N-2) + 1] + 1
     *              T(N) = 4T(N-2) + 3
     *                      T(N-2) = 2T(N-3) + 1
     *                      T(N) = 4[2T(N-3) + 1] + 3
     *              T(N) = 8T(N-3) + 7
     *      Generalize
     *              T(N) = (2^k)* T(N-k) + 2^k-1
     * 
     *      If we assume T(0) = 1 --> Then put k = n
     *              T(N) = (2^N)T(0) + 2^N-1
     *              T(N) = 2*(2^N)-1
     *              T(N) = O(2^N)
    */


    /*
     *  TC for fibinacco(N)..?
     *          T(N) = T(N-1) + T(N-2) + 1
     *          T(N) = T(N-2)+T(N-3)+1 + T(N-3)+T(N-4)+1 + 1
     *          T(N) = T(N-2) + 2T(N-3) + T(N-4) + 3
     *          T(N) = T(N-3)+T(N-4)+1 + 2[T(N-4)+T(N-5)+1] + T(N-5)+T(N-6)+1 + 3
     *          T(N) = T(N-3) + 3T(N-4) + 3T(N-5) + T(N-6) + 7
     *  This type of recursive calls TC cannot be done in our normal way
     * 
     *  NOTE: If more than 1 Time Functions is present, Better to go with Recursive Method
     * 
     *      L-1:            f(N)                                2^0 calls
     *      L-2             f(N-1)  f(N-2)                      2^1 calls
     *      L-3         f(N-2)  f(N-3)  f(N-3)  f(N-4)          2^2 calls
     *      .           .       .           .       .
     *      .       .   .       .           .       .   .
     *      L-N   f(N-(N-1))    .           .       .   .       2^(N-1) calls
     * 
     *          Total function/Recursive calls = 2^0 + 2^1 + 2^2 + 2^3 + ... + 2^(N-1)  == 2^N
     *      TC = O(2^N)
    */



    /*
     *  SPACE COMPLEXITY:
     *  -----------------
     *      - SC in Recursion is --> Max Stack size at any given point
     *      - In sum of N numbers problem
     *              - Code -> return sum(N-1) + N
     *              - Here, call stack will keep on increasing until it reaches from sum(N) to sum(1)
     *              - Once it reaches sum(1), sum(1) will return the value to sum(2) & 
     *              - sum(2) returns it's value to sum(3) & so on..
     *              - SC = O(N) [ when all N fn calls are in the stack ]
     *      - In fibinacco(N) problem
     *              - Code = return fib(N-1) + fib(N-2)
     *              - Here, fib(N-1) calls fib(N-2) & fib(n-3) 
     *              - But fib(n-3) is only called once fib(N-2) gets it's value
     *              - In trhis way, only 1 leg of the fn call will be stacking in the stack
     *              - That leg reaches to fib(1), then it will return the value to it's callee
     *              - Hence, from fib(n) to fib(1) --> N fn calls in s single leg
     *              SC = O(N)
    */
}
