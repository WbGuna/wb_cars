package br.com.wbcars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
public class DatabaseConfig {
    
    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @PostConstruct
    public void testConnection() {
        try {
            logger.info("🔧 Testando conexão com PostgreSQL...");
            
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            
            // Teste simples de conexão
            String result = (String) entityManager.createNativeQuery("SELECT version()").getSingleResult();
            
            entityManager.close();
            
            logger.info("✅ CONEXÃO POSTGRESQL ESTABELECIDA COM SUCESSO!");
            logger.info("📋 Versão do PostgreSQL: " + result);
            logger.info("🌐 URL: jdbc:postgresql://localhost:5433/postgres");
            logger.info("👤 Usuário: postgres");
            logger.info("========================================");
            
        } catch (Exception e) {
            logger.severe("❌ ERRO AO CONECTAR COM POSTGRESQL:");
            logger.severe("📋 Erro: " + e.getMessage());
            logger.severe("🔍 Verificar se PostgreSQL está rodando na porta 5433");
            logger.severe("🔍 Verificar se banco 'postgres' existe");
            logger.severe("🔍 Verificar credenciais: postgres/will@123");
            logger.severe("========================================");
            e.printStackTrace();
        }
    }
}
