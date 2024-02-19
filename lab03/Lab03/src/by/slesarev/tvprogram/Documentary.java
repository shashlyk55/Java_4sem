package by.slesarev.tvprogram;

import by.slesarev.guideexceptions.LogicalException;

public class Documentary extends TVProgram implements ITVProgram{
    public Documentary(){}
    public Documentary(String name, int duration) throws LogicalException {
        if(duration > 24 || duration < 1){
            throw new LogicalException("Программа не может идти дольше 24 часов и меньше 1!");
        }
        this._duration = duration;
        this._name = name;
    }
    @Override
    public String toString() {
        return "Документалка " + _name + " Длительность: " + _duration;
    }

    @Override
    public void ShowProgram(){
        System.out.println("Время документалки " + _name);
    }
}
