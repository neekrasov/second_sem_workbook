package Task_32_33;

public class L1List<T> {
    private Node<T> first, last; //Ссылки на первый и последний узлы.
    private int size;

    public L1List() {
        first = last = null;
        size = 0;
    }

    public void append(Node<T> node) {
        node.next = null;

        if (first == null) //Первый элемент.
            first = node;

        if (last != null)
            last.next = node;

        last = node;
        size++;
    }

    // Получить номер элемента
    public int search(Node<T> node) {
        int index = 0;
        try {
            if (!node.equals(first)) {
                Node<T> object = first.next;
                while (true) {
                    index++;
                    if (!object.equals(node)) {
                        object = object.next;
                    } else if (object.equals(node)) return index;
                    else return -1;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    // Получить номер элемента
    public int find(Node<T> node) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.equals(node)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // Вставка элемента
    public void insert(Node<T> node, int location) throws Exception {
        Node<T> current = first;
        for (int i = 0; i < location; i++) {
            if (current.next == null) {
                throw new Exception();
            }
            current = current.next;
        }
        Node<T> oldNext = current.next;
        if (oldNext == null) last = node;
        current.next = node;
        node.next = oldNext;
        size++;
    }

    // Удаление элемента
    public void remove(int location) throws Exception {
        Node<T> current = first;
        Node<T> before = null;
        for (int i = 0; i < location; i++) {
            if (current.next == null) {
                throw new Exception();
            }
            before = current;
            current = current.next;
        }
        before.next = current.next;
        if (location == size-1){
            before.next = null;
            last = before;
        }

        size--;
    }

    // Получить последний элемент
    public Node<T> getLast() throws Exception {
        return last;
    }
    // Получить последний элемент
    public Node<T> getFirst() throws Exception {
        return first;
    }
    // Получить элемент по индексу
    public Node<T> get(int location) throws Exception {
        Node<T> object = first;
        for (int i = 0; i < location; i++) {
            if (object.next == null) {
                throw new Exception();
            }
            object = object.next;
        }
        return object;
    }

    public void print() throws Exception {
        Node<T> current = first;

        if (current == null) {
            System.out.println("Список пуст");
        } else {
            System.out.print("[ ");
            for (int i = 0; i < size - 1; i++) {

                System.out.print(current.getValue() + ", ");

                current = current.next;
            }
            System.out.print(getLast().getValue());
            System.out.println(" ]");
        }
    }


}
