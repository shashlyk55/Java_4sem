package org.example.lab10.userTags;

import org.example.lab10.DataBase.DataBaseConnector;
import org.example.lab10.University;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SIVTable extends SimpleTagSupport {
    private String nameTable;
    public void setNameTable(String nameTable)
    {
        this.nameTable = nameTable;
    }
    @Override
    public void doTag() throws JspException
    {

        JspWriter out = this.getJspContext().getOut();

        if(nameTable == null || nameTable.isEmpty()) {
            try {
                out.println("Значение атрибута для тега = NULL/EMPTY");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                DataBaseConnector dbConnection = new DataBaseConnector("jdbc:mysql://localhost/users_db?useSSL=false","root","123qweasdzxc");
                dbConnection.OpenConnection();

                var univers = dbConnection.getAllUnivers();

                String table = "<table>\n<tr>\n<th>Name</th>\n<th>City</th>\n</tr>\n";
                for(var univer : univers){
                    table += "<tr><th>" + univer.getName() + "</th><th>" + univer.getCity() + "</th></tr>";
                }
                table+="</table>\n";
            }
            catch (Exception e) {
                try {
                    out.println("Failed to connect to database");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        //return SKIP_BODY;
    }
}
