package action;

import com.google.gson.JsonObject;

import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created by zst on 2016/3/28 0028.
 */
public class UpdateAction extends Action {
    private String oldVer;
    private String token;
    private String newVersion;
    private String url;

    private InputStream fileInputStream;
    private String fileName;
    private String apk;

    private String uri = "E:" + File.separator + "work" + File.separator + "FourUser" + File.separator
            + "app" + File.separator + "build" + File.separator
            + "outputs" + File.separator + "apk" + File.separator;

    public String check() throws Exception {
        boolean r = false;
        url = "http://192.168.1.117:8080/download?apk=app-debug.apk";
        if (getToken().equals(token)) {
            r = true;
            newVersion = "1.1";
        }
        JsonObject ro = new JsonObject();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status", r ? "success" : "fail");
        jsonObject.addProperty("msg", r ? "" : "更新时出新异常");
        jsonObject.addProperty("code", r ? 100 : 112);
        if (r) {
            ro.addProperty("url", url);
            ro.addProperty("version", newVersion);
        }
        jsonObject.add("data", ro);
        result = jsonObject.toString();
        response();
        return NONE;
    }

    public String download() {
        File file = new File(uri + getApk());
        fileName = file.getName();
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String getOldVer() {
        return oldVer;
    }

    public void setOldVer(String oldVer) {
        this.oldVer = oldVer;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setApk(String apk) {
        this.apk = apk;
    }

    public String getApk() {
        return apk;
    }
}
