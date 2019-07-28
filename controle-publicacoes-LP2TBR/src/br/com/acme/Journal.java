package br.com.acme;

import java.io.Serializable;

/**
 *
 * @author Vinicios, gabid
 */
public class Journal implements Serializable {

    private String name;
    private byte impactFactor;
    Publisher publisher;

    public Journal() {

    }

    public Journal(String name, byte impactFactor, Publisher publisher) throws IllegalArgumentException {
        this.publisher = publisher;
        this.name = name;
        this.impactFactor = impactFactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(byte impactFactor) throws IllegalArgumentException {
        if (impactFactor < 0) {
            throw new IllegalArgumentException("Número negativo!");
        }
        this.impactFactor = impactFactor;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    // Fim dos Gets e Sets
}
