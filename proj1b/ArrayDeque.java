public class ArrayDeque<T> implements Deque<T> {
   private T[] items;
   private int nextFirst;
   private int nextLast;
   private int size;

   public ArrayDeque() {
       items = (T[]) new Object[8];
       nextFirst = 0;
       nextLast = 1;
       size = 0;
   }

   private boolean isFull() {
      return size == items.length;
   }

   private boolean isSparse() {
      return items.length >= 16 && size < (items.length / 4);
   }

   private int plusOne(int index) {
      return (index + 1) % items.length;
   }

   private int minusOne(int index) {
      return (index - 1 + items.length) % items.length;
   }

   private void resize(int capacity) {
      T[] newDeque= (T[]) new Object[capacity];
      int oldIndex = plusOne(nextFirst);
      for (int newIndex = 0; newIndex < size; newIndex++) {
         newDeque[newIndex] = items[oldIndex];
         oldIndex = plusOne(oldIndex);
      }
      items = newDeque;
      nextFirst = capacity - 1;
      nextLast = size;
   }

   private void upSize() {
      resize(size * 2);
   }

   private void downSize() {
      resize(items.length / 2);
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public void printDeque() {
      for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
         System.out.println(items[i]);
      }
   }

   @Override
   public void addFirst(T newElemnt) {
      if (isFull()) {
         upSize();
      }
      items[nextFirst] = newElemnt;
      nextFirst = minusOne(nextFirst);
      size += 1;
   }

   @Override
   public void addLast(T newElement) {
      if (isFull()) {
         upSize();
      }
      items[nextLast] = newElement;
      nextLast = plusOne(nextLast);
      size += 1;
   }

   @Override
   public T removeFirst() {
      if (isSparse()) {
         downSize();
      }
      nextFirst = plusOne(nextFirst);
      T tobeRemove = items[nextFirst];
      items[nextFirst] = null;
      if (!isEmpty()) {
         size -= 1;
      }
      return tobeRemove;
   }

   @Override
   public T removeLast() {
      if (isSparse()) {
         downSize();
      }
      nextLast = minusOne(nextLast);
      T tobeRemove = items[nextLast];
      items[nextLast] = null;
      if (!isEmpty()) {
         size -= 1;
      }
      return tobeRemove;
   }

   @Override
   public T get(int index) {
      if (index >= size) {
         return null;
      }
      int start = plusOne(nextFirst);
      return items[(start + index) % items.length];
   }

   public ArrayDeque(ArrayDeque other) {
      items = (T[]) new Object[other.size];
      nextFirst = other.nextFirst;
      nextLast = other.nextLast;
      size = other.size;
      System.arraycopy(other.items, 0, items, 0, other.size);
   }




}