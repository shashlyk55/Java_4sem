package by.slesarev.guidemanager;

import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.main.Main;
import by.slesarev.programguide.DaysOfWeek;
import by.slesarev.tvprogram.TVProgram;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GuideManager {
    public GuideManager(){}

    public ProgramGuide CreateProgramGuide(DaysOfWeek day){
        return new ProgramGuide(day);
    }

    // Поиск самой длинной передачи
    public TVProgram SearchLongestProgram(ProgramGuide guide) throws LogicalException{
        if(guide.programList == null || guide.programList.isEmpty()){
            throw new LogicalException("Список пуст!");
        }

        return guide.programList.stream().max((i1,i2)->Integer.compare(i1.get_duration(),i2.get_duration())).get();
    }

    // Поиск передачи заданного типа
    public <T> ArrayList<TVProgram> SearchProgramType(ArrayList<TVProgram> list, Class<T> typeName) throws LogicalException{
        return (ArrayList<TVProgram>) list.stream().filter(x->typeName.isInstance(x)).collect(Collectors.toList());
    }

    // Подсчет длительности всей программы передач
    public int ProgramDuration(ArrayList<TVProgram> list){
        return list.stream().mapToInt(TVProgram::get_duration).sum();
    }
    @FunctionalInterface
    interface IntFieldExtractor<T> {
        int extract(T object);
    }

    public class ProgramGuide {
        private ArrayList<TVProgram> programList;
        public ArrayList<TVProgram> getProgramList() {
            return programList;
        }
        public void setProgramList(ArrayList<TVProgram> programList) {
            this.programList = programList;
        }
        public boolean Add(TVProgram item) throws LogicalException {
            if(!programList.add(item)){
                throw new LogicalException("Элемент не был добавлен!");
            }
            this._busyDuration += item.get_duration();
            if(this._busyDuration > maxProgramDuration){
                this._busyDuration -= item.get_duration();
                throw new LogicalException(("Не достаточно свободного времени в программе передач на этот день!"));
            }
            return true;
        }
        public boolean Remove(TVProgram item) throws LogicalException{
            if(!programList.remove(item)){
                throw new LogicalException("Элемент не был удален!");
            }
            this._busyDuration -= item.get_duration();
            return true;
        }
        protected DaysOfWeek day;
        public final int maxProgramDuration = 24;
        private int _busyDuration;
        public int getBusyDuration(){
            return _busyDuration;
        }
        public ProgramGuide(){}
        private ProgramGuide(DaysOfWeek day){
            this.programList = new ArrayList<>();
            this.day = day;
            this._busyDuration = 0;
        }
    }
}
