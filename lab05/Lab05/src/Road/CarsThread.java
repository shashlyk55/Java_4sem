package Road;

import java.util.concurrent.Semaphore;

public class CarsThread implements Runnable{
    int carsCount;
    RemontPlace remontPlace;
    Semaphore semaphore;
    String roadSide;
    public CarsThread(Semaphore sem, String side, RemontPlace remontPlace, int carsCount){
        this.semaphore = sem;
        this.roadSide = side;
        this.remontPlace = remontPlace;
        this.carsCount = carsCount;
    }
    @Override
    public void run() {
        while(true) {
            try {
                semaphore.acquire();
                System.out.println("Движение с полосы " + this.roadSide);

                for (int i = 0; i < remontPlace.bandwidth; i++) {
                    if(carsCount == 0){
                        System.out.println("На полосе " + this.roadSide + " не осталось автомобилей");
                        semaphore.release();
                        return;
                    }
                    System.out.println("Автомобиль " + carsCount + " начал движение");
                    Thread.sleep(500);
                    carsCount--;
                    System.out.println("Автомобиль " + (carsCount + 1) + " закончил движение");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            semaphore.release();
        }
    }
}
