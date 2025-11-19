package br.com.ifba.infrastructure.util;

public class StringUtil {
    
    /**
     * Retorna true se a string for nula ou vazia (apenas espaços).
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}

