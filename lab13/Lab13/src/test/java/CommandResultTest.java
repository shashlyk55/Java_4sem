import Command.CommandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandResultTest {
    @org.junit.Test
    public void TestResultGet(){
        CommandResult commandResult = new CommandResult("core");
        assertEquals(commandResult.getPage(),"core");
    }
    @Test
    public void TestResultSet(){
        CommandResult commandResult = new CommandResult("core");
        commandResult.setPage("xml");
        assertEquals(commandResult.getPage(),"xml");
    }
}
