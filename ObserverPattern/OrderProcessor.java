package ObserverPattern;
import java.util.*;
import DataModels.Order;

public class OrderProcessor {
    private final List<OrderObserver> Observers = new ArrayList<>();

    public void register(OrderObserver observer) {
        Observers.add(observer);
    }
    public void unregister(OrderObserver observer) {
        Observers.remove(observer);
    }
    private void notifyObservers(Order order) {
        for(OrderObserver observer : Observers){
            observer.update(order);
        }
    }
    public void processOrder(Order order) {
        System.out.println("\nProcessing order " + order.orderId()+"...");
        System.out.println("Order processsed successful");
        //แจ้งเตือนผู้ติดตามทั้งหมด
        notifyObservers(order);
    }
}
