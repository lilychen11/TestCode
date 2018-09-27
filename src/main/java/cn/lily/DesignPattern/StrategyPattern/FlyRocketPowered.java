package cn.lily.DesignPattern.StrategyPattern;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying wiht a rocket!");
    }
}
