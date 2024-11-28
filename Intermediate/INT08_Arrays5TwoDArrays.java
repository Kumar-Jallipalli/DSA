// package Intermediate;

import java.util.Scanner;

public class INT08_Arrays5TwoDArrays {
    public static void main(String[] args) {
        /*
         *  Matrices:
         *  ---------
         *      - Matrices are 2D arrays [ in CS ]
         *      - mat[n][m] --> n rows && m columns
        */

        // How to Create a Matrix by taking input from Users
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        // TC = O(N*M) || SC = O(N*M)

        sc.close();
    }



    /*
     *  Q1: Given a Matrix, Print row-wise
     *          ex:     Mat[3][4] = 3 8  9  2
     *                              1 2  3  6
     *                              4 10 11 17
     * 
     *          Ans: 3 8  9  2 
     *               1 2  3  6 
     *               4 10 11 17
    */
    public static void printRowWise (int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    // TC = O(N*M) || SC = O(1)



    /*
     *  Q2: Given mat[n][m], Find Max col sum
     *          ex:     Mat[3][4] = 3 8  9  2
     *                              1 2  3  6
     *                              4 10 11 7
     * 
     *                      Ans:    8 20 23 15  --> 23          
    */
    public static void printMaxColSum (int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int max = Integer.MIN_VALUE;
        for (int j=0; j<m; j++) {
            int sum = 0;
            for (int i=0; i<n; i++) {
                sum += mat[i][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
    }
    // TC = O(N*M) || SC = O(1)
    // We cannot initialize max = 0 (or) mat[0][0]



    /*
     *  Q3: Given a mat[n][n], Print it's Diagonals
     *          ex:     Mat[4][4] = 3 8  9  2
     *                              1 2  3  6
     *                              4 10 11 7
     *                              2 8  5  9
     *          Ans: 3 2 11 9 || 2 3 10 2
    */
    public static void printDiagonals (int[][] mat) {
        int n= mat.length;

        // Left to Right Diagonal
        for (int i=0; i<n; i++) {
            System.out.println(mat[i][i]);
        }
        // Right to Left Diagonal
        int i=0, j=n-1;
        while (i<n) {
            System.out.println(mat[i][j]);;
            i++; j--;
        }
        // TC = O(N) || SC = O(1) || Iterations = 2N


        // 2. Combining above two in a single loop
        for (i=0; i<n; i++) {
            System.out.println(mat[i][i]);

            j = (n-1)-i;
            System.out.println(mat[i][j]);
        }
        // TC = O(N) || SC = O(1) || Iterations = N

        // 2. Using while loop
        i = 0; j = n-1;
        while (i<n) {
            System.out.println(mat[i][i]);
            System.out.println(mat[i][j]);
            i++; j--;
        }
    }



    /*
     *  Q4: given mat[n][m], Print all the diagonals from R->L
     *          ex:     Mat[3][4] = 3 8  9  2
     *                              1 2  3  6
     *                              4 10 11 7
     *          Ans:    7
     *                  6 11
     *                  2 3 10
     *                  9 2 4
     *                  8 1
     *                  3           Total Diagonals = 6
     * 
     *          ex:     Mat[4][6] = 3 8  9  2 0 1
     *                              1 2  3  6 3 4
     *                              4 10 11 7 5 6
     *                              1 2  3  4 7 8
     *          Ans:    8
     *                  6 7
     *                  4 5 4
     *                  1 3 7 3
     *                  0 6 11 2
     *                  2 3 10 1
     *                  9 2 4
     *                  8 1
     *                  3           Total Diagonals = 9
     * 
     *      Generic:
     *      --------
     *          - Total No. of Diagonals in a mat[n][m] = n+m-1
     *      
     *      why..?
     *          - Diagonals start with either 1st row (or) last column
     *                  - 1st row contains - n elements
     *                  - last column contains - m elements
     *                  - But here corner element is present in both 1st row & last column --> 2 times counted
     *          - Hence ans = n+m-1
     * 
     *      Sol:
     *          - If we know the start indices of each diagonal elements, we can print all diagonal elements by i++ && j--
     *                  - Start indices will be --> 1st row & last column
     *                  - Condition will be --> ( i<n && j>=0 )
    */
    public static void printALlDiagonals (int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // 1st row
        for (int i=0; i<m; i++) {
            int x = 0;
            int y = i;
            while (x<n && y>=0) {
                System.out.println(mat[x][y]);
                x++; y--;
            }
        }

        // last column
        for (int i=1; i<n; i++) {
            int x = i;
            int y = n-1;
            while (x<n && y>=0) {
                System.out.println(mat[x][y]);
                x++; y--;
            }
        }
    }
    /*
     *  TC = O(n*M) || SC = O(1)
     *      - As we are printing all the elements, TC will be O(n*m)
    */




    /*
     *  Q5: Given mat[n][n], FInd the Transpose inplace --> SC=O(1)
     *      EX:     1  2  3  4  5       Sol:    1  6  11  16  21
     *              6  7  8  9  10              2  7  12  17  22
     *              11 12 13 14 15              3  8  13  18  23
     *              16 17 18 19 20              4  9  14  19  24    
     *              21 22 23 24 25              5  10 15  20  25
     * 
     *      Here, [0, 1] became [1. 0]
     *            [1, 2]        [2, 1] asn son on//
    */
    public static void transposeOfMatrix (int[][] mat) {
        int n = mat.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i<j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        // TC = O(N^2) || SC = O(1) || Iterations = O(N^2)

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // TC = O(N^2) || SC = O(1) || Iterations = O(sum of 1st n/2 terms)
    }



    /*
     *  Q6: Given mat[n][n], Rotate 90degrees Clockwise [ SC = O(1)]
     *      EX:     1  2  3  4  5       Sol:    21 16 11  6  1
     *              6  7  8  9  10              22 17 12  7  3
     *              11 12 13 14 15              23 18 13  8  3
     *              16 17 18 19 20              24 19 14  9  4    
     *              21 22 23 24 25              25 20 15  10 5
     * 
     *      Here, we will be printing elements from i=n-1 tp i=0 & increase j by 1
     *      i.e., we will be printing columns wise
    */
    public static void rotate90Degrees (int[][] mat) {
        int n = mat.length;

        for (int j=0; j<n; j++) {
            for (int i=n-1; i>=0; i--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        /*
         *  Sir's Approach
         *      - Transpose the matrix
         *      - Then reverse the matrix
        */

    }



    /*
    *  Q7: Given mat[n][n], Print all boundaries in clockwise
    *      EX:     1  2  3  4  5       Sol:    1  2  3  4  5
    *              6  7  8  9  10              6           10
    *              11 12 13 14 15              11          15
    *              16 17 18 19 20              16          20
    *              21 22 23 24 25              21 22 23 24 25
    *      
    *      This can be printed as 
    *              1  2  3  4      --> i=0         j=0 to n-2      --> [0,0]       -> [0, n-2]     --> N-1 Elements
    *              5  10 15 20     --> i=0 to n-2  j=n-1           --> [0, n-1]    -> [n-2, n-1]   --> N-1 Elements
    *              25 24 23 22     --> i=n-1       j=n-1 to 1      --> [n-1, n-11] -> [n-1, 1]     --> N-1 Elements
    *              21 16 11 6      --> i=n-1 to 1  j=0             --> [n-1, 0]    -> [1, 0]       --> N-1 Elements
    */
    public static void boundaryElements (int[][] mat) {
        int n=mat.length;
        int i=0, j=0;

        // This loop will run for N-1 Times
        for (int k=1; k<n; k++) {
            System.out.println(mat[i][j]);
            j++;
        }
        // After the completion of above loop --> i=0 && j=n-1

        // This loop will run for N-1 Times
        for (int k=1; k<n; k++) {
            System.out.println(mat[i][j]);
            i++;
        }
        // After the completion of above loop --> i=n-1 && j=n-1

        // This loop will run for N-1 Times
        for (int k=1; k<n; k++) {
            System.out.println(mat[i][j]);
            j--;
        }
        // After the completion of above loop --> i=n-1 && j=0

        // This loop will run for N-1 Times
        for (int k=1; k<n; k++) {
            System.out.println(mat[i][j]);
            i--;
        }
        // After the completion of above loop --> i=0 && j=0
    }



    /*
     *  Q8: Given mat[n][n], Prit Spirally
    */
    public static void printSpirally (int[][] mat) {
        int n=mat.length;
        int i=0, j=0;
        
        while (n>0) {  // 10853
            // This is to print that single elment when n is odd
            if (n==1) {
                System.out.println(mat[i][j]);
            }  

            // This loop will run for N-1 Times
            for (int k=1; k<n; k++) {
                System.out.println(mat[i][j]);
                j++;
            }
            // After the completion of above loop --> i=0 && j=n-1

            // This loop will run for N-1 Times
            for (int k=1; k<n; k++) {
                System.out.println(mat[i][j]);
                i++;
            }
            // After the completion of above loop --> i=n-1 && j=n-1

            // This loop will run for N-1 Times
            for (int k=1; k<n; k++) {
                System.out.println(mat[i][j]);
                j--;
            }
            // After the completion of above loop --> i=n-1 && j=0

            // This loop will run for N-1 Times
            for (int k=1; k<n; k++) {
                System.out.println(mat[i][j]);
                i--;
            }
            // After the completion of above loop --> i=0 && j=0

            i++; j++; n-=2;
        }
    }
}
