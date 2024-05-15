import java.util.Objects;
import java.util.Random;

public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    public static MyTestingClass generateRandom() {
        Random random = new Random();
        return new MyTestingClass(random.nextInt());
    }

    @Override
    public int hashCode() {
            int hash = 7;
            int prime = 31;
            hash = prime * hash + Objects.hashCode(id);
            return hash;
        }

    }



