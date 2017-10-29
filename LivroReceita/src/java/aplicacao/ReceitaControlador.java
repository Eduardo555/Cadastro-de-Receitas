package aplicacao;

import beans.Receita;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ReceitaControlador {
    
    public static void salvar(Receita receita) {
        EntityManager em = ReceitaServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(receita);
        t.commit();
    }
    
    public static void excluir(Receita produto) {
        EntityManager em = ReceitaServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Receita.class, produto.getCodigo()));
        t.commit();
    }
    
    public static List<Receita> getPedidos() {
        EntityManager em = ReceitaServico.getEM();
        return em.createQuery("select r from Receita r", Receita.class).getResultList();
    }
    
}
