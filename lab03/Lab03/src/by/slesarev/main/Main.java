package by.slesarev.main;

import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.guidemanager.GuideManager;
import by.slesarev.programguide.DaysOfWeek;
import by.slesarev.tvprogram.Documentary;
import by.slesarev.tvprogram.Entertainment;
import by.slesarev.tvprogram.News;
import by.slesarev.tvprogram.TVProgram;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;


/*
Создать консольное приложение, удовлетворяющее следующим требованиям:
1) Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
2) Каждый класс должен иметь поля, set-ы, get-ы, конструкторы, при
необходимости корректное переопределение методов Object. Должен
быть минимум один интерфейс, абстрактный класс и один внутренний
класс, а также перечисление. Распределите классы по пакетам.
3) Используйте соглашения Java Code Convention.
4) Добавить обработку исключений и логгирование.
5) Откомпилируйте и выполните проект в среде IntellijIdea и в командной
строке.

Программа передач. Определить иерархию телевизионных передач (новости,
фильмы, мультики, реклама и т.п.). Сформировать программу на день.
Создать программного директора. В его функции входит поиск самой длинной
передачи, передачи, относящейся к определенному типу, подсчет
длительности всей программы, сортировка передач (критерий определите
сами).
 */
public class Main {

    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args){

        LOG.info("Starting program_____________________________");

        GuideManager manager = new GuideManager();

        try{

            var razv1 = new Entertainment("ComedyClub", 9);
            var fridayProgram = manager.CreateProgramGuide(DaysOfWeek.FRIDAY);
            fridayProgram.Add(razv1);
            fridayProgram.Add(new Documentary("Docs1", 2));
            fridayProgram.Add(new Documentary("Docs2", 6));
            fridayProgram.Add(new News("Novosti", 3));
            fridayProgram.Add(new Documentary("doc3", 2));

            System.out.println("До сортировки:");
            for (var item : fridayProgram.getProgramList()) {
                System.out.println(item);
            }
            // Сортировка по длительности
            manager.SortDuration(fridayProgram.getProgramList());

            System.out.println("После сортировки: ");
            for (var item : fridayProgram.getProgramList()) {
                System.out.println(item);
            }
            // Поиск передач определенного типа
            System.out.println("\nПоиск передач определенного типа:");
            var currentPrograms = manager.SearchProgramType(fridayProgram.getProgramList(), Documentary.class);
            for (var item : currentPrograms) {
                System.out.println(item);
            }

            System.out.println("\nДлительность всей программы: " + manager.ProgramDuration(fridayProgram.getProgramList()));
            System.out.println("\nСамая длинная передача в списке: " + manager.SearchLongestProgram(fridayProgram));

        }
        catch(LogicalException e){
            System.out.println(e.getMessage());
        }

    }
}
