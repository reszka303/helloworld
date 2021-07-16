package pl.javastart.CFormsAndPostMethod_3.forms.model;

public class User {
    private String username;
    private String password;
    private String gender;
    private String[] hobby;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
