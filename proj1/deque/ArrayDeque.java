package deque;

public class ArrayDeque <T>{
    private T[] array;
    int size;
    int nextlast;
    int nextfirst;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextlast = 1;
        nextfirst = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T[] resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        nextfirst = newArray.length - 1;
        nextlast = size;
        return newArray;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            array = resize(size * 2);
        }
        array[nextfirst] = item;
        nextfirst = (nextfirst - 1 + array.length) % array.length;
        size++;
    }

    public void addLast(T item) {
        if (size == array.length) {
            array = resize(size * 2);
        }
        array[nextlast] = item;
        nextlast = (nextlast + 1) % array.length;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;
        nextfirst = (nextfirst + 1) % array.length;
        T temp = array[nextfirst];
        array[nextfirst] = null;
        return temp;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;
        nextlast = (nextlast - 1 + array.length) % array.length;
        T temp = array[nextlast];
        array[nextlast] = null;
        return temp;
    }

    public T get(int index) {
        int in = (nextfirst + 1 + index) % array.length;
        return array[in];
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
