package Thread.生产者消费者;

public class WaitSignalTest {
    private static int count = 0;
    private static final int buffCount = 10;
    private static final String lock = "lock";

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == buffCount) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，数量为：" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，数量为：" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitSignalTest waitSignalTest = new WaitSignalTest();
        new Thread(waitSignalTest.new Producer()).start();
        new Thread(waitSignalTest.new Producer()).start();
        new Thread(waitSignalTest.new Producer()).start();
        new Thread(waitSignalTest.new Consumer()).start();
    }
}
