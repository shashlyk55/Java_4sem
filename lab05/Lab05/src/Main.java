import Road.CarsThread;
import Road.RemontPlace;
import callCenter.Client;
import callCenter.CallCenter;

import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // task 1
        /*final int OPERATORS_COUNTY = 3;
        final int CLIENTS_COUNTY = 7;

        CallCenter callCenter = new CallCenter(OPERATORS_COUNTY);

        for (int i = 0; i < CLIENTS_COUNTY; i++) {
            new Client("callCenter.Client " + (i + 1), callCenter).start();
        }*/



        // task 02
        final int MOVING_CARS = 3;
        final int LEFT_CARS = 10;
        final int RIGHT_CARS = 12;

        Semaphore sem = new Semaphore(1, true);
        RemontPlace remontPlace = new RemontPlace(3);
        new Thread(new CarsThread(sem,"left",remontPlace,8)).start();
        new Thread( new CarsThread(sem,"right",remontPlace,15)).start();


    }
}

