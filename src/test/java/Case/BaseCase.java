package Case;

public class BaseCase {
    private String token;
    private String username;
    private String password;

    public BaseCase(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
        //request something take return token
    }
}
