package br.com.acme;

import java.util.ArrayList;

/**
 *
 * @author Vinicios, gabid
 */
public interface ILibrary {

    public void addPublication(Publication p);

    public boolean removeBook(long id);

    public boolean removeArticle(long id);

    public ArrayList<Article> getAllArticles();

    public ArrayList<Book> getAllBooks();

    public short countPublications();

    public ArrayList<Publication> findPublication(String title);

    public boolean hasPublication(String title);

}
