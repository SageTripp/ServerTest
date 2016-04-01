package action;

import com.google.gson.JsonObject;

/**
 * Created by zst on 2016/3/25 0025.
 * sd
 */
public class LoginAction extends Action {
    private String name;
    private String pass;

    public String login() throws Exception {
        boolean r = false;
        JsonObject token = new JsonObject();
        if (getName().equals("hahaha") && getPass().equals("hahaha")) {
            r = true;
            token.addProperty("token", this.token);
        } else {
            r = false;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status", r ? "success" : "fail");
        jsonObject.addProperty("msg", r ? "" : "用户名或密码错误");
        jsonObject.addProperty("code", r ? 100 : 111);
        if (r)
            jsonObject.add("data", token);
        result = jsonObject.toString();
        response();
        return NONE;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
