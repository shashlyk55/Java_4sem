package by.slesarev.testing;

import by.slesarev.guideexceptions.LogicalException;
import by.slesarev.guidemanager.GuideManager;
import by.slesarev.tvprogram.News;
import by.slesarev.tvprogram.TVProgram;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({Testing.class})
public class Testing2 {
    @Test
    public void testInteraction() throws LogicalException {
        GuideManager testManager = new GuideManager();
        TVProgram testProgram = new News("ASD",1);
        assertEquals(1,testProgram.get_duration());
    }
}
