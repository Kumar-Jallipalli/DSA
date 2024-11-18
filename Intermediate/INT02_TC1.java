package Intermediate;
public class INT02_TC1 {
    public static void main (String[] args) {


        /**
         * Q1: Sum of N Natural Numbers
         * A: 
         * - Let S be sum of N natural Numbers
         *      S = 1 + 2 + 3 + 4 + 5 ... N
         * - Now reverse the numbers from large to small
         *      S = N + (N-1) + (N-2) + (N-3) ... 1
         * - Now add the both
         * 
         *      S = 1 + 2 + 3 + 4 + 5 ... N
         *      S = N + (N-1) + (N-2) + (N-3) ... 1
         *      -----------------------------------
         *     2S = (N+1) + (N+1) + (N+1) ... (N+1)     [Total of N times]
         *     2S = (N+1) * N
         *      S = [N * (N+1)]/2
         * 
         * - Hence Sum of N Natural Numabers = [N * (N+1)]/2
        */


        /**
         * Q2: No. of Elements from [a, b] both included
         * A:
         * - No. of Elements in [3, 10] = {3, 4, 5, 6, 7, 8, 9, 10} == 8 
         *          -> [3, 10] = 10 - 3 == 7
         *          -> i.e., After 3 there are 7 numbers until & including 10
         *          -> To include 3 as well, we need to add 1 to 7 => 7+1 = 8
         * 
         * - No. of Elements in [4, 8] = {4, 5, 6, 7, 8} == 5
         *          -> 8-4 = 4 [ This gives only numbers excluding 4]
         *          -> To include 4 as well => 8-4+1 = 5
         * 
         * - Similarly, No. of Elements in [a, b]..?
         *          -> [b-a+1]
        */

        System.out.println("Hello Java \n This is Siva Jallipalli");
        
    }

    // Calculate the No. of Iterations for the Following Code Blocks
    public static void Q1 (int N) {
        int S = 0;
        for (int i=0; i <= 100; i++) {
            S = S + i;
        }
    }
    // Ans: 101 iterations ( Since, i = [0, 100] --> b-a+1 == 100-0+1 == 101 )


    public static void Q2 (int N) {
        int S = 0;
        for (int i=35; i <= 87; i++) {
            S = S + i;
        }
    }
    // Ans: 53 iterations ( Since, i = [35, 87] --> b-a+1 == 87-35+1 == 53 )


    public static void Q3 (int N) {
        int S = 0;
        for (int i=1; i <= N; i++) {
            S = S + i;
        }
    }
    // Ans: N iterations ( Since, i = [1, N] --> b-a+1 == N-1+1 == N )


    public static void Q4 (int N, int M) {
        int S = 0;

        for (int i=1; i <= N; i++) {
            if (i%2 == 0) {
                S = S + i;
            }
        }

        for (int i=1; i <= M; i++) {
            if (i%2 == 1) {
                S = S + i;
            }
        }
    }
    /**
     * Ans: (N+M) iterations 
     *      - 1st Loop runs for N iterations
     *      - 2nd Loop runs for M iterations
     *      - Total = N+M
    */


    public static void Q5 (int N) {
        int S = 0;
        for (int i=1; i*i <= N; i++) {
            S = S + i;
        }

        /**
         * Here, we can rewrite the condition as 
         *      i*i <= N
         *      i^2 <= N
         *      i <= sqrt(N)
        */

        for (int i=1; i <= Math.sqrt(N); i++) {
            S = S + i;
        }
    }
    // Ans: sqrt(N) iterations ( Since, i = [1, sqrt(N)] --> b-a+1 == sqrt(N-1+1 == sqrt(N) )


    public static void Q6 (int N) {
        int i = N;
        while (i > 1) {
            i = i/2;
        }
    }
    /**
     *          Iterations          i
     *              1              i = i/2  = N/2   = N/(2^1)
     *              2              i = i/2  = N/4   = N/(2^2)
     *              3              i = i/2  = N/8   = N/(2^3)
     *              4              i = i/2  = N/16  = N/(2^4)
     *              .
     *              .
     *              k              i = i/2  = N/(2^k)
     * 
     *  - Let's say after k iterations i becomes 1 [ i.e., i==1] --> Then loop breaks
     *  - i.e., after i becomes 1, NO. of iterations will be completed
     *          -> i = N/(2^k)
     *          -> 1 = N/(2^k)
     *          -> 2^k = N
     *          -> k = log(N)
     * 
     *  - After log(N) iterations, loop will break
     * 
     *  Ans: log(N)
    */


    public static void Q7 (int N) {
        int i = N;
        while (i > 0) {
            i = i/2;
        }
    }
    /**
     *  Ans: log(N) [ same as Above ]
     *      - After k iterations i = 1
     *      - After k+1 iterations i = i/2 == 1/2 == 0.5 which is < 0 -> breaks loop
     *      - iterations = log(N) + 1 == log(N) 
    */


    public static void Q8 (int N) {
        int S = 0;
        for (int i=0; i <= N; i=i*2) {
            S = S + i;
        }
    }
    // Ans: TLE


    public static void Q9 (int N) {
        int S = 0;
        for (int i=1; i <= N; i=i*2) {
            S = S + i;
        }
    }
    /**
     *  Ans: log(N)
     *      Iterations      i
     *          1           2
     *          2           2^2
     *          3           2^3
     *          4           2^4
     *          k           2^k
     * 
     *  - Lets say after k iterations, i will be equal to N [ i becomes N ]
     *          -> i == N
     *          -> 2^k == N
     *          -> k == log(N)
     *  - After log(N) iterations, loop breaks
    */


