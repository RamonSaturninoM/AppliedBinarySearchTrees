public class BinarySearchTree {
    Node root;
    
    /**
     * All methods within this class, have the essential 
     * functionalities a tree should have, since the given
     * functions by professor were void, I created helper function
     * to allow better performance when calling certain
     * methods.
     *  
     * 
     * @author ramonsaturnino
     */
    
    public void insert(Person person){
        root = insertRecursive(root, person);
    }
    
    private Node insertRecursive(Node node, Person person) {
        if (node == null) {
            return new Node(person);
        }

        if (person.compareTo(node.person) < 0) {
            node.left = insertRecursive(node.left, person);
        } else if (person.compareTo(node.person) > 0) {
            node.right = insertRecursive(node.right, person);
        }
        return node;
    }
    
    
    
    public Person search(String name){
        return searchRecursive(root, name);
    }
    
    private Person searchRecursive(Node node, String name) {
        if (node == null) {
            return null;
        }

        int comparison = name.compareToIgnoreCase(node.person.name);
        if (comparison == 0) {
            return node.person;
        } else if (comparison < 0) {
            return searchRecursive(node.left, name);
        } else {
            return searchRecursive(node.right, name);
        }
    }
    
    
    
    public void inorderTraversal(){
        inorderRecursive(root);
    }
    
    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.println(node.person);
            inorderRecursive(node.right);
        }
    }
    
    
    
    public int countNodes(){
        return countNodesRecursive(root);
    }
    
    private int countNodesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }
    
    
    
    public int height(){
        return heightRecursive(root);
    }
    
    private int heightRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }
    
    
    
    public Person findMin(){
        if (root == null){
            return null;
        }
        return findMinRecursive(root);
    }
    
    private Person findMinRecursive(Node node) {
        if (node.left == null) {
            return node.person;
        }
        return findMinRecursive(node.left);
    }
    
    
    
    public Person findMax(){
        if (root == null){
            return null;
        }
        return findMaxRecursive(root);
    }
    
    private Person findMaxRecursive(Node node) {
        if (node.right == null) {
            return node.person;
        }
        return findMaxRecursive(node.right);
    }
}
