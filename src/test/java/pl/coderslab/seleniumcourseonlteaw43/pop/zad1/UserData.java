package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

public class UserData {
    private String firstName;
    private String lastName;
    private String password;
    private boolean isMr;
    private boolean isSignUpForNewsletter;

    public UserData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData setMr(boolean mr) {
        isMr = mr;
        return this;
    }

    public UserData setSignUpForNewsletter(boolean signUpForNewsletter) {
        isSignUpForNewsletter = signUpForNewsletter;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isMr() {
        return isMr;
    }

    public boolean isSignUpForNewsletter() {
        return isSignUpForNewsletter;
    }
}
