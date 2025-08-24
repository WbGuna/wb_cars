package br.com.wbcars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.annotation.PostConstruct;
import java.util.List;

/**
 * Classe para demonstrar e testar funcionalidades de auditoria com Hibernate Envers
 */
@Component
public class AuditoriaConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void verificarTabelasAuditoria() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            System.out.println("=== HIBERNATE ENVERS - AUDITORIA CONFIGURADA ===");
            
            // Lista todas as tabelas criadas
            String sql = "SELECT table_name FROM information_schema.tables " +
                        "WHERE table_schema = 'public' AND table_name LIKE '%_aud' " +
                        "ORDER BY table_name";
            
            @SuppressWarnings("unchecked")
            List<String> tabelasAuditoria = entityManager.createNativeQuery(sql)
                                                        .getResultList()
                                                        .stream()
                                                        .map(Object::toString)
                                                        .toList();
            
            if (tabelasAuditoria.isEmpty()) {
                System.out.println("⚠️  Nenhuma tabela de auditoria encontrada ainda.");
                System.out.println("💡 As tabelas _AUD serão criadas automaticamente quando:");
                System.out.println("   1. Você inserir, atualizar ou deletar registros nas entidades @Audited");
                System.out.println("   2. O Hibernate Envers detectar mudanças nos dados");
            } else {
                System.out.println("✅ Tabelas de auditoria encontradas:");
                for (String tabela : tabelasAuditoria) {
                    System.out.println("   📋 " + tabela.toUpperCase());
                }
            }
            
            // Verifica se a tabela REVINFO foi criada
            String sqlRevinfo = "SELECT table_name FROM information_schema.tables " +
                               "WHERE table_schema = 'public' AND table_name = 'revinfo'";
            
            @SuppressWarnings("unchecked")
            List<String> tabelaRevinfo = entityManager.createNativeQuery(sqlRevinfo)
                                                    .getResultList()
                                                    .stream()
                                                    .map(Object::toString)
                                                    .toList();
            
            if (tabelaRevinfo.isEmpty()) {
                System.out.println("⚠️  Tabela REVINFO ainda não foi criada.");
                System.out.println("💡 Será criada automaticamente na primeira operação auditada.");
            } else {
                System.out.println("✅ Tabela REVINFO criada (controle de revisões)");
            }
            
            System.out.println("\n📚 Configurações de Auditoria Ativas:");
            System.out.println("   🔧 Sufixo das tabelas: _AUD");
            System.out.println("   🔧 Campo de revisão: REV");
            System.out.println("   🔧 Campo de tipo: REVTYPE");
            System.out.println("   🔧 Armazenar dados na exclusão: true");
            System.out.println("   🔧 Flag de modificação global: true");
            
            System.out.println("\n🎯 Como testar a auditoria:");
            System.out.println("   1. Acesse qualquer tela de cadastro (Cliente, Veículo, etc.)");
            System.out.println("   2. Insira, edite ou exclua um registro");
            System.out.println("   3. As tabelas _AUD serão criadas automaticamente");
            System.out.println("   4. O histórico de mudanças ficará disponível");
            System.out.println("================================================");
            
        } catch (Exception e) {
            System.err.println("❌ Erro ao verificar auditoria: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    /**
     * Método para obter o histórico de auditoria de uma entidade
     * Exemplo de uso futuro nas camadas de serviço
     */
    public List<Object[]> obterHistoricoAuditoria(Class<?> entityClass, Long entityId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Exemplo de consulta para buscar histórico
            // Este método pode ser expandido conforme necessário
            @SuppressWarnings("unchecked")
            List<Object[]> resultList = entityManager.createNativeQuery(
                "SELECT * FROM " + entityClass.getSimpleName().toLowerCase() + "_aud " +
                "WHERE " + getIdFieldName(entityClass) + " = :id ORDER BY rev DESC"
            )
            .setParameter("id", entityId)
            .getResultList();
            
            return resultList;
        } catch (Exception e) {
            System.err.println("Erro ao obter histórico: " + e.getMessage());
            return List.of();
        } finally {
            entityManager.close();
        }
    }
    
    private String getIdFieldName(Class<?> entityClass) {
        // Retorna o nome do campo ID baseado na convenção do projeto
        String className = entityClass.getSimpleName().toLowerCase();
        return className.substring(0, 3) + "_codigo";
    }
}
