import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ID_Pass idPass = new ID_Pass();
        Login_Page loginPage = new Login_Page(idPass.getCredentials());

    }
}
