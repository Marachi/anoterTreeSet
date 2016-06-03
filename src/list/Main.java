package list;

public class Main {

    public static void main(String[] args) {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        for (String s : list){
            System.out.println(s);
        }




    }
}
