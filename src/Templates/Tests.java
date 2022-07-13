package Templates;

public class Tests {
    public static void main(String[] args) throws Exception {
        L1List<String> linklist = new L1List<>();
        Node<String> blue = new Node<>("Blue");
        Node<String> red = new Node<>("Red");
        Node<String> pink = new Node<>("Pink");
        Node<String> orange = new Node<>("Orange");
        Node<String> green = new Node<>("Green");
        Node<String> test = new Node<>("test");
        linklist.append(blue);
        linklist.append(red);
        linklist.append(pink);
        linklist.append(orange);
        linklist.append(green);
        System.out.println("find 'blue' -> index = " + linklist.find(blue));
        System.out.println("find 'orange' -> index = " + linklist.find(orange));
        System.out.println("find 'test' -> index = " + linklist.find(test));

        System.out.print("print after -> ");
        linklist.print();

        linklist.insert(test,4);
        System.out.println("insert 'test'-> index = " + linklist.find(test));

        linklist.remove(5);
        System.out.println("remove 'test' -> index = " + linklist.find(test));

        System.out.print("print before ->  ");
        linklist.print();

        System.out.println("get last element -> " + linklist.getLast().getValue());
        System.out.println("get first element -> " + linklist.getFirst().getValue());

        System.out.println("get element by index 0 -> " + linklist.get(0).getValue());
    }

}
