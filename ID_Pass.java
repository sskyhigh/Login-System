import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class ID_Pass {
    private String userName;
    private String password;
    HashMap<String, String> Credentials = new HashMap<String, String>();

    public ID_Pass() throws IOException {
        Credentials.put("skyhigh", "1100");
        Credentials.put("programmer", "nono");
        Credentials.put("phone", "99999");
        StoringData data = new StoringData(userName, password);
        data.reading(Credentials);
        data.get_Credentials();
    }

    public HashMap<String, String> getCredentials() {
        return Credentials;
    }
}
