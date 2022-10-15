import java.util.HashMap;

public class ID_Pass {
    HashMap<String, String> Credentials = new HashMap<String, String>();

    public ID_Pass() {
        Credentials.put("skyhigh", "1100");
        Credentials.put("programmer", "nono");
        Credentials.put("phone", "99999");
    }
    public HashMap<String, String> getCredentials() {
        return Credentials;
    }
}
