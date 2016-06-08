package list;

/**
 * Created by potaychuk on 08.06.2016.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class AnotherTreeSet<T extends Comparable> implements Iterable<T> {
    private AnotherTreeSet<T>.Node<T> root;
    private int size = 0;

    public AnotherTreeSet() {
    }

    public Iterator<T> iterator() {
        return new AnotherTreeSet.TreeIterator(this.root);
    }

    public boolean add(T value) {
        boolean isAdded = false;
        if(this.root == null) {
            this.root = new AnotherTreeSet.Node();
            this.root.value = value;
            ++this.size;
            return true;
        } else {
            AnotherTreeSet.Node node = this.root;

            while(true) {
                if(value.compareTo(node.value) > 0) {
                    if(node.right == null) {
                        node.right = new AnotherTreeSet.Node();
                        node.right.value = value;
                        node.right.parent = node;
                        isAdded = true;
                        break;
                    }

                    node = node.right;
                } else {
                    if(value.compareTo(node.value) >= 0) {
                        break;
                    }

                    if(node.left == null) {
                        node.left = new AnotherTreeSet.Node();
                        node.left.value = value;
                        node.left.parent = node;
                        isAdded = true;
                        break;
                    }

                    node = node.left;
                }
            }

            if(isAdded) {
                ++this.size;
            }

            return isAdded;
        }
    }

    public void remove(T value) throws NoSuchElementException {
        AnotherTreeSet.Node node = this.find(value);
        --this.size;
        AnotherTreeSet.Node foundNode;
        if(node.left != null) {
            foundNode = this.getRight(node.left);
            node.value = foundNode.value;
            if(foundNode.left != null) {
                foundNode.parent.right = foundNode.left;
            } else {
                foundNode.parent.right = null;
            }
        } else if(node.right != null) {
            foundNode = this.getLeft(node.right);
            node.value = foundNode.value;
            if(foundNode.right != null) {
                foundNode.parent.left = foundNode.right;
            } else {
                foundNode.parent.left = null;
            }
        } else {
            node = null;
        }

    }

    public boolean contains(T value) {
        try {
            this.find(value);
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }

    public AnotherTreeSet.Node find(T value) {
        AnotherTreeSet.Node node = this.root;
        boolean isFound = false;

        for(int i = 0; i < this.size; ++i) {
            if(value.compareTo(node.value) > 0) {
                node = node.right;
            } else if(value.compareTo(node.value) < 0) {
                node = node.left;
            } else if(value.compareTo(node.value) == 0) {
                isFound = true;
                break;
            }
        }

        if(isFound) {
            return node;
        } else {
            throw new NoSuchElementException("No such element in tree");
        }
    }

    private AnotherTreeSet.Node getRight(AnotherTreeSet.Node node) {
        while(node.right != null) {
            node = node.right;
        }

        return node;
    }

    private AnotherTreeSet.Node getLeft(AnotherTreeSet.Node node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }

    public class TreeIterator implements ListIterator {
        private AnotherTreeSet.Node next;

        public TreeIterator(AnotherTreeSet.Node root) {
            this.next = root;
            if(this.next != null) {
                while(this.next.left != null) {
                    this.next = this.next.left;
                }

            }
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public T next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                AnotherTreeSet.Node r = this.next;
                if(this.next.right != null) {
                    for(this.next = this.next.right; this.next.left != null; this.next = this.next.left) {
                        ;
                    }

                    return (T) r.value;
                } else {
                    while(this.next.parent != null) {
                        if(this.next.parent.left == this.next) {
                            this.next = this.next.parent;
                            return (T) r.value;
                        }

                        this.next = this.next.parent;
                    }

                    this.next = null;
                    return (T) r.value;
                }
            }
        }

        public boolean hasPrevious() {
            return false;
        }

        public Object previous() {
            return null;
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return 0;
        }

        public void remove() {
        }

        public void set(Object o) {
        }

        public void add(Object o) {
        }
    }

    public class Node<T extends Comparable> {
        AnotherTreeSet<T>.Node<T> left;
        AnotherTreeSet<T>.Node<T> right;
        AnotherTreeSet<T>.Node<T> parent;
        private T value;

        public Node() {
        }

        T getValue() {
            return this.value;
        }
    }
}
