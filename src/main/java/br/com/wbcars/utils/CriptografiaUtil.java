package br.com.wbcars.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilitária para criptografia de dados sensíveis.
 * Implementa funções para:
 * - Hash de senhas (usando BCrypt ou PBKDF2)
 * - Criptografia e descriptografia de documentos (CPF/CNPJ)
 */
public class CriptografiaUtil {
    private static final Logger LOGGER = Logger.getLogger(CriptografiaUtil.class.getName());
    
    // Chave secreta usada para criptografia AES (em produção, deve estar em arquivo de configuração ou variável de ambiente)
    private static final String CHAVE_SECRETA = "WB_CARS_CHAVE_SECRETA_2025";
    private static final String SALT = "WB_CARS_SALT_2025";
    
    private static final int ITERACOES = 65536;
    private static final int TAMANHO_CHAVE = 256;
    private static final String ALGORITMO_CRIPTOGRAFIA = "AES/CBC/PKCS5Padding";
    
    private CriptografiaUtil() {
        // Construtor privado para evitar instanciação
    }
    
    /**
     * Gera um hash seguro para senha usando PBKDF2WithHmacSHA256
     * 
     * @param senha Senha em texto plano
     * @return Hash da senha com salt
     */
    public static String hashSenha(String senha) {
        try {
            // Gera um salt aleatório
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            // Cria o hash da senha
            KeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, ITERACOES, TAMANHO_CHAVE);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            
            // Combina salt e hash para armazenamento
            byte[] combined = new byte[salt.length + hash.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hash, 0, combined, salt.length, hash.length);
            
            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            LOGGER.log(Level.SEVERE, "Erro ao gerar hash da senha", e);
            throw new RuntimeException("Erro ao processar senha", e);
        }
    }
    
    /**
     * Verifica se uma senha em texto plano corresponde a um hash armazenado
     * 
     * @param senhaPlana Senha em texto plano para verificação
     * @param hashArmazenado Hash armazenado para comparação
     * @return true se a senha corresponde ao hash, false caso contrário
     */
    public static boolean verificarSenha(String senhaPlana, String hashArmazenado) {
        try {
            // Decodifica o hash armazenado
            byte[] combined = Base64.getDecoder().decode(hashArmazenado);
            
            // Extrai salt e hash
            byte[] salt = new byte[16];
            byte[] hash = new byte[combined.length - 16];
            System.arraycopy(combined, 0, salt, 0, salt.length);
            System.arraycopy(combined, salt.length, hash, 0, hash.length);
            
            // Recalcula o hash com a senha fornecida
            KeySpec spec = new PBEKeySpec(senhaPlana.toCharArray(), salt, ITERACOES, TAMANHO_CHAVE);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] novoHash = factory.generateSecret(spec).getEncoded();
            
            // Compara os hashes
            int diff = hash.length ^ novoHash.length;
            for (int i = 0; i < hash.length && i < novoHash.length; i++) {
                diff |= hash[i] ^ novoHash[i];
            }
            
            return diff == 0;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar senha", e);
            throw new RuntimeException("Erro ao verificar senha", e);
        }
    }
    
    /**
     * Criptografa documentos como CPF/CNPJ usando AES
     * 
     * @param documento Documento em texto plano
     * @return Documento criptografado em Base64
     */
    public static String criptografarDocumento(String documento) {
        try {
            // Remove caracteres especiais para padronização
            String documentoNormalizado = documento.replaceAll("[^0-9]", "");
            
            // Gera chave secreta a partir da senha
            byte[] iv = gerarIv();
            SecretKey chave = gerarChave(CHAVE_SECRETA);
            
            Cipher cipher = Cipher.getInstance(ALGORITMO_CRIPTOGRAFIA);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, chave, ivParameterSpec);
            
            byte[] textoCriptografado = cipher.doFinal(documentoNormalizado.getBytes(StandardCharsets.UTF_8));
            
            // Combina IV e texto criptografado
            byte[] combined = new byte[iv.length + textoCriptografado.length];
            System.arraycopy(iv, 0, combined, 0, iv.length);
            System.arraycopy(textoCriptografado, 0, combined, iv.length, textoCriptografado.length);
            
            return Base64.getEncoder().encodeToString(combined);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao criptografar documento", e);
            throw new RuntimeException("Erro ao criptografar documento", e);
        }
    }
    
    /**
     * Descriptografa documentos como CPF/CNPJ
     * 
     * @param documentoCriptografado Documento criptografado em Base64
     * @return Documento em texto plano
     */
    public static String descriptografarDocumento(String documentoCriptografado) {
        try {
            byte[] combined = Base64.getDecoder().decode(documentoCriptografado);
            
            // Extrai IV e texto criptografado
            byte[] iv = new byte[16];
            byte[] textoCriptografado = new byte[combined.length - 16];
            System.arraycopy(combined, 0, iv, 0, iv.length);
            System.arraycopy(combined, iv.length, textoCriptografado, 0, textoCriptografado.length);
            
            // Gera chave secreta a partir da senha
            SecretKey chave = gerarChave(CHAVE_SECRETA);
            
            Cipher cipher = Cipher.getInstance(ALGORITMO_CRIPTOGRAFIA);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, chave, ivParameterSpec);
            
            byte[] textoPlano = cipher.doFinal(textoCriptografado);
            return new String(textoPlano, StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao descriptografar documento", e);
            throw new RuntimeException("Erro ao descriptografar documento", e);
        }
    }
    
    /**
     * Gera um vetor de inicialização (IV) para AES
     * 
     * @return Array de bytes contendo o IV
     */
    private static byte[] gerarIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }
    
    /**
     * Gera uma chave secreta a partir de uma senha
     * 
     * @param senha Senha para gerar a chave
     * @return Chave secreta para uso com AES
     */
    private static SecretKey gerarChave(String senha) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(senha.toCharArray(), SALT.getBytes(), ITERACOES, TAMANHO_CHAVE);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }
    
    /**
     * Gera um hash MD5 de uma string.
     * Útil para criar hashes simplificados para não-senhas (não recomendado para senhas).
     * 
     * @param input String a ser transformada em hash
     * @return String contendo o hash MD5 em formato hexadecimal
     */
    public static String gerarHashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, "Erro ao gerar hash MD5", e);
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }
}
