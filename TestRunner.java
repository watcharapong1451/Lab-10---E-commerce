import java.util.*;
import DataModels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("--- E-commerce System Simulation ---");

        // --- 1. Setup
        Product Smartphone = new Product("P001", "Smartphone",2000);
        Product Ipad = new Product("P002", "Ipad", 3000);
        Product Pencill = new Product("P003", "Pencill", 1500);
        Order MyOrder = new Order("OD_001", List.of(Smartphone, Ipad, Pencill), "watcharapong.poth@ku.th");
        
        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();
        OrderProcessor orderProcessor = new OrderProcessor();

        InventoryService inventory = new InventoryService();
        EmailService emailer = new EmailService();
        orderProcessor.register(inventory);
        orderProcessor.register(emailer);

        System.out.println("\n--- 2. Testing Strategy Pattern (Discount) ---");
        double originalPrice = MyOrder.getTotalPrice();
        System.out.println("Orginal Price : "+ originalPrice);

        DiscountStrategy TenPercent = new PercentageDiscount(10);
        double priceAfterpercentage = calculator.calculateFinalPrice(MyOrder, TenPercent);
        System.out.println("Price with 10% discount" + priceAfterpercentage);

        DiscountStrategy FivehundredPercent = new FixedDiscount(500);
        double priceafterFixed = calculator.calculateFinalPrice(MyOrder, FivehundredPercent);
        System.out.println("Price with 500 bath discount" + priceafterFixed);

        System.out.println("\n--- 3. Testing Factory and Decorator Pattern (Shipment) ---");
        //สร้างการจัดการแบบมาตรฐาน
        Shipment StandardShipment = shipmentFactory.createShipment("STANDARD");
        System.out.println("Base Shipment : " + StandardShipment.getInfo() + ", Cost : " + StandardShipment.getCost());

        //ห่อด้วยบริการห่อของขวัญ
        Shipment giftWrapped = new GiftWrapDecorator(StandardShipment);
        System.out.println("Decorted : " + giftWrapped.getInfo() + ", Cost : " + giftWrapped.getCost());

        //ห่อทับด้วยบริการประกันสินค้า
        Shipment fullyLoaded = new InsuranceDecorator(giftWrapped, MyOrder);
        System.out.println("Fully Decorated : " + fullyLoaded.getInfo() + ", Cost" + fullyLoaded.getCost());

        System.out.println("\n--- 4. Printing Final Summary ---");
        double finalPrice = priceAfterpercentage;
        double totalCost = finalPrice + fullyLoaded.getCost();
        System.out.println("Final price after discount : " + finalPrice);
        System.out.println("Fianl shipment cost : " + fullyLoaded.getCost());
        System.out.println("TOTAL TO PAY : " + totalCost);
        

        // --- 5. Testing Observer Pattern (Processing Order) ---
        orderProcessor.processOrder(MyOrder);
    }
    }

