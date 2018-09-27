package cn.lily.DesignPattern.FactoryPattern;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza(String type);
}
class NYPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new NYStyleCheesePizza();
        else if (type.equals("veggie"))
            return new NYStyleCheesePizza();
        return null;
    }
}
 class ChicagoPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new ChicagoStyleCheesePizza();
        else if (type.equals("veggie"))
            return new ChicagoStyleClamPizza();
        return null;
    }
}
