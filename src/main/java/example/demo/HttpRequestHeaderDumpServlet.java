package example.demo;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.http.*;

public class  HttpRequestHeaderDumpServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=Shift_JIS");
        PrintWriter out = response.getWriter();

        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Hello, World!!</title>");
        sb.append("</head>");
        sb.append("<body>");

        sb.append("<p>");

        Enumeration<String> headernames = request.getHeaderNames();
        while (headernames.hasMoreElements()){
            final String name = (String) headernames.nextElement();
            final Enumeration<String> headervals = request.getHeaders(name);
            while (headervals.hasMoreElements()) {
                final String val = (String) headervals.nextElement();
            sb.append(name);
            sb.append(":");
            sb.append(val);
            sb.append("<br>");
        }
        }

        sb.append("</p>");

        sb.append("</body>");
        sb.append("</html>");

        out.println(new String(sb));

        out.close();
    }
}