package br.com.acme;

import java.io.Serializable;

/**
 *
 * @author Vinicios, gabid
 */
public class User extends Person implements Serializable {

    AcademicLibrary library;
    private String phone;
    private String login;
    private int password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    // Fim dos Gets e Sets.

    /**
     *
     * @param l login para encontrar o user.
     * @param p senha usada para encontrar o user.
     * @param library idica qual é a AcademicLibrary atual.
     * @return se achou o usuário.
     */
    public boolean isValid(String l, int p, AcademicLibrary library) {
        this.library = library;
        String loginDefault = "admin";
        int passwordDefault = 1234;

        if ((l.equals(loginDefault)) && (p == passwordDefault)) {
            return true;
        }

        if (library.findUser(l, p)) {
            return true;
        }

        return false;
    }

}
