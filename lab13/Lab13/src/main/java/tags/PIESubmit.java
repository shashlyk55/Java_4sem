package tags;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class PIESubmit extends TagSupport {
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int doStartTag() {
        String output = String.format("<input type=\"submit\" value=\"%s\">", label);
        JspWriter jw = pageContext.getOut();

        try {
            jw.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }
}
