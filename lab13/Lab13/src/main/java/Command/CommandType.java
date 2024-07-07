package Command;

public enum CommandType {
    CORE("core"),
    FORMATTING("formatting"),
    FUNCTIONS("functions"),
    SQL ("sql"),
    XML("xml");


    private String command;
    private CommandType(String command) {
        this.command = command;
    }
}
