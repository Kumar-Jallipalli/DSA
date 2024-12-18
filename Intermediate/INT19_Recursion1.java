public class INT19_Recursion1 {
    /*
     *  RECURSION:
     *  ---------
     *          - A function calling itself is called "Recusrion"
     *          - It is Solving a Problem, using smaller instances of same problem
     *                  EX:     sum(N) = sum(N-1) + N
     *                      sum(N) -> Bigger Problem
     *                      sum(N-1) -> Sub Problem | Smaller instance of same problem
     *          - why Recursion..?
     *                  - Merge Sort & Quick Sort
     *                  - Binary Trees, BST, BBST, Segment Trees & Tries
     *                  - Dynamic Programming
     *                  - Back Tracking
     *                  - Graphs
     *                  - ALl the above are based on Recursion
     *                  - Hence, we need to learn Recusrion 
     * 
     *          - How to write Recusrion Code
     *                  1. Assumption
     *                     We have a Imaginary Friend named HARRY [ like Alfred to Batman ]
     *                     Harry knows how to solve any sub-problem
     *                  2. Main Logic
     *                     Solve Bigger Problem with Sub-Problem 
     *                     And ask HARRY to solve that sub-problem for us
     *                  3. Base Condition
     *                     To Stop Recursion call [ going infinity --> Stack Overflow ]
     *                     Just write the answer for the Smallest Input you know
     *                     i.e., we will write edge conditions for which sub-problem fails
     * 
     *          NOTE:
     *          -----
     *                  - In Recursion, if your code gives Memory Limit Execeeding Error [ Stack Overflow ]
     *                  - That means, Code is NOT Stopped Properly --> Verify the Base COndition
    */

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNum(15));
        System.out.println(factorial(5));
        System.out.println(fibinocci(11));
        printIncreasingN(15);
    }


    /*
     *  Q1: Cal sum of 1st N natural Numbers using Recursion
    */
    public static int sumOfNaturalNum (int n) {
        // Base Condition
        if ( n == 1 ) {
            return 1;
        }

        // Main logic
        int ans = sumOfNaturalNum(n-1) + n;

        return ans;
    }



    /*
     *  Q2: Cal the factorial of N using Recursion
    */
    public static int factorial (int n) {
        // Base Condition
        if (n == 1) {
            return 1;
        }

        // Logic
        int fact = factorial(n-1) * n;

        return fact;
    }



    /*
     *  Q3: Print Fibinocci series until N
     *     Inp  0   1   2   3   4   5   6   7   8   9   10
     *    fib() 0   1   1   2   3   5   8   13  21  34  55
     *          fib(10) == 55
     *          fib(7) == 13
    */
    public static int fibinocci (int n) {
        // Base Condition
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        // we can simplify the above Base Cond like this
        if (n==1 || n==0) {
            return n;
        }

        // logic 
        int ans = fibinocci(n-1) + fibinocci(n-2);

        return ans;
    }



    /*
     *  Q4: Given N, Print all numbers from 1 -> N in increasing order
    */
    public static void printIncreasingN (int n) {
        // base Condition
        if (n == 1) {
            System.out.println(n);
            return;
        }

        // calling Harry to solve sub-problem,
        // Harry will print all numbers until N-1
        printIncreasingN(n-1);

        // I just need to print n, as Harry will print n-1
        // printing numbers
        System.out.println(n);
    }



    /*
     *  Q5: Given a Sub-String, Check if it is a Palindrome or NOT
     *      EX:           0123456
     *              str = gooddad   s=4 && e=6      ans = true
     *                              s=2 & e=5       ans = false
    */
    public static boolean checkSubStringPalindrome (char[] ch, int s, int e) {
        // Base Condition
        if (s>=e) {
            return true;
        }

        // // Logic
        // if (ch[s] == ch[e]) {
        //     // If end char's are same, then check the if sub-problem is palindrome or NOT
        //     if(checkSubStringPalindrome(ch, s+1, e-1)) {
        //         return true;
        //     }
        //     else {
        //         return false;
        //     }
        // }
        // else {
        //     return false;
        // }


        // Simplifying the above logic
        // If end char's are same && sub-problem is also palidrome then only retrun "true"
        // If anyone of the 2 cases faile --> return false
        if (ch[s] == ch[e] && checkSubStringPalindrome(ch, s+1, e-1)) {
            return true;
        }
        else {
            return false;
        }
    }

}