package Intermediate;

import java.util.Scanner;

public class INTo8_Arrays5TwoDArrays {
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
        int n = mat[0].length;
        int m = mat.length;

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
        int n = mat[0].length;
        int m = mat.length;

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
    */
    public static void printALlDiagonals (int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;

        
        int q = 1;
        while (q<n-1) {
            int i = 0;
            int j = n-q;
            while (i<n) {
                System.out.println(mat[i][j]);
                i++; j--;
            }
            q++;
        }
    }

}
