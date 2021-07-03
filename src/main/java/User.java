
public class User {



    private String USER;
    private int ID;
    private String PASSWORD;
    private String EMAIL;

    public User(String EMAIL, String USER, String PASSWORD) {
        this.ID = ID;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
    }


    public String getUSER() {
        return USER;
    }

    public int getID() {
        return ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return  "USER: '" + USER + '\'' +
                ", ID: " + ID +
                ", PASSWORD: '" + PASSWORD + '\'' +
                ", EMAIL: '" + EMAIL + '\'';
    }
}
