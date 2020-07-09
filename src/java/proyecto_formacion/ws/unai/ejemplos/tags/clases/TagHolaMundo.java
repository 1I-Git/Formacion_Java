package ws.unai.ejemplos.tags.clases;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagHolaMundo extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {

		getJspContext().getOut().write("Hello Wolrd con SimpleTagSupport");
	}
}
