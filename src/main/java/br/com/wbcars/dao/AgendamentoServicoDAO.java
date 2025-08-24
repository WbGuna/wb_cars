package br.com.wbcars.dao;

import br.com.wbcars.entity.AgendamentoServico;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendamentoServicoDAO extends GenericDAO<AgendamentoServico> {
    private static final Logger LOGGER = Logger.getLogger(AgendamentoServicoDAO.class.getName());
    private static AgendamentoServicoDAO instance;

    private AgendamentoServicoDAO() {
        super(AgendamentoServico.class);
    }

    public static AgendamentoServicoDAO getInstance() {
        if (instance == null) {
            synchronized (AgendamentoServicoDAO.class) {
                if (instance == null) {
                    instance = new AgendamentoServicoDAO();
                }
            }
        }
        return instance;
    }

    public List<AgendamentoServico> findByCliente(String nomeCliente) {
        try {
            TypedQuery<AgendamentoServico> query = em.createQuery(
                "SELECT a FROM AgendamentoServico a WHERE LOWER(a.cliente.nome) LIKE LOWER(:nome)", AgendamentoServico.class);
            query.setParameter("nome", "%" + nomeCliente + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por cliente: " + nomeCliente, e);
            return List.of();
        }
    }

    public List<AgendamentoServico> findByDataAgendadaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<AgendamentoServico> query = em.createQuery(
                "SELECT a FROM AgendamentoServico a WHERE a.diaAgendamento BETWEEN :inicio AND :fim", AgendamentoServico.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por intervalo de data", e);
            return List.of();
        }
    }
    
    /**
     * Sobrescreve o método da classe pai para manter compatibilidade
     */
    @Override
    public List<AgendamentoServico> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return super.findByDataCadastroRange(inicio, fim);
    }
}
