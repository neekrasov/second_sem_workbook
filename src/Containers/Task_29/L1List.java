package Containers.Task_29;

public class L1List<T> {
    private final static int DEFSIZE = 16;
    private Object[] array; //Массив элементов.
    private int[] next; //Массив ссылок.
    private int size;
    private int nilList; //"Нил" списка.
    private int nilFree; //"Нил" свободного места.
    private int before; //Индекс элемента до указателя.
    private int after; //Индекс элемента после указателя.

    public L1List(int capacity) {
        array = new Object[capacity];
        next = new int[capacity + 2];

        nilList = capacity;
        nilFree = capacity + 1;

        link(nilList, nilList);
        link(nilFree, 0);
        for (int i = 0; i < capacity - 1; i++)
            link(i, i + 1);
        link(capacity - 1, nilFree);

        before = after = nilList;
    }

    public L1List() {
        this(DEFSIZE);
    }

    public int getSize() {
        return size;
    }

    //Связать два элемента, заданные индексами.
    private void link(int first, int second) {
        next[first] = second;
    }

    //Захватить место.
    private int mallocIndex() {
        int index = next[nilFree];
        link(nilFree, next[index]);

        return index;
    }

    //Освободить место.
    private void freeIndex(int index) {
        link(index, next[nilFree]);
        link(nilFree, index);
    }

    //Пуст ли список.
    public boolean isEmpty() {
        return next[nilList] == nilList;
    }

    //Сделать список пустым.
    public void clear() {
        try {
            toFront();
            while (true)
                erase();
        } catch (Exception ignored) {
            ;
        }
    }

    //Передвинуть указатель в начало списка.
    public void toFront() {
        before = nilList;
        after = next[nilList];
    }

    //Указатель в конце списка?
    public boolean isEnd() {
        return after == nilList;
    }

    //Передвинуть указатель вперед.
    public void forward() throws Exception {
        if (after == nilList)
            throw new Exception();

        before = after;
        after = next[after];
    }

    //Получить объект за указателем.
    public T after() throws Exception {
        return (T) array[after];
    }

    //Добавить объект за указателем.
    public void insert(T val) throws Exception {
        size++;

        int index = mallocIndex();

        link(before, index);
        link(index, after);
        after = index;
        array[index] = val;
    }

    //Удалить объект за указателем.
    public T erase() throws Exception {
        size--;
        T val = (T) array[after];
        int index = after;

        after = next[index];
        link(before, after);
        freeIndex(index);

        return val;
    }
}
