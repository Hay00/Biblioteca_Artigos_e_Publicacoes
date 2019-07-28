package br.com.acme.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicios, gabid
 */
public class GUIMessage {

    /**
     * Mosta uma tela de diálogo dando uma informação ao usuário.
     *
     * @param msg mensagem que será mostrada.
     */
    public static void inf(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mostra uma tela de diálogo avisando o que ocorreu.
     *
     * @param msg mensagem que será mostrada.
     */
    public static void warning(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Warning", 2);
    }

    /**
     * Mostra uma tela de diálogo perguntando algo.
     *
     * @param msg mensagem que será mostrada.
     * @return a resposta do usuário.
     */
    public static int question(String msg) {
        return JOptionPane.showConfirmDialog(null, msg, "Question", JOptionPane.YES_NO_OPTION);
    }

    /**
     * Mostra uma tela de diálogo explicando o erro que ocorreu.
     *
     * @param msg mensagem que será mostrada.
     */
    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.OK_OPTION);
    }

    /**
     * Sobre o programa.
     */
    public static void about() {
        JOptionPane.showMessageDialog(null, "Regional University of Northwest of Rio Grande do Sul (UNIJUI) - Brazil \n"
                + "Computer Science - 2018\nProject by:  Gabriel Diniz - diniz@gdiniz.com\nVinicios Schulze - vine.vinedutra@hotmail.com  ", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Contato de suporte.
     */
    public static void support() {
        JOptionPane.showMessageDialog(null, "Contacts \nGabriel Diniz - diniz@gdiniz.com\nVinicios Schulze - vine.vinedutra@hotmail.com\n");
    }
}
