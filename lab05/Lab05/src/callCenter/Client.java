package callCenter;

import callCenter.CallCenter;

public class Client extends Thread{
    private final String name;
    private boolean serviced = false;
    private CallCenter callCenter;

    public Client(String name, CallCenter callCenter) {
        super(name);
        this.name = name;
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        try {
            callCenter.enqueue(this);  // Добавляем клиента в очередь

            synchronized (this) {
                while (!serviced) {
                    wait();  // Ожидаем, пока клиент не будет обслужен
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyServiced() {
        serviced = true;
        notify();  // Уведомляем клиента, что он обслужен
    }
}
