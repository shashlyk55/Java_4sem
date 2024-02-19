package by.slesarev.tvprogram;

import by.slesarev.guideexceptions.LogicalException;

public class News extends TVProgram implements ITVProgram {
    public News(String name, int duration) throws LogicalException {
        if(duration > 24 || duration < 1){
            throw new LogicalException("Программа не может идти дольше 24 часов и меньше 1!");
        }
        this._duration = duration;
        this._name = name;
    }
    @Override
    public String toString() {
        return "Новости " + super.toString();
    }

    @Override
    public void ShowProgram() {
        System.out.println("Время новостей " + _name);
    }
}
