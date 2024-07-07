package tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PIETable extends TagSupport {
    @Override
    public int doStartTag() {
        JspWriter jw = pageContext.getOut();
        try {
            jw.println("<table border=\"1\">" +
                    "<tr>" +
                    "<th>Name</th><th>Type</th>" +
                    "</tr>");

            ConnectorDB connectorDB = null;
            ArrayList<Game> arrayList;
            try {
                connectorDB = new ConnectorDB();
                arrayList = connectorDB.getGames();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            for (Game game : arrayList) {
                jw.print("<tr><td>" + game.name + "</td><td>" + game.type + "</td></tr>");
            }
            jw.println("</table>");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }
}
