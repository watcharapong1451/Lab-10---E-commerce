package DecoratorPattern;

import FactoryMethodPattern.*;

public abstract class ShipmentDecorator implements Shipment{
    protected Shipment wrapperShipment;

    public ShipmentDecorator(Shipment wrapperShipment){
        this.wrapperShipment = wrapperShipment;
    }
    @Override
    public String getInfo() {
        return wrapperShipment.getInfo();
    }

    @Override
    public double getCost() {
       return wrapperShipment.getCost();
    } 
}
