public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {this(CAPACITY);}

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {return sz;}

   
    public boolean isEmpty() {return (sz == 0);}

    //Creates an element at the back of the queue
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    //Returns first element of the queue
    public E first() {
        if (isEmpty()) return null;
        return data[f];
     }

    //Removes an element from the front of the queue
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
    
}
