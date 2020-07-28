public class LinkedListDeque<T> {

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

    public boolean isEmpty() {
            return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        IntNode temp = sentinel;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.item);
            temp = temp.next;
        }
    }

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



}
