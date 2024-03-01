package callCenter;

import java.util.*;

public class CallCenter {
    private Queue<Client> waitingQueue;
    private Operator[] operators;

    public CallCenter(int operatorsCount) {
        this.waitingQueue = new LinkedList<>();
        this.operators = new Operator[operatorsCount];

        for (int i = 0; i < operators.length; i++) {
            (operators[i] = new Operator("Operator " + (i + 1))).start();
        }
    }

    public synchronized void enqueue(Client client) {
        waitingQueue.offer(client);
        notifyAll();  // Уведомляем все потоки, что появился новый клиент
    }

    public synchronized Client dequeue() throws InterruptedException {
        while (waitingQueue.isEmpty()) {
            wait();  // Ожидаем, если очередь пуста
        }
        return waitingQueue.poll();
    }

    private class Operator extends Thread {
        public Operator(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Client client = dequeue();  // Получаем клиента из очереди
                    System.out.println(getName() + " starts servicing " + client.getName());
                    // Логика обслуживания клиента

                    // Можно добавить случайную задержку, чтобы симулировать обслуживание клиента
                    Thread.sleep((long) (Math.random() * 2000));

                    System.out.println(getName() + " finished servicing " + client.getName());
                    client.notifyServiced();  // Уведомляем клиента, что он обслужен
                } catch (InterruptedException e) {}
            }
        }
    }
}

