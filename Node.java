//Renzo Tejada


public class Node {
    
    public Value value;
    public Node right;
    public Node down;
    
    public Node(){                 //default ctr
        Value value=new Value();
        this.value=value;
        right=null;
        down  =null;
    }
    
    public String toString() {
        return value.toString();
    }
    
    
    public Value getThevalue() {
        return value;
    }
    public void setThevalue(String x){
        this.value.input(x);
    }
    
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getDown() {
        return down;
    }
    public void setDown(Node down) {
        this.down = down;
    }
    
    public static void main(String[] args) {
        Node n=new Node();
        System.out.println("puta que"+ n.toString());
      

    }
    
    
}

