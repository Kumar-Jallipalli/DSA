

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
 *      - Trees is a Hiearchial DS --> Non-Linear DS
 *      - Terminology
 *              root --> Top Most Node [ Has NO Parent ]
 *              edges --> Arrow pointers
 *              Nodes --> Individual data in the tree 
 *              siblings -> Nodes which have same Parent
 *              Leaf Node -> Node which doesn't have a Child
 * 
 *      Binary Trees -> A Tree where every node contains atmax 2 child nodes
 *      
*/

/*
 *  TREE TRaversals
 *  ---------------
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
}



