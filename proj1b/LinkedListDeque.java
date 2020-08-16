public class LinkedListDeque<T> implements Deque<T> {

    private IntNode sentinel;
    private int size;

    public class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;
    }

    public LinkedListDeque() {
        sentinel = new IntNode();
        sentinel.item = null;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

/** if sentinel.item == null
 *  replace null with item value
 *  otherwise add a new IntNode at front
 */

    @Override
    public void addFirst(T item) {
        if(sentinel.item == null) {
            sentinel.item = item;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        } else {
            IntNode temp = sentinel;
            sentinel = new IntNode();
            sentinel.item = item;
            sentinel.next = temp;
            sentinel.prev = temp.prev;
            temp.prev = sentinel;
            sentinel.prev.next = sentinel;
        }
        size += 1;
    }

    @Override
    public void addLast(T item)  {
        if(sentinel.item == null) {
            sentinel.item = item;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        } else {
            IntNode temp = new IntNode();
            temp.item = item;
            temp.prev = sentinel.prev;
            temp.next = sentinel;
            sentinel.prev = temp;
            temp.prev.next = temp;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
            return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        IntNode temp = sentinel;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.item);
            temp = temp.next;
        }
    }

    @Override
    public T removeFirst() {
        if(this.size == 0) {
            return null;
        } else {
            sentinel.next.prev = sentinel.prev;
            sentinel.prev.next = sentinel.next;
            T temp = sentinel.item;
            sentinel = sentinel.next;
            size -= 1;
            return temp;
        }
    }

    @Override
    public T removeLast() {
        if(this.size == 0) {
            return null;
        } else {
            T temp = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return temp;
        }
    }

    @Override
    public T get(int index) {
        if(index > size-1) {
            return null;
        } else {
            IntNode temp = sentinel;
            for(int i = 0; i < index ; i++) {
                temp = temp.next;
            }
            return temp.item;
        }
    }

    /** unit test for myself */

    public static void main(String[] args) {
        LinkedListDeque<Integer> s1= new LinkedListDeque<>();
        s1.addFirst(1);
        s1.addFirst(2);
        s1.addFirst(3);
        s1.addFirst(4);
        s1.removeFirst();
    }

}
