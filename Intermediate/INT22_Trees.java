

// Linked List Creation
class Node {
    int val;
    Node next;

    Node (int a) {
        val = a;
    }

    Node createList (int n) {
        Node head = new Node (0);
        Node temp = head;

        for (int i=1; i<n; i++) {
            Node node = new Node (i);
            temp.next = node;
            temp = node;
        }

        return head;
    }
}
/*
 *  STEPS:
 *      1. Create a HEAD Node
 *      2. Create a Temp pointer [ to iterate over the nodes ]
 *      3. use a loop to create Nodes
 *      4. use temp variable to change the pointer for each nodes
*/




public class INT22_Trees {
    /*
    *  Q1: Delete a LL
    */
    Node deleteLL (int p, Node head) {
        // Edge Case
        if (p == 0) {
            head = head.next;
            
            return head;
        }

        // Actual Cases
        Node temp = head;

        // Iterating to go to the required node [ i.e., previous to deleted Node ]
        for (int i=1; i<p; i++) {
            temp = temp.next;
        }

        // Deleting the Node
        temp.next = temp.next.next;

        return head;
    }
    /*
     *  - Here, we do not have to explicity point the deleted node to null
     *  - AS, the LL deleted node cannot be reached in any manner
     *  - It will be removed by Garbage Collector
     * 
     *  Garbage Collector:
     *  ------------------
     *      - It will remove all the data which CANNOT be reached
     *      - It only deletes the data from HEAP 
    */
}



/**
 *  TREES:
 *  ------
 *      - Data Structures like Arrays, ArrayLists, LinkedLists, Stacks etc.. are --> Linear DS
 *              - These DS's cannot be used for Hiearchy data
 *              - These cannot be used for Seaching Operation [ Searching is most frequently used in CS ] 
 * 
 *      - "Trees" is a Hiearchial DS --> Non-Linear DS
 *      - EX: HTML page, File Structure in OS
 *      - Terminology
 *              root --> Top Most Node [ Has NO Parent ]
 *              edges --> Arrow pointers
 *              Nodes --> Individual data in the tree 
 *              siblings -> Nodes which have same Parent
 *              Leaf Node -> Node which doesn't have a Child
 * 
 *      Binary Trees -> A Tree where every node contains atmax 2 child nodes
 * 
 *  NOTE:
 *  -----
 *      - Parent Node has references to CHild Nodes
 *      - But Child Nodes has NO reference to Parent Node
 *      
*/

/*
 *  TREE Traversals
 *  ---------------
 *      - For Traversal of Tree Nodes, we CANNOT use Loops
 *      - why..?
 *              - Because, we need to go back to Parent Node once our job is done with Child nodes
 *              - This cannot be done with Loops [ As loops are Unidirectional ]
 *              - As LL are Linear & Unidirectiional, Loops are used in LL for Traversal
 *      - Hence, we will use Recursive method
 *      - why Recursive method..?
 *              - Because, Tree itslef is made out of "FRACTALS"
 *              - Tree itslef behaves like a Recursive Tree [ A Node, Left SubTree & Right SubTree ]
 * 
 *      - We now know that, we can traverse the Tree Nodes usng Recursive Method
 *      - How many ways we can Traverse/Iterate..?
 *              - In Linked Lists, we don't have an Option for Traversal/Iteration
 *                      - There is only 1 way, which is Linear way 
 *                      - i.e., using head node, we will go to next node & so on.. 
 *              - But in Trees, we have 2 ways,
 *                      - Left
 *                      - Right
 *              - And including Root Node with Left Node & Right Node, we can traverse recursively as
 *                            1           2      3       4       5       6
 *                  1.      Root        Root    LST     LST     RST     RST
 *                  2.      Left ST     RST     Root    RST     LST     Root
 *                  3.      Right ST    LST     RST     Root    Root    LST
 *              - Other than above 6 ways, we can Travers
 *                      - In-Order
 *                      - Zig-Zag & so on..
 *              - Because of these many ways of Traversal, some Standard ways of Traversal are maintained
 *      - These Standard/Conventional Traversal follows LST must be traversed before RST
 *              - If we follows this standard [ LST must be traversed before RST ]
 *              - we will be having with only 3 ways out of 6 mentioned above
 *              - These 3 ways of Traversal are based on the Order of the Root Node visited
 *                      - If Root node is visited 1st --> Pre-Order
 *                      - If Root node is visited 2nd --> In-Order
 *                      - If Root node is visited 3rd --> Post-Order
 * 
 *  Pre-Order Traversal
 *          - It is a type of Tree Traversal where it follows Root-Left-Right traversal
 *                  1st visit the ROOT & print
 *                  Then traverse the LEFT sub-tree
 *                  Finally traverse the RIGHT sub-tree
 *  In-Order Traversal
 *          - It is a type of Tree Traversal where it follows Left-Root-Right traversal
 *                  1st traverse the LEFT sub-tree
 *                  then visit the ROOT & print
 *                  Finally traverse the RIGHT sub-tree
 *  Post-Order Traversal
 *          - It is a type of Tree Traversal where it follows Left-Right-Root traversal
 *                  1st traverse the LEFT sub-tree
 *                  then traverse the RIGHT sub-tree
 *                  Finally visit the ROOT & print
 * 
 *  NOTE:
 *  -----
 *      - We will visit each Single Node 3 times in it's entire traversal
 *      - This can be illusatrated using an Euler's Diagram
 *              - Pre-Order Traversal --> Print during the 1st visit of Node
 *              - In-Order Traversal --> Print during the 2nd visit of Node
 *              - Post-Order Traversal --> Print during the last visit of Node
*/

