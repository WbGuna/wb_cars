package br.com.wbcars.dao;

import br.com.wbcars.entity.Veiculo;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO extends GenericDAO<Veiculo> {
    private static final Logger LOGGER = Logger.getLogger(VeiculoDAO.class.getName());
    private static VeiculoDAO instance;

    private VeiculoDAO() {
        super(Veiculo.class);
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            synchronized (VeiculoDAO.class) {
                if (instance == null) {
                    instance = new VeiculoDAO();
                }
            }
        }
        return instance;
    }

    public List<Veiculo> findByPlaca(String placa) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.placa) LIKE LOWER(:placa)", Veiculo.class);
            query.setParameter("placa", "%" + placa + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por placa: " + placa, e);
            return List.of();
        }
    }

    public List<Veiculo> findByModelo(String modelo) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE LOWER(v.modelo) LIKE LOWER(:modelo)", Veiculo.class);
            query.setParameter("modelo", "%" + modelo + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por modelo: " + modelo, e);
            return List.of();
        }
    }

    public List<Veiculo> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                "SELECT v FROM Veiculo v WHERE v.dataCadastro BETWEEN :inicio AND :fim", Veiculo.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por intervalo de data", e);
            return List.of();
        }
    }
}
