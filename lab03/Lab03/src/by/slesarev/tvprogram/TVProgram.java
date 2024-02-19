package by.slesarev.tvprogram;

import by.slesarev.guideexceptions.LogicalException;

public  abstract class TVProgram {
    protected String _name;
    protected int _duration;
    public int get_duration() {
        return _duration;
    }
    public String get_name(){
        return _name;
    }

    @Override
    public String toString() {
        return _name + " Длительность: " + _duration;
    }
}
