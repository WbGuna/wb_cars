package br.com.wbcars.dao;

import br.com.wbcars.modelo.Usuario;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UsuarioDAO {
    @PersistenceContext
    private EntityManager em;

    public Usuario buscarPorLogin(String login) {
        TypedQuery<Usuario> query = em.createQuery(
            "SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
        query.setParameter("login", login);
        java.util.List<Usuario> lista = query.getResultList();
        return lista.isEmpty() ? null : lista.get(0);
    }

    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }

    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public boolean verificarSenha(Usuario usuario, String senha) {
        // Supondo que a senha esteja criptografada com BCrypt
        return org.mindrot.jbcrypt.BCrypt.checkpw(senha, usuario.getSenha());
    }
}
