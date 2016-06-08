package list;



import java.util.Iterator;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        AnotherTreeSet anotherTreeSet = new AnotherTreeSet();
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);
        anotherTreeSet.add(Math.random()*100);

        Iterator iterator = anotherTreeSet.iterator();

        Integer i;
        while(iterator.hasNext()) {
            i = (Integer) iterator.next();
            System.out.println(i);
        }

        anotherTreeSet.remove(1);
        System.out.println("New");
        iterator = anotherTreeSet.iterator();

        while(iterator.hasNext()) {
            i = (Integer)iterator.next();
            System.out.println(i);
        }

        anotherTreeSet.remove(Integer.valueOf(12));
        iterator = anotherTreeSet.iterator();

        while(iterator.hasNext()) {
            i = (Integer)iterator.next();
            System.out.println(i);
        }

    }
}
