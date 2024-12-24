public class INT21_LL {
    /*
     *  CLASS & OBJECT:
     *  ---------------
     *      Class --> Class is a Blueprint
     *      Object --> An Instance of the Class
     *              Student s1 = new Student();
     *          - new Student() --> This will create an Object in the memory [ for attributes ] ==> Object
     *                  - Hence, new Student() ==> Object [ of Student Class ]
     *          - Student s1 --> points s1 to the created Object ==> A variable pointing to Object
     *                  - Hence, "s1" ==> Object reference [ for Student Class type ]
     *                  - Data Type of "S1" --> Student Class type
     *      - Hence, Class is called "User Defined Data Type"
     * 
     *  NOTE:
     *  -----
     *      - Object Reference of a Class can hold "Address" of that particular Class Object
     *              - i.e., "s1" will hold the address of the Student() Object
     *      - We can Create any No. of Objects from a Sinle Class
    */


    /*
     *  STACK & HEAP:
     *  -------------
     *                  Student s1 = new Studnet();
     *      - Whenever we see a "new" keywprd.
     *      - That data will be stpred in the HEAP Memory
     *      - Hence, Objects will also be Stored in "HEAP" Memory
     *      - But Reference will be stored in the "STACK" Memory 
     *              - WKT, ref contains Address of Object
     *              - Hence, s1 = 100AD1    [ 100AD1 is Address of "Student Class Obj" ]
     *              - This "s1 = 100AD1" is stored in STACK Memory
     * 
     *                  Student s2:
     *      - Here, 1st "s2" will be Created which points to "null" [ Happens in STACK ]
     *                  s2 = s1;
     *      - Now "s2" points the same address of "Student() class Obj" [ Happens in Stack ]
     * 
     *  NOTE:
     *  -----
     *      - Hence, Multiple Object references can refer/point to same Single Object [ as shown above ]
     *                  Student s1 = new Studnet();
     *                  s1.name = "Siva";
     *                  s2.lang = "java";
     *                  Student s2 = s1;;
     *                  print(s2.lang);     // o/p = java
     * 
     *                  s2.name = "Sai";
     *                  print (s1.name);    // o/p = Sai
     *          - This happens as both Obj references [ "s1" & "s2" ] point to same Object
     *          - i.e., they both stores same Address
     * 
     *                  int x = 20;
     *      - This will create "x=20" in STACK only
     *      - cuzz, there is NO 'new' keyword
    */



    /*
     *          Student s1 = new Student();
     *          s1.name = "Sai";
     *          s1.lang = "Java";
     * 
     *          Student s2 = new Student();
     *          s2.name = "Siva";
     *          s2.lang = "Python";
     * 
     *      - Here, everytime we create an Object any class, 
     *      - we need to initialize it's properties separately
     *      - This is an Overhead task for us [ if there are 1000 Students..? ]
     *      - Hence, here comes "Constructor"
     * 
     *  CONSTRUCTOR:
     *  ------------
     *      - Constructor is used to Initialze the Attributes/Properties of a Class at the time of Obj Creation itself
     *                      Student s3 = new Student("kumar", "CPP");
     *                      Student s3 = new Student("Aman", "GO");
     *              - For these above statements to work, we need to write some code during "Class" Creation itself
     *                      Class Student {
     *                          String name;
     *                          String lang;
     *                          
     *                          // CONSTRUCTOR
     *                          Student(String a, String b) {
     *                              name = a;
     *                              lang = b;
     *                          }
     *                      }
     *      NOTE:
     *      -----
     *              - Name os "Constructor" must be same as the Name of the "CLASS"
     *              - Constructor DOESN'T have a "Return Type"
     *              - Order of the parameters must also be matched with Argument's type passed during Obj Creation
    */


    /*
     *  Q:  What happens if we creat an Object like this..?
     *                  Student s5 = new Studnet()      // Construtor is already there
    */
    public static void main(String[] args) {
        Student s1 = new Student ("Siva", 25);
        System.out.println(s1.name);

        Student s2 = new Student(null, 0);
        System.out.println(s2.age);     // o/p = 0
        System.out.println(s2.name);    // o.p = null
    }
}

class Student {
    String name;
    int age;

    Student (String a, int b) {
        name = a;
        age = b;
    }
}


/*
 *                      Student s1 = new Student();
 *              - Here, "s1" is a Variable which stores the ref/address of Student Object
 * 
 *                      Student s2;
 *              - Similarly, "s2" will be a var which can store the add of a Student Object
 *              - Currently it is Storing "null"
 * 
 *      NOTE:
 *          - <class-name> var
 *          - This "var" is a Variable of Defined Object/Class type
 *          - This "var" can store the Address/Ref of the Defined Object
*/

class Node {
    int val;
    Node next;

    Node (int a) {
        val = a;
    }
}

/*
 *  - Now, if we define an Object like
 *              Node ll1 = new Node (10);
 *              Node ll2;
 *              ll2 = ll1;
 * 
 *              ll2.next = new Node (20);  
 *      - Here, "new Node (20)" --> Creates a New Obj in Memory
 *      - "ll2.next" is of type Node Class --> It can store the Address/ref
 *      - "ll2.next" --> Stores the address/ref of the new Obj
 *  
 *              ll2 = ll2.next
 *      - Previously, ll2 stores the address of the ll1 Obj [ ll2 = ll1; ]
 *      - Now, ll2 stores the Address of new Obj [ ll2 = ll2.next ]
 * 
 *  - The catch here is 
 *          - WKT, Object's properties/Attributes will be stored in the HEAP Memory
 *                  - i.e., val & next
 *          - But we are storing the address/reference of another Object in the "next" variable
 *          - i.e., we are storing the references in the HEAP Memory itself
 * 
 *  NOTE:
 *  -----
 *      - Generally, references are stored in STACK Memory
 *      - But, we are storing the references in the HEAP Memory itself [ using the above method ]
*/


/*
 *  Q1: Create a Lined List with N nodes with data 1 to n & Return head node
 *      EX:     Node1   N2=10k  N3=20k  N4=30k   ...     Node-n = 1900k
 *              x=1     x=2     x=3     x=4             x=n
 *              10k     20k     30k     40k             2000k
 *          return node1/head 
*/

class List {
    int val;
    List next;

    List (int a) {
        val = a;
    }

    List createList (int n) {
        List head = new List (1);
        List temp = head;

        for (int i=2; i<=n; i++) {
            List node = new List(i);
            temp.next = node;
            temp = node;
        }

        // Sir's Code
        for (int i=2; i<=n; i++) {
            temp.next = new List(i);
            temp = temp.next;
        }

        return head;
    }
}



/*
 *  Q2: Given Head Node of a LL, Return size of LL
*/
class Size {
    Size next;

    // This is the ACTUAL FUNCTION
    int sizeOfLL (Size h) {
        Size temp = h;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}



/*
 *  Q3: Given a LL, Insert a New Node with data v at index p
*/
class InsertNode {
    int val;
    InsertNode next;

    InsertNode (int a) {
        val = a;
    }

    InsertNode insertNewNode (int v, int p, InsertNode head) {
        InsertNode node = new InsertNode(v);
        
        if (p == 0) {
            node.next = head;
            head = node;
            
            return head;
        }
        
        InsertNode temp = head;
        // to go till index point "p-1"
        for (int i=1; i<p; i++) {
            temp = temp.next;
        }

        // Inserting at index p
        node.next = temp.next;
        temp.next = node;

        return head;
    }
}

