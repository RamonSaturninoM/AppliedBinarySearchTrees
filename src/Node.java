public class Node {
    Person person;
    Node left;
    Node right;
    
    public Node(Person person){
        this.person = person;
        left = null;
        right = null;
    }
}
