package DecoratorPattern;

 import FactoryMethodPattern.*;

public class GiftWrapDecorator extends ShipmentDecorator{

    public GiftWrapDecorator(Shipment wrapperShipment) {
        super(wrapperShipment);
    }
    @Override
    public String getInfo() {
        return super.getInfo() +"+ Gift Wrapped" ;
    }

    @Override
    public double getCost() {
       return super.getCost()+50.0;
}
}