// Node Structure of BT
class Tree {
    int data;
    Tree left;
    Tree right;

    Tree (int a) {
        data = a;
        left = right = null;
    }

    // Pre-Order Traversal 
    void printPreOrder (Tree root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    /*
     *  TC = O(N) || SC = O(h) [ where "h" is the height of the Tree ]
     *          - But in the Worst case, height of tree will be No. of Nodes = n
     *          - Hence, SC = O(N)
     *          - For a Blanced Tree --> SC = O(logN)
    */

    // iN-Order Traversal 
    void printInOrder (Tree root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    // Post-Order Traversal 
    void printPostOrder (Tree root) {
        if (root == null) {
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.data);
    }


    /*
    *  Q1: Calculate the Size of the Tree
    *       ans:
    *           - we will ask recursion to cal size of left tree 
    *           - we will ask recursion to cal size of right tree
    *           - we add left + right +1
    */
    int size (Tree root) {
        if (root == null) {
            return 0;
        }
        
        int lSize = size(root.left);
        int rSize = size(root.right);

        return lSize + rSize + 1;
    }


    /*
     *  Q2: Calculate the Height of the Tree
     *      HEIGHT --> Distance between the Root Node & the Most Deepest Node
     *             --> Longest branch of tree, starting from root node till the leaf Node
     *      ans:
    *           - we will ask recursion to cal Height of left tree 
    *           - we will ask recursion to cal Height of right tree
    *           - we find Max(left, right) + 1
    */
    int height (Tree root) {
        if (root == null) {
            // return 0;
            return -1;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }
    /*
     *  - There are some cases where our code will fail if we return 0;
     *          - for a single root node case
     *                  - left = 0 || right = 0
     *                  - return max(0, 0) + 1
     *                  - ans = 1 [ But, this is wrong]
     * 
     *  - Hence, we will return "-1" instead of "0"
     *          - Now, for a single root node case
     *                  - left = -1 || right = -1
     *                  - return max(-1, -1) + 1
     *                  - ans = 0 [ this is CORRECT ]
    */



    /*
     *  Q3: Gievn 2 BT, Return true if both are identical
     *      
     *      Steps:
     *          1. Check the Root Nodes [ r1.val == r2.val ]
     *          2. Check the LST [ r1.left must be identical to r2.left ]
     *          3. Check the RST [ r1.right must be identical to r2.right ]
    */
    boolean isIdentical (Tree r1, Tree r2) {
        // If both roots are null --> Identical
        if (r1 == null && r2 == null) {
            return true;
        }

        // if anyone of the roots are null --> Not Identical
        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.data != r2.data) {
            return false;
        }

        boolean lst = isIdentical(r1.left, r2.left);
        boolean rst = isIdentical(r1.right, r2.right);

        return lst && rst;
    }
    // same as Pre-Order Traversal ==> TC = O(N) || SC = O(N) 
}



