package br.com.wbcars.utils;

public class HashGenerator {
    public static void main(String[] args) {
        String senha = "admin123";
        String hash = CriptografiaUtil.hashSenha(senha);
        System.out.println("Hash para a senha 'admin123': " + hash);
        
        // Teste de verificação
        boolean valido = CriptografiaUtil.verificarSenha(senha, hash);
        System.out.println("Verificação da senha: " + valido);
    }
}
