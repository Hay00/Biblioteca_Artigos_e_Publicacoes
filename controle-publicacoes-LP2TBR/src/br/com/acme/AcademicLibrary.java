package br.com.acme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe principal do sistema, onde será salvo os dados mais importantes,
 * realiza operações para modificar a library, etc...
 *
 * @author Vinicios, gabid
 */
public class AcademicLibrary implements ILibrary, Serializable {

    private Map<String, User> users;
    private Map<Long, Article> articles;
    private Map<Long, Book> books;
    // Maps para armazenar cada tipo de lista.

    private String name;
    private String description;
    private String creationDate;
    // Descrição da library.

    public boolean log = true;
    // Variável utilizada para controlar a ativação do log.

    public AcademicLibrary(String name, String description, String creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        users = new HashMap<>();
        articles = new HashMap<>();
        books = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<Long, Article> getArticles() {
        return articles;
    }

    public void setArticles(Map<Long, Article> articles) {
        this.articles = articles;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }
    // Fim dos Gets e Sets.

    /**
     * Conta a quantidade de articles.
     *
     * @return a quantidade existente de articles.
     */
    public short countArticles() {
        return (short) articles.size();
    }

    /**
     * Conta a quantidade de books.
     *
     * @return a quantidade existentes de books.
     */
    public short countBooks() {
        return (short) books.size();
    }

    /**
     * Busca o artigo na HashMap articles caso haver algum.
     *
     * @param issn usado para encontrar o artigo.
     * @return o artigo encontrado ou um nulo.
     */
    public Article findArticle(long issn) {
        if (articles.containsKey(issn)) {
            return articles.get(issn);
        }
        return null;
    }

    /**
     * Overloading do método superior, mas utiliza o título.
     *
     * @param title usado para encontrar o artigo.
     * @return o artigo encontrado ou um nulo.
     */
    public ArrayList<Article> findArticle(String title) {
        ArrayList<Article> articlesFound = new ArrayList();
        Pattern word = Pattern.compile(title.toLowerCase());
        Matcher match;
        for (long key : articles.keySet()) {
            Article arti = (Article) articles.get(key);

            match = word.matcher(arti.getTitle().toLowerCase());

            while (match.find()) {
                if (match.start() != -1 && match.end() != -1) {
                    articlesFound.add(arti);
                    break;
                }
            }
        }
        return articlesFound;
    }

    /**
     * Busca o livro na HashMap books caso haver algum.
     *
     * @param isbn usado para encontrar o livro.
     * @return o livro ou um nulo.
     */
    public Book findBook(long isbn) {
        if (books.containsKey(isbn)) {
            return books.get(isbn);
        }
        return null;
    }

    /**
     * Overloading do método acima, mas utiliza o título.
     *
     * @param title usado para encontrar o livro.
     * @return o livro caso encontrado.
     */
    public ArrayList<Book> findBook(String title) {

        ArrayList<Book> booksFound = new ArrayList();
        Pattern word = Pattern.compile(title.toLowerCase());
        Matcher match;
        for (long key : books.keySet()) {
            Book bok = (Book) books.get(key);

            match = word.matcher(bok.getTitle().toLowerCase());

            while (match.find()) {
                if (match.start() != -1 && match.end() != -1) {
                    booksFound.add(bok);
                    break;
                }
            }
        }
        return booksFound;
    }

    /**
     * Busca/verifica o usuário usando o login e a senha.
     *
     * @param login usado para saber se existe esse usuário na HashTable users.
     * @param password verifica se a senha é correspondente ao indicado.
     * @return se o login e a senha estão certos.
     */
    public boolean findUser(String login, int password) {
        if (users.containsKey(login)) {
            if (users.get(login).getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona o usuário no HashMap users.
     *
     * @param user indentifica o usuário que será adicionado na key do HashMap.
     */
    public void addUser(User user) {
        users.put(user.getLogin(), user);
    }

    /**
     * Remove o usuário informado.
     *
     * @param login indentifica qual usuário será removido.
     * @return se foi possivel remover o usuário do HashMap.
     */
    public boolean removeUser(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
            return true;
        }
        return false;
    }

    /**
     * Verifica se o login e a senha condiz com o usuário padrão, ou com
     * qualquer outro cadastrado.
     *
     * @param login Login utilizado para verificar o user.
     * @param password Senha para verificar o user.
     * @return Se o user é correspondente.
     */
    public boolean validateUser(String login, int password) {
        if (login.equals("admin") && password == 1234) {

            return true;
        }
        if (users.containsKey(login)) {
            if (users.get(login).getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return A quantidade de usuários do HashMap users.
     */
    public int countUsers() {
        return users.size();
    }

    /**
     * Adiciona uma publicação que pode ser um Article ou um Book, para
     * diferencialos é utilizado o operador instanceof.
     *
     * @param p é um artigo ou um livro.
     */
    public void addPublication(Publication p) {
        if (p instanceof Article) {
            articles.put(((Article) p).getIssn(), (Article) p);
        } else {
            books.put(((Book) p).getIsbn(), (Book) p);
        }
    }

    /**
     * Remove o book utilizando o id para indentificar a sua localização no
     * HashMap.
     *
     * @param id usado para indentificar a key do HashMap.
     * @return se foi encontrado e removido.
     */
    public boolean removeBook(long id) {
        if (books.containsKey(id)) {
            books.remove(id);
            return true;
        }
        return false;
    }

    /**
     * Remove o article utilizando o id para indentificar a sua localização no
     * HashMap.
     *
     * @param id usado para indentificar a key do HashMap.
     * @return se foi encontrado e removido.
     */
    public boolean removeArticle(long id) {
        if (articles.containsKey(id)) {
            articles.remove(id);
            return true;
        }
        return false;
    }

    /**
     * Busca todos os artigos.
     *
     * @return um array com os artigos.
     */
    public ArrayList<Article> getAllArticles() {
        return new ArrayList(articles.values());
    }

    /**
     * Busca todos os livros.
     *
     * @return um array com os livros.
     */
    public ArrayList<Book> getAllBooks() {
        return new ArrayList(books.values());
    }

    /**
     * A quantidade total de publicações.
     *
     * @return o número total de publicações.
     */
    public short countPublications() {
        return (short) (articles.size() + books.size());
    }

    /**
     * Varre as duas HashTables buscando a publicação ou o livro pelo titulo.
     * Não é case sensetive!
     *
     * @param title usado para indentificar qual a publicação.
     * @return a publicação ou o livro.
     */
    public ArrayList<Publication> findPublication(String title) {
        ArrayList<Publication> publicationsFound = new ArrayList();

        Pattern word = Pattern.compile(title.toLowerCase());
        // Cria um pattern com a palavra que será buscada.

        Matcher match;

        // Busca a palavra no book e article, se econtrada ela é adicionada
        // no array publicationsFound.
        for (long key : articles.keySet()) {
            Article arti = (Article) articles.get(key);

            match = word.matcher(arti.getTitle().toLowerCase());

            while (match.find()) {
                if (match.start() != -1 && match.end() != -1) {
                    publicationsFound.add(arti);
                    break;
                }
            }
        }
        for (long key : books.keySet()) {
            Book bok = (Book) books.get(key);

            match = word.matcher(bok.getTitle().toLowerCase());

            while (match.find()) {
                if (match.start() != -1 && match.end() != -1) {
                    publicationsFound.add(bok);
                    break;
                }
            }
        }
        return publicationsFound;
    }

    /**
     * Varre as duas HashTables buscando se existe alguma publicação com esse
     * titulo.
     *
     * @param title usado para indentificar qual a publicação.
     * @return se encontrou.
     */
    public boolean hasPublication(String title) {
        for (long key : articles.keySet()) {
            Article arti = (Article) articles.get(key);
            if (arti.getTitle().equals(title)) {
                return true;
            }
        }
        for (long key : books.keySet()) {
            Book bok = (Book) books.get(key);
            if (bok.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Indica se já existe um livro com esse isbn.
     *
     * @param number usado para saber se já existe um igual.
     * @return se já existe um isbn.
     */
    public boolean hasIsbn(Long number) {
        if (books.containsKey(number)) {
            return true;
        }
        return false;
    }

    /**
     * Indica se já existe um artigo com esse issn.
     *
     * @param number usado para saber se já existe um igual.
     * @return se já existe um issn.
     */
    public boolean hasIssn(Long number) {
        if (articles.containsKey(number)) {
            return true;
        }
        return false;
    }

    /**
     * Indica se já existe um user com esse login.
     *
     * @param logi usado para saber se já existe um igual.
     * @return se já existe um login igual a esse.
     */
    public boolean hasLogin(String logi) {
        if (users.containsKey(logi)) {
            return true;
        }
        return false;
    }
}
