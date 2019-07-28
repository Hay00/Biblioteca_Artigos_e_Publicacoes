package br.com.acme;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vinicios, gabid
 */
public class Article extends Publication implements Serializable {

    private Journal journal;
    private long issn;
    private byte issue;
    private short startPage;
    private short endPage;
    private ArrayList<String> keyWords;

    public Article() {
        super();
        keyWords = new ArrayList();
        journal = new Journal();
    }

    public Article(String title, short year, byte volume, long issn, byte issue, short startPage, short endPage) {
        super(title, year, volume);
        this.issn = issn;
        this.issue = issue;
        this.startPage = startPage;
        this.endPage = endPage;
        keyWords = new ArrayList();
        journal = new Journal();
    }

    public long getIssn() {
        return issn;
    }

    public void setIssn(long issn) {
        this.issn = issn;
    }

    public byte getIssue() {
        return issue;
    }

    public void setIssue(byte issue) {
        this.issue = issue;
    }

    public short getStartPage() {
        return startPage;
    }

    public void setStartPage(short startPage) {
        this.startPage = startPage;
    }

    public short getEndPage() {
        return endPage;
    }

    public void setEndPage(short endPage) {
        this.endPage = endPage;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    // Fim dos Gets e Sets
    /**
     * Pega o array keyWords.
     *
     * @return o array.
     */
    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    /**
     * Seta o array que for passado.
     *
     * @param keyWords array que será colocado.
     */
    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * Remove uma key word que for passada.
     *
     * @param key string que indica qual key será removida.
     * @return se foi removido a keyWord.
     */
    public boolean removeKeyWord(String key) {
        for (int i = 0; i < keyWords.size(); i++) {
            if (keyWords.get(i).equals(key)) {
                keyWords.remove(i);
                return true;
            }
        }
        return false;
    }
}
