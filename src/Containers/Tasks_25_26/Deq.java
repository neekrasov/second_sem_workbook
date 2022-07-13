package Containers.Tasks_25_26;

public class Deq extends Queue {
    public Deq(int degree) {
        super(degree);
    }

    public Deq() {
        super();
    }

    //Вернуть индекс предыдущего за данным элемента.
    private int backward(int index) {
        return --index < 0 ? this.array.length - 1 : index;
    }

    //Добавить символ в очередь (в начало).
    public void pushBack(char val) throws Exception {
        if (++size > array.length)
            throw new Exception();

        array[head = backward(head)] = val;
    }

    public void pushFront(char val) throws Exception {
        super.push(val);
    }

    //Удалить число из конца очереди.
    public int popBack() throws Exception {
        int val = back();
        tail = backward(tail);
        size -= 1;
        return val;
    }

    public int popFront() throws Exception {
        return super.pop();
    }

    //Получить конец очереди (не удаляя его).
    public int back() throws Exception {
        if (super.empty())
            throw new Exception();
        return array[tail];
    }

}
