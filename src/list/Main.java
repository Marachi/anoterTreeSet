package list;



import java.util.Iterator;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        MyTreeSet tree = new MyTreeSet();
        tree.add(Integer.valueOf(7));
        tree.add(Integer.valueOf(2));
        tree.add(Integer.valueOf(11));
        tree.add(Integer.valueOf(1));
        tree.add(Integer.valueOf(6));
        tree.add(Integer.valueOf(9));
        tree.add(Integer.valueOf(14));
        tree.add(Integer.valueOf(4));
        tree.add(Integer.valueOf(10));
        tree.add(Integer.valueOf(12));
        tree.add(Integer.valueOf(3));
        tree.add(Integer.valueOf(5));
        Iterator i$ = tree.iterator();

        Integer node;
        while(i$.hasNext()) {
            node = (Integer)i$.next();
            System.out.println(node);
        }

        tree.remove(Integer.valueOf(11));
        System.out.println("New");
        i$ = tree.iterator();

        while(i$.hasNext()) {
            node = (Integer)i$.next();
            System.out.println(node);
        }

        tree.remove(Integer.valueOf(12));
        i$ = tree.iterator();

        while(i$.hasNext()) {
            node = (Integer)i$.next();
            System.out.println(node);
        }

    }
}
