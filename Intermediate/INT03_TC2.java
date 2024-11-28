// package Intermediate;

public class INT03_TC2 {
    public static void main(String[] args) {

        /*
         *  Comparison of 2 Algorithms
         *  --------------------------
         *      1. Execution Time
                        - Execution Time depends on So Many Factors [ system specs, temp, OS etc..]
                        - Hence, we generally don’t compare execution time between 2 Algorithms
                2. Iterations
                        - Hence, we use No. of Iterations to Compare 2 Algo’s
                        - i.e., calculate the No. of Iterations based on the Input size and compare them
        */
        
    }

    // Space Complexity
    public static void SC1 (int N) {
        int x = N;
        int y = N*N;
        long z = x+y;
    }
    /**
     *  SC of the above function is O(1)
     *      - As, space is independent of Input
     *      - Total Memory = 4+4=4+8 = 20 Bytes
     *      - It will take this 20 Bytes of Memory irrespective of value of N
    */


    public static void SC2 (int N) {
        int x = N;
        int y = N*N;
        long z = x+y;
        int[] arr = new int[N];
    }
    /**
     *  SC = O(N)
     *      - As, space of Array is Depenedent of Input N
     *      - Memory = 4+4+4+8+4N = 4N+20 = O(N)
    */


    public static void SC3 (int N) {
        int x = N;
        int y = N*N;
        long z = x+y;
        int[] arr = new int[N];             // N variables will be Created
        long[][] arr1 = new long[N][N];     // N^2 Variables will be Created
    }
    /**
     *  SC = O(N)
     *      - As, space of Array is Depenedent of Input N
     *      - Memory = 4+4+4+8+4N+8N^2 = 8N^2+4N+20 = O(N^2)
    */


    /**
     *  NOTE:
     *  -----
     *      SC → Amount of Space Additionally used by Algo other than User’s Input to Perform Computation
                    - Hence, we ignore the User’s Input Memory Space
                    - This Additional Space is called Auxiliary Space

            Why..?
                        I/P ---> [ Algo ]  ---> O/P
                - Here, I/P is dependent on the User, But Not on the Algorithm
    */



    public static void SC4 (int[] arr, int N) {
        int max = arr[0];
        for (int i=0; i<N; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }
    /**
     *  TC = O(N)
     *  SC = O(1) [ 4+4 = 8 bytes]
    */


    public static void SC5 (int[] arr) {
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];

        for (int i=1; i<n; i++) {
            pf[i] = arr[i] + pf[i-1];
        }
    }
    /**
     *  TC = O(N)
     *  SC = O(N)
     *      - Here, Memory = 4+4n+4 = 4N+8 bytes
    */



    /*
     *  Which one to Optimize First, TC or SC..?
     *      - In Most cases, we will be asked to Optimize the TC first & then SC
    */



    /*
     *  TLE
     *  ---
            - TLE → Time Limit Exceeding Error
                - It helps us to check whether the code will work or not without writing a single line [ using Constrains ]
            - Generally, An Ideal Processor runs at 1GHz → 10^9 instructions per sec
            - Instruction → Any Variable declaration/Assignment (or) Any Operation (or) any Condition (or) Function calling etc..
                - i.e., any operation performed is an Instruction
    */

    public static void countFactor(int N) {
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (N%i == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    /*
     *  Here, No. of Instructions inside the loop are
     *      - i=1 --> 1  || i<=N --> 1 || i++ --> 1 || N%i --> 1 || == 0 --> 1 || count++ --> 1
     *      - Total = 6 instructions
    */


    /*
     *  Assumptions
     *  -----------
            - A single loop will contain at most 10 instructions
                - i.e., 1 Single Iteration = 10 instructions
            - An Ideal Processor runs at 1GHz → 10^9 instructions per sec
                - i.e., our code can contain at most 10^9 instructions
                - 10^9 instructions == 10^8 X 10 instructions
                - 10^8 X 10 instructions== 10^8 iterations
                - i.e., our Code can have at most 10^8 Iterations
    */


    /*
     * Questions
     * ---------
     *      Q. If in a Code 1 Iteration contains 100 instructions, How many iterations it can perform..?
                    - WKT, An ideal computer can perform 10^9 instruction only
                        - 1 iteration contains 100 instructions
                        - Therefore, only 10^7 iterations can be performed

            Q2. WKT, TLE helps us to check whether the code will work or not without writing a single line [ using Constrains ], 
                How..?
                    - If the constrains say 1 ≤ N ≤ 10^5
                    - Then O(N^2) = 10^10
                    - which is greater than 10^8 → Not possible to code with TC = O(N^2) Algo else it will throw TLE
                    - Hence we need to write an Algo with TC = O(N)
    */

}
