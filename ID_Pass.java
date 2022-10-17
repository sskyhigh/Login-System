import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class ID_Pass extends StoringData {
    private String userName;
    private String password;
    HashMap<String, String> Credentials = new HashMap<String, String>();

    public ID_Pass() throws IOException {
        super();
        //Register register = new Register(Credentials);
        Credentials.put("skyhigh", "1100");
        Credentials.put("programmer", "nono");
        Credentials.put("phone", "99999");
        StoringData data = new StoringData();
        Credentials = data.get_Credentials();
        StoringData data1 = new StoringData("skyhigh", "1100");
        StoringData data2 = new StoringData("programmer", "nono");
        StoringData data3 = new StoringData("phone", "99999");
        Credentials = data.get_Credentials();
    }

    public HashMap<String, String> getCredentials() {
        return Credentials;
    }
}