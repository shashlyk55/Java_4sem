package by.slesarev.guidemanager;

import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.main.Main;
import by.slesarev.programguide.DaysOfWeek;
import by.slesarev.tvprogram.TVProgram;
import org.apache.log4j.Logger;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GuideManager {
    private static final Logger LOG = Logger.getLogger(Main.class);
    public GuideManager(){}

    public ProgramGuide CreateProgramGuide(DaysOfWeek day){
        return new ProgramGuide(day);
    }

    // Поиск самой длинной передачи
    public TVProgram SearchLongestProgram(ProgramGuide guide) throws LogicalException{
        if(guide.programList == null || guide.programList.isEmpty())
            throw new LogicalException("Список пуст!");

        int maxi = 0;
        for (int i = 0; i < guide.programList.size(); i++) {
            if(guide.programList.get(maxi).get_duration() < guide.programList.get(i).get_duration()){
                maxi = i;
            }
        }
        LOG.info("Поиск самой длинной передачи...");
        return guide.programList.get(maxi);
    }

    // Поиск передачи заданного типа
    public <T> ArrayList<TVProgram> SearchProgramType(ArrayList<TVProgram> list, Class<T> typeName) throws LogicalException{
        var programs = new ArrayList<TVProgram>();

        for(var item : list){
            if(typeName.isInstance(item)){
                programs.add(item);
            }
        }
        if(programs.isEmpty()){
            throw new LogicalException("Передачи такого типа отсутсвуют!");
        }
        LOG.info("Поиск передачи заданного типа...");
        return programs;
    }

    // Подсчет длительности все программы передач
    public int ProgramDuration(ArrayList<TVProgram> list){
        int duration = 0;
        for(var item : list){
            duration += item.get_duration();
        }
        return duration;
    }

    // Сортировка передач по длительности
    public void SortDuration(ArrayList<TVProgram> list){

        list.sort(Comparator.comparing(TVProgram::get_duration));
        LOG.info("Сортировка передач по длительности...");
    }
    //Сортировка передач по алфавиту
    public void SortName(ArrayList<TVProgram> list){

        list.sort(Comparator.comparing(TVProgram::get_name));
        LOG.info("Сортировка передач по алфавиту...");
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
            LOG.info("Элемент добавлен в список передач");
            return true;
        }
        public boolean Remove(TVProgram item) throws LogicalException{
            if(!programList.remove(item)){
                throw new LogicalException("Элемент не был удален!");
            }
            this._busyDuration -= item.get_duration();
            LOG.info("Удален элемент из списка передач");
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
            LOG.info("Создана программа передач");
        }
    }
}
