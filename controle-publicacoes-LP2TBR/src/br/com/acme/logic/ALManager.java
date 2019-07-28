package br.com.acme.logic;

import br.com.acme.AcademicLibrary;
import br.com.acme.gui.GUIMessage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * Essa classe realiza operações com a library, assim podendo buscar uma
 * instância da library atual, criar uma nova, salvar, carregar e salvar o log
 * de erros do sistema.
 *
 * @author Vinicios, gabid
 */
public class ALManager {

    private static AcademicLibrary library = null;

    /**
     * Usada para setar um objeto da AcademicLibrary em qualquer parte do
     * código.
     *
     * @return a library atual.
     */
    public static AcademicLibrary getInstance() {
        return library;
    }

    /**
     * Cria uma nova AcademicLibrary.
     *
     * @param libraryName nome da library.
     *
     * @param libraryDescription descrição da library.
     *
     * @param creationDate data de quando foi criada a library.
     */
    public static void newLibrary(String libraryName, String libraryDescription, String creationDate) {
        library = new AcademicLibrary(libraryName, libraryDescription, creationDate);
    }

    /**
     * Carrega a AcademicLibrary desejada.
     *
     * @param loadFile localização do arquivo.
     *
     * @throws FileNotFoundException o arquivo não foi encontrado.
     *
     * @throws IOException erro de IO.
     *
     * @throws ClassNotFoundException alguma classe do obj não foi encontrado.
     */
    public static void loadLibrary(String loadFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        AcademicLibrary ac = null;

        try {
            // Tenta carregar a última library salva.
            f = new File(loadFile);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ac = (AcademicLibrary) ois.readObject();
            library = ac;
            fis.close();
            ois.close();
        } catch (FileNotFoundException ex) {
            // É capturado se a última library não foi encontrada.
            try {
                // Tenta carregar a library default.
                f = new File("LibrarySave.save");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                ac = (AcademicLibrary) ois.readObject();
                library = ac;
                fis.close();
                ois.close();
                GUIMessage.warning("Last used library was not found, the default library will be loaded!    ");
            } catch (FileNotFoundException ex2) {
                // É capturado se a library deafult não foi encontrada.
                GUIMessage.warning("\nDeafult library was not found on the previous localization, a new default library was created.    \nCreate new accounts to use the system, and please SAVE this library!    \n");
                newLibrary("Main Library", "Defalt Library", CurrentDate.getDateNow());
                if (library.log) {
                    ALManager.addToLog(ex2.toString());
                }
            } finally {
                if (library.log) {
                    ALManager.addToLog(ex.toString());
                }
            }
        } catch (IOException ex) {
            if (library.log) {
                ALManager.addToLog(ex.toString());
            }
        } catch (Exception ex) {
            ALManager.addToLog(ex.toString());
        }
    }

    /**
     * Armazena uma AcademicLibrary na localização escolhida.
     *
     * @param saveLibrary arquivo que será salvo
     *
     * @param fileName nome do arquivo/sua localização.
     *
     * @throws FileNotFoundException pode não encontrar o arquivo.
     *
     * @throws IOException algum problema relacionado com o IO.
     */
    public static void persistLibrary(AcademicLibrary saveLibrary, String fileName) throws FileNotFoundException, IOException {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        /**
         * Evita o problema de ao clicar em um araquivo já existente e
         * concatenar mais 1 .save
         */
        if (fileName.contains(".save")) {
            fileName = fileName.replaceAll("\\.save", "");
            System.out.println(fileName);
        }

        try {
            // Armazena o objeto da AcademicLibrary.
            f = new File(fileName + ".save");
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(saveLibrary);
            LastAcess.saveAcess(fileName);
        } catch (Exception ex) {
            if (library.log) {
                ALManager.addToLog(ex.toString());
            }
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                if (library.log) {
                    ALManager.addToLog(ex.toString());
                }
            }
        }
    }

    /**
     * Adiciona no log a exception gerada em qualquer parte do código.
     *
     * @param infoLog a exception do problema.
     */
    public static void addToLog(String infoLog) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            // Armazena a exception no log com a data do ocorrido.
            fw = new FileWriter("alcs.log", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw, true);
            out.println(CurrentDate.getDateNow() + ": " + infoLog);
            out.flush();
        } catch (Exception ex) {
            if (library.log) {
                ALManager.addToLog(ex.toString());
            }
        }
    }
}
