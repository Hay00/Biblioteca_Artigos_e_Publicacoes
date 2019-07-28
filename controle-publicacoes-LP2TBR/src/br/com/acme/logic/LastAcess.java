package br.com.acme.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Essa classe realiza operações para salvar e carregar a útima library salva no
 * sistema.
 *
 * @author Vinicios, gabid
 */
public class LastAcess {

    /**
     * Salva a localização do arquivo da library atual.
     *
     * @param localization localização do arquivo atual.
     */
    public static void saveAcess(String localization) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("LastLibraryUsed.txt", false);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw, true);
            out.println(localization + ".save");
            out.flush();
        } catch (Exception ex) {
            ALManager.addToLog(ex.toString());
        }
    }

    /**
     * Carrega a ultima library salva.
     *
     * @return a localização da library.
     */
    public static String loadAcess() {
        File f = null;
        BufferedReader bf = null;
        FileReader fr = null;
        String str;
        try {
            f = new File("LastLibraryUsed.txt");
            fr = new FileReader(f);
            bf = new BufferedReader(fr);

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            str = sb.toString();
            return str;
        } catch (Exception ex) {
            ALManager.addToLog(ex.toString());
            return str = "empty";
        }
    }
}
