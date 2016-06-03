package list;

import java.util.*;

/**
 * Created by pihariev on 02.06.2016.
 */
public class SimpleArrayList<T> implements List<T> {


    private static final int DEFAULT_CAPACITY = 10;
    private Object[] simpleArrayList;
    private int size;
    private int modCount = 0;

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity >= DEFAULT_CAPACITY) {
            this.simpleArrayList = new Object[initialCapacity];
        } else if (initialCapacity > 0) {
            this.simpleArrayList = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
    }

    public SimpleArrayList() {
        this.simpleArrayList = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - simpleArrayList.length > 0) {
            growAwesomeList(minCapacity);
        }
    }

    private void growAwesomeList(int minCapacity) {
        int oldCapacity = simpleArrayList.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        simpleArrayList = Arrays.copyOf(simpleArrayList, newCapacity);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        ensureCapacity(size + 1);
        simpleArrayList[size++] = o;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (simpleArrayList[i].equals(o)) {
                System.arraycopy(simpleArrayList, i + 1, simpleArrayList, i, size - i - 1);
                simpleArrayList[--size] = null;
                modCount++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("No such index in this list. Size: " + size + ".");
        }
        return (T) simpleArrayList[index];
    }

    @Override
    public T set(int index, T o) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("No such index in this list. Size: " + size + ".");
        }
        simpleArrayList[index] = o;
        modCount++;
        return (T) simpleArrayList[index];
    }

    @Override
    public void add(int index, T o) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("No such index in this list. Size: " + size + ".");
        }
        ensureCapacity(size + 1);
        int toAdd = size - index;
        System.arraycopy(simpleArrayList, index, simpleArrayList, index + 1, toAdd);
        simpleArrayList[index] = o;
        size++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("No such index in this list. Size: " + size + ".");
        }
        int toRemove = size - index - 1;
        T t = (T) simpleArrayList[index];
        if (toRemove > 0) {
            System.arraycopy(simpleArrayList, index + 1, simpleArrayList, index, toRemove);
        }
        simpleArrayList[--size] = null;
        modCount++;
        return t;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator<T>(){
            int index = 0;
            int modCount = SimpleArrayList.this.modCount;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) simpleArrayList[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public T previous() {
                return (T) simpleArrayList[--index];
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                SimpleArrayList.this.remove(index--);
                modCount++;
            }

            @Override
            public void set(T t) {
                SimpleArrayList.this.set(index, t);
                modCount++;
            }

            @Override
            public void add(T t) {
                SimpleArrayList.this.add(index, t);
                modCount++;
            }

            private void checkMods() {
                if (modCount != SimpleArrayList.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
