package by.slesarev.main;

import by.slesarev.ProgramGuideHandler;
import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.guidemanager.GuideManager;
import by.slesarev.programguide.DaysOfWeek;
import by.slesarev.serializer.ValidatorSAX;
import by.slesarev.tvprogram.Documentary;
import by.slesarev.tvprogram.Entertainment;
import by.slesarev.tvprogram.News;
import by.slesarev.tvprogram.TVProgram;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;

import com.google.gson.Gson;

public class Main {

    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args){

        LOG.info("Starting program_____________________________");

        GuideManager manager = new GuideManager();

        try {

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
           var sortedList =  manager.SortDuration(fridayProgram.getProgramList());

            System.out.println("После сортировки: ");
            for (var item : sortedList) {
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

            ValidatorSAX validatorSAX = new ValidatorSAX();
            validatorSAX.valid();

            try {
                XMLReader reader = XMLReaderFactory.createXMLReader();
                ProgramGuideHandler handler = new ProgramGuideHandler();
                reader.setContentHandler(handler);
                reader.parse("Lab03/files/info.xml");
            } catch (SAXException e) {
                System.out.println("Ошибка SAX парсера " + e);
            } catch (IOException e) {
                System.out.println("Ошибка I/O потока " + e);
            }

            TVProgram tvProgSerialize = new News("novosti", 11);

            Gson gson = new Gson();
            String jsonStr = gson.toJson(tvProgSerialize);

            System.out.println(jsonStr);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("Lab03/files/info.json"));
            fileOutputStream.write(jsonStr.getBytes());
            fileOutputStream.close();

            String deser= "";
            FileInputStream fileInputStream = new FileInputStream(new File("Lab03/files/info.json"));
            int i;
            while((i=fileInputStream.read())!= -1){
                deser += (char)i;
            }
            fileInputStream.close();
            TVProgram tvProgDeserialize = gson.fromJson(deser, News.class);
            System.out.println(tvProgDeserialize.toString());


        }
        catch(LogicalException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
