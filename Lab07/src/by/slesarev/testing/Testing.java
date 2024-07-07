package by.slesarev.testing;

import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.guidemanager.GuideManager;
import by.slesarev.programguide.DaysOfWeek;
import by.slesarev.tvprogram.Documentary;
import by.slesarev.tvprogram.News;
import by.slesarev.tvprogram.TVProgram;
import org.junit.*;
import org.testng.annotations.Ignore;

import java.util.ArrayList;


public class Testing {
    static GuideManager manager;
    static GuideManager.ProgramGuide guide;
    static News news;

    static {
        try {
            news = new News("BBC",12);
        } catch (LogicalException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void startTest(){
        System.out.println("Start test");
    }
    @BeforeClass
    public static void setUp() throws LogicalException {
        manager = new GuideManager();
        guide = manager.CreateProgramGuide(DaysOfWeek.FRIDAY);
        guide.setProgramList(
                new ArrayList<TVProgram>(){{
                        add(news);
                        add(new Documentary("qwerty",3));
                }}
        );
        System.out.println("Class test start");
    }
    @Test
    public void testGetDuration() throws LogicalException {
        GuideManager manager2 = new GuideManager();
        GuideManager.ProgramGuide guide2 = manager2.CreateProgramGuide(DaysOfWeek.MONDAY);
        var actual = new ArrayList<TVProgram>();
        actual.add(new News("A",2));
        actual.add(new News("B",9));
        actual.add(new News("C",5));
        guide2.setProgramList(actual);

        GuideManager manager1 = new GuideManager();
        GuideManager.ProgramGuide guide1 = manager1.CreateProgramGuide(DaysOfWeek.FRIDAY);
        var expected = new ArrayList<TVProgram>(){{
            add(new News("A",2));
            add(new News("B",9));
            add(new News("C",5));
        }};

        Assert.assertEquals(guide1.getBusyDuration(), guide2.getBusyDuration());
    }
    @Test
    public void testGetBusyDuration() throws LogicalException {
        Assert.assertEquals((new Documentary("A",15).get_duration()),15);
    }
    @Test(timeout = 3000)
    public void testSearchingLongestProgram() throws LogicalException {
        Assert.assertEquals(manager.SearchLongestProgram(guide),news);
    }
    @Ignore
    @Test
    public void testProgramDuration(){
        Assert.assertEquals(manager.ProgramDuration(guide.getProgramList()),15);
    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("Class test ending");
    }
    @After
    public void endTest(){
        System.out.println("Test successfully");
    }



}
