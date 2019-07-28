package br.com.acme;

import java.io.Serializable;

/**
 *
 * @author Vinicios, gabid
 */
public abstract class Person implements Serializable {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Fim dos Gets e Sets.
}
