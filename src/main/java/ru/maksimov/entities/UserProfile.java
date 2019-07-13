package ru.maksimov.entities;

/**
 * <p>
 *     Пользовательский профиль
 * </p>
 */
public class UserProfile {

    private String login;
    private String password;
    private String email;

    public UserProfile() {
    }

    public UserProfile setLogin(String login){
        this.login = login;
        return this;
    }

    public UserProfile setPassword(String password){
        this.password = password;
        return this;
    }

    public UserProfile setEmail(String email){
        this.email = email;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
