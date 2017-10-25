
package aplicacao;

import beans.Ingrediente;
import beans.Receita;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class IngredienteControlador {
    
    public static void salvar(Ingrediente ingrediente) {
        EntityManager em = ReceitaServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(ingrediente);
        t.commit();
    }
    
}
