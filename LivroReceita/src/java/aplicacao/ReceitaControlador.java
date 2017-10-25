package aplicacao;

import beans.Receita;
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
    
}
