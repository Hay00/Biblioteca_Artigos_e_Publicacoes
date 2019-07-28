package br.com.acme;

import java.io.Serializable;

/**
 *
 * @author Vinicios, gabid
 */
public class Author extends Person implements Serializable {

    private String afiliation;
    private boolean isCorrespondingAuthor;

    public String getAfiliation() {
        return afiliation;
    }

    public void setAfiliation(String afiliation) {
        this.afiliation = afiliation;
    }

    public boolean isIsCorrespondingAuthor() {
        return isCorrespondingAuthor;
    }

    public void setIsCorrespondingAuthor(boolean isCorrespondingAuthor) {
        this.isCorrespondingAuthor = isCorrespondingAuthor;
    }

    // Fim dos Gets e Sets.
}
