import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StoringData {
    HashMap<String, String> _Credentials = new HashMap<String, String>();
    String username;
    String password;
    final static String outputFilePath = "C:\\Users\\Shao\\Documents\\GitHub\\Login-System";

    public StoringData(String name, String psw) throws IOException {
        this.username = name;
        this.password = psw;
        _Credentials.put(name, psw);
        savingFile(_Credentials);
        reading(_Credentials);
    }

    public StoringData() throws IOException {
        savingFile(_Credentials);
        reading(_Credentials);
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

    public void check(HashMap<String, String> hashMap) throws IOException {
        File file = new File(outputFilePath);
        BufferedWriter bf = null;
        try {
            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter("output.txt"));

            //iterate map entries
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {

                //put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());

                //new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //always close the writer
                assert bf != null;
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    public HashMap<String, String> get_Credentials() {
        return _Credentials;
    }
}
