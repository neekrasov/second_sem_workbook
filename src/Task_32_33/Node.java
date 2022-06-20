package Task_32_33;

public class Node<T>{
    private final T value;
    public Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public T getValue(){
        return this.value;
    }
}
