package aplicacao;

import javax.persistence.*;

public class ReceitaServico {
    
    public static EntityManagerFactory emf;
    
    public static EntityManager getEM() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(
                    "ReceitasJPAU");
        }
        
        return emf.createEntityManager();
    }
    
}
