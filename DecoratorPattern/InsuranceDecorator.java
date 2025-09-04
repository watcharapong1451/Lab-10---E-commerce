package DecoratorPattern;

import DataModels.*;
import FactoryMethodPattern.Shipment;

public class InsuranceDecorator extends ShipmentDecorator {
    private final Order order;

    public InsuranceDecorator(Shipment wrapperShipment,Order p) {
        super(wrapperShipment);
        order = p;
    }
    @Override
    public String getInfo() {
        return super.getInfo()+"+ Insurance";
    }

    @Override
    public double getCost() {
       return super.getCost()+(order.getTotalPrice() * 0.10);
    } 
}
