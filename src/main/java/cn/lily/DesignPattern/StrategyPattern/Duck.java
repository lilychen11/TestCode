package cn.lily.DesignPattern.StrategyPattern;

interface FlyBehavior{
    void fly();
};
interface QuackBehavior{
    void quack();
};

 class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
class MuteQuack implements  QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

public abstract class Duck {
    FlyBehavior flyBehavior; //组合了两个行为接口变量
    QuackBehavior quackBehavior;
    public Duck(){

    }
    public abstract void display();
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim() {
        System.out.println("All ducks flate, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
