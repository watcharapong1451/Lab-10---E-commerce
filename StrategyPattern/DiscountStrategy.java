package StrategyPattern;

import DataModels.Order;

public interface DiscountStrategy {
    public double applyDiscount(Order order);
}
