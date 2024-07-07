package Command;

public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
            case CORE: {
                resultCommand = new CorePageCommand();
                break;
            }
            case FUNCTIONS: {
                resultCommand = new FunctionsPageCommand();
                break;
            }
            case FORMATTING: {
                resultCommand = new FormattingPageCommand();
                break;
            }
            case SQL:{
                resultCommand = new SqlPageCommand();
                break;
            }
            case XML:{
                resultCommand = new XmlPageCommand();
                break;
            }
            default: {
                resultCommand = null;
                break;
            }
        }
        return resultCommand;
    }
}
