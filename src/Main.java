import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyBST<Integer, String> mybst = new MyBST<>();
        mybst.insert(1,"Aizada");
        mybst.insert(2,"Tom");
        mybst.insert(3,"Lalal");
        mybst.insert(4,"Pipipi");
        mybst.insert(5,"QQQQ");

        System.out.println("Value with key 3: " + mybst.getVal(3));
        mybst.remove(3);
        System.out.println("Value after deletion: " + mybst.getVal(3));
        System.out.println("keys in order ");
        for (Integer key : ((MyBST<Integer, String>) mybst).iterator()) {
            System.out.println(key);
        }

        MyHashTable<MyTestingClass, String> hashtable = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(1000);
            MyTestingClass object = new MyTestingClass(id);
            hashtable.put(object, "value is:" + i);
        }
        hashtable.printBucketSize();
    }
}