    /**
     * NOTE:
     * -----
     *      - Previously, in while loop N is being halfed for every iteration to bring down it;s value to 1
     *      - Now, in for loop, 1 is being doubled for every iteration to bring up the value to N
     *      - i.e., both the ways are same --> Hence we got the same ans : log(N) [ But approach is different ]
    */


    
    // How many times the "Hello World" will be printed
    public static void Q10 (int N) {
        for (int i=0; i<=N; i=i*2) {
            for (int j=1; j<=3; j++) {
                System.out.println("Hello World");
            }
        }
    }
    // Ans: Infinite times == TLE [ Since i will always be "0"]


    public static void Q11 (int N) {
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=3; j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j       Total Iterations
     *          1           1      [1->3]       3
     *          2           2      [1->3]       3 -> 3+3 = 6 
     *          3           3      [1->3]       3 -> 3+6 = 9
     *          4           4      [1->3]       3 -> 3+9 = 12
     *          5           5      breaks       
     * 
     *  Ans: 12 iterations
    */


    public static void Q12 (int N) {
        for (int i=1; i<=10; i++) {
            for (int j=1; j<=N; j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j       Total Iterations in J's loop
     *          1           1      [1->N]       N
     *          2           2      [1->N]       N  
     *          3           3      [1->N]       N 
     *          4           4      [1->N]       N 
     *          .           .       .           .
     *          .           .       .           .
     *          10          10     [1->N]       N 
     *          11          11     breaks   ----------- 
     *                                      Total = N*10 times = 10N
     * 
     *  Ans: 10N iterations
    */


    public static void Q13 (int N) {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j       Total Iterations in J's loop
     *          1           1      [1->N]       N
     *          2           2      [1->N]       N
     *          3           3      [1->N]       N 
     *          4           4      [1->N]       N 
     *          .           .       .           .
     *          .           .       .           .
     *          N           N      [1->N]       N 
     *          N+1         N+1    breaks   -------------
     *                                      Total = N*N times = N^2
     * 
     *  Ans: (N^2) iterations
    */


    public static void Q14 (int N) {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j       Total Iterations in J's loop
     *          1           1      [1->1]       1
     *          2           2      [1->2]       2  
     *          3           3      [1->3]       3 
     *          4           4      [1->4]       4 
     *          5           5      [1->5]       5 
     *          .           .       .           .
     *          .           .       .           .
     *          N           N      [1->N]       N 
     *          N+1         N+1    breaks   -------------
     *                                      Total = [1+2+3+..+N] == N*(N+1)/2
     * 
     *  Ans: N*(N+1)/2 iterations
    */


    public static void Q15 (int N) {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j=j*2) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j                       Total Iterations in J's loop
     *          1           1      [1, 2, 4, 8, 16, ... N]          log(N)
     *          2           2      [1, 2, 4, 8, 16, ... N]          log(N)
     *          3           3      [1, 2, 4, 8, 16, ... N]          log(N) 
     *          4           4      [1, 2, 4, 8, 16, ... N]          log(N) 
     *          .           .       .           .
     *          .           .       .           .
     *          N           N      [1, 2, 4, 8, 16, ... N]          log(N) 
     *          N+1         N+1    breaks                    ------------------- 
     *                                                       Total = N*log(N) times
     * 
     *  Ans: N*log(N) iterations
    */


    public static void Q16 (int N) {
        for (int i=1; i <= Math.pow(2, N); i++) {
            System.out.println("Hello World");
        }
    }
    // Ans: 2^N iterations


    public static void Q17 (int N) {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=Math.pow(2, i); j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i       j                   Total Iterations in J's loop
     *          1           1      [1->2^1] = [1->2]       2
     *          2           2      [1->2^2] = [1, 4]       2^2 
     *          3           3      [1->2^3] = [1, 8]       2^3 
     *          4           4      [1->2^4] = [1, 16]      2^4 
     *          .           .       .           .
     *          .           .       .           .
     *          N           N      [1->2^N] = [1, 2^N]     2^N 
     *          N+1         N+1    breaks                -------------
     *  
     *      Total = [2+4+8+16+32+ ... +2^N] == This is in GP
     *      Sum of 1st N terms in a GP = a*(r^N-1)/r-1
     *              -> 2*[(2^N)-1]/2-1 
     *              -> 2*[(2^N)-1]
     * 
     *  Ans: 2*[(2^N)-1] iterations
    */


    public static void Q18 (int N) {
        for (int i=N; i>0; i=i/2) {
            for (int j=1; j<=i; j++) {
                System.out.println("Hello World");
            }
        }
    }
    /**
     *      Iterations      i           j         Total Iterations in J's loop
     *          1           N        [1->N]         N
     *          2           N/2      [1->N/2]       N/2  
     *          3           N/4      [1->N/4]       N/4 
     *          4           N/8      [1->N/8]       N/8 
     *          5           N/16     [1->N/16]      N/16 
     *          .           .           .           .
     *          .           .           .           .
     *          k           1      [1->N/2^k]       N/2^k 
     * 
     *  Total = [N + N/2 + N/2^2 + N/2^3 + ... + N/2^k]  -> GP
     *              -> N*(1/2^k - 1)/(1/2)
     *              -> 2N*(1/2^k - 1)
     * 
     *  Ans: 2N*(1/2^k - 1) iterations
    */

}