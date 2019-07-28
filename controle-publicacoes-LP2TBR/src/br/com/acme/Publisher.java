package br.com.acme;

import java.io.Serializable;

/**
 *
 * @author Vinicios, gabid
 */
public class Publisher implements Serializable {

    private String name;
    private String country;

    public Publisher() {

    }

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Fim dos Gets e Sets.
}
