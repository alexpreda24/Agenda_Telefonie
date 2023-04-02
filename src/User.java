import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String parola;
    public User(String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public String getParola() {
        return parola;
    }

    public String getUsername() {
        return username;
    }

}
