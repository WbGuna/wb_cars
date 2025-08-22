package br.com.wbcars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import jakarta.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
public class DatabaseConfig {
    
    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @PostConstruct
    public void testConnection() {
        try {
            logger.info("🔧 Testando conexão com PostgreSQL...");
            
            Session session = sessionFactory.openSession();
            
            // Teste simples de conexão
            String result = session.createNativeQuery("SELECT version()", String.class).getSingleResult();
            
            session.close();
            
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
