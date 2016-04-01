package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zst on 2016/3/28 0028.
 * act
 */
public class Action extends ActionSupport {
    String result;
    final String token = "sils135sd84vs13s5dfe8fs6ds8g78gt2f3fd";

    void response() throws IOException {
        javax.servlet.http.HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

}
