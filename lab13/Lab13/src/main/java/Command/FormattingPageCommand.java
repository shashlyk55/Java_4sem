package Command;

import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormattingPageCommand implements Command{
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        System.out.println("formatting page");
        return new CommandResult("formatting",false);
    }
}
