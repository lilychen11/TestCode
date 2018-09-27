package cn.lily.test;

public class Main1 {
    static class Counter {
        int i = 1; 
        boolean flag = false;  
    }

    static class Printer1 implements Runnable {
        Counter counter;

        public Printer1(Counter counter)
        {
            this.counter = counter;
        }

        public void run() {
            while (counter.i <= 100) {
                synchronized (counter) {
                    if (counter.flag) {
                        try {
                            counter.wait();  
                        } catch (Exception e) {
                        }
                    } else {
                        System.out.println("Printer1 - " + counter.i);
                        counter.i++;
                        counter.flag = true;
                        counter.notify();  
                    }
                }
            }
        }
    }

    static class Printer2 implements Runnable {
        Counter counter;

        public Printer2(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            while (counter.i <= 100) {
                synchronized (counter) {
                    if (!counter.flag) {
                        try {
                            counter.wait();
                        } catch (Exception e) {
                        }
                    } else {
                        System.out.println("Printer2 - " + counter.i);
                        counter.i++;
                        counter.flag = false;
                        counter.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Printer1 pQi = new Printer1(counter);
        Printer2 pOu = new Printer2(counter);

        Thread aThread = new Thread(pQi);
        Thread bThread = new Thread(pOu);

        aThread.start();
        bThread.start();

        aThread.join();
        bThread.join();
    }
}

