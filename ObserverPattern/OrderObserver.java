package ObserverPattern;
import DataModels.*;

/**
 * Interface (Observer) สำหรับผุ้สังเกตการณ์
 */
public interface OrderObserver {
    void update (Order order);
}
