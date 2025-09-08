import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Container<T> {
    private T value;

    public void set(T value){
        this.value = value;
    }

    public T get(){
        return value;
    }
}

public class DemoGenerics {

    public static void main(String[] args) {
        Container<Integer> wholeNumberContainer = new Container<>();
        wholeNumberContainer.set(42);
        System.out.println("Number stored in Container: " + wholeNumberContainer.get());

        ArrayList<String> orders = new ArrayList<>();
        orders.add("Order # 1001");
        orders.add("Order # 1002");
        orders.add("Order # 1003");
        for(String order : orders){
            System.out.println(order);
        }

        Queue<String> orderQueue = new LinkedList<>();
        orderQueue.add("Customer 1 - Velvet Elvis Painting");
        orderQueue.add("Customer 2 - Iggy Pop Poster");
        orderQueue.add("Customer 3 - Metallica Poster");
        System.out.println("\nProcessing Orders: ");
        while(!orderQueue.isEmpty()){
            System.out.println("Processing " + orderQueue.poll());
        }
    }

}
