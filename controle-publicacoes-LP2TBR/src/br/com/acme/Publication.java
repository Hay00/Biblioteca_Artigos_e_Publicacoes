package br.com.acme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicios, gabid
 */
public abstract class Publication implements Serializable {

    private List<Author> authors;
    private String title;
    private short year;
    private byte volume;
    // Nome do livro etc...

    public Publication() {
        authors = new ArrayList<>();
    }

    public Publication(String title, short year, byte volume) {
        this();
        this.title = title;
        this.year = year;
        this.volume = volume;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public byte getVolume() {
        return volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    // Fim dos Gets e Sets.

    /**
     * Adiciona o author no arrayList.
     *
     * @param author passa as informações do author.
     */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    /**
     * Remove o author pelo seu nome.
     *
     * @param name usado para buscar o author que irá ser excluído.
     */
    public void removeAuthor(String name) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getName().equals(name)) {
                authors.remove(i);
                break;
            }
        }
    }

    /**
     * Passa uma lista de authors para a da classe,
     *
     * @param authors lista de authors.
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
