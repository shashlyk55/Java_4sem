package by.slesarev.tvprogram;

import by.slesarev.guideexceptions.LogicalException;
import org.junit.Test;

public class Entertainment extends TVProgram implements ITVProgram{
    public Entertainment(String name, int duration) throws LogicalException{
        if(duration > 24 || duration < 1){
            throw new LogicalException("Программа не может идти дольше 24 часов и меньше 1!");
        }
        this._name = name;
        this._duration = duration;
    }
    @Override
    public String toString() {
        return "Развлекательная передача " + _name + " Длительность: " + _duration;
    }

    @Test
    @Override
    public void ShowProgram() {
        System.out.println("Время развлекательной передачи " + _name);
    }
}
