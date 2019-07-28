package br.com.acme.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Essa classe realiza operações para buscar a hora atual.
 *
 * @author Vinicios, gabid
 */
public class CurrentDate {

    /**
     * Pega a data atual com o dia/mês/ano + hora/minuto/segundo,
     *
     * @return a data atual.
     */
    public static String getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Pega apenas a data atual com dia/mês/ano.
     *
     * @return a data atual.
     */
    public static String getOnlyDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
