import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoringData {
    HashMap<String, String> _Credentials = new HashMap<String, String>();
    String username;
    String password;

    public StoringData(String name, String psw) throws IOException {
        this.username = name;
        this.password = psw;
        _Credentials.put(name, psw);
        savingFile(_Credentials);
        reading(_Credentials);
    }

    public void savingFile(HashMap<String, String> hashMap) throws FileNotFoundException {
        try {
            // writes to file userInfo,
            // note there is no textfile.
            File newFile = new File("userInfo");
            FileOutputStream stream = new FileOutputStream(newFile);
            ObjectOutputStream output = new ObjectOutputStream(stream);
            output.writeObject(hashMap);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void reading(HashMap<String, String> hashMap) throws IOException {
        try {
            File readingData = new File("userInfo");
            FileInputStream inputStream = new FileInputStream(readingData);
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            HashMap<String, String> readFile = (HashMap<String, String>) objectStream.readObject();
            inputStream.close();
            objectStream.close();
            for (Map.Entry<String, String> i : readFile.entrySet()) {
                System.out.println(i.getKey() + " " + i.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error at : " + e);
        }
    }

    public HashMap<String, String> get_Credentials() {
        return _Credentials;
    }
}
