package br.com.wbcars.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("dateUtil")
@ViewScoped
public class DateUtil implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DateUtil.class.getName());
    
    // Formatadores padrão
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter FORMATO_DATA_HORA_COMPLETA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    /**
     * Converte LocalDateTime para string no formato dd/MM/yyyy
     */
    public static String formatarData(LocalDateTime data) {
        if (data == null) {
            return "-";
        }
        
        try {
            return data.format(FORMATO_DATA);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao formatar LocalDateTime: " + data, e);
            return "-";
        }
    }
    
    /**
     * Converte LocalDate para string no formato dd/MM/yyyy
     */
    public static String formatarData(LocalDate data) {
        if (data == null) {
            return "-";
        }
        
        try {
            return data.format(FORMATO_DATA);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao formatar LocalDate: " + data, e);
            return "-";
        }
    }
    
    /**
     * Converte LocalDateTime para string no formato dd/MM/yyyy HH:mm
     */
    public static String formatarDataHora(LocalDateTime data) {
        if (data == null) {
            return "-";
        }
        
        try {
            return data.format(FORMATO_DATA_HORA);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao formatar LocalDateTime com hora: " + data, e);
            return "-";
        }
    }
    
    /**
     * Converte LocalDateTime para string no formato dd/MM/yyyy HH:mm:ss
     */
    public static String formatarDataHoraCompleta(LocalDateTime data) {
        if (data == null) {
            return "-";
        }
        
        try {
            return data.format(FORMATO_DATA_HORA_COMPLETA);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao formatar LocalDateTime completa: " + data, e);
            return "-";
        }
    }
    
    /**
     * Método genérico que aceita Object e tenta converter
     * Útil para quando não sabemos o tipo exato da data
     */
    public static String formatarDataGenerica(Object data) {
        if (data == null) {
            return "-";
        }
        
        try {
            if (data instanceof LocalDateTime) {
                return formatarData((LocalDateTime) data);
            } else if (data instanceof LocalDate) {
                return formatarData((LocalDate) data);
            } else {
                return data.toString();
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao formatar data genérica: " + data, e);
            return "-";
        }
    }
    
    // Métodos de instância para JSF (delegam para os métodos estáticos)
    
    public String formatDate(LocalDateTime data) {
        return DateUtil.formatarData(data);
    }
    
    public String formatDate(LocalDate data) {
        return DateUtil.formatarData(data);
    }
    
    public String formatDateTime(LocalDateTime data) {
        return DateUtil.formatarDataHora(data);
    }
    
    public String formatDateTimeComplete(LocalDateTime data) {
        return DateUtil.formatarDataHoraCompleta(data);
    }
    
    public String formatGeneric(Object data) {
        return DateUtil.formatarDataGenerica(data);
    }
}