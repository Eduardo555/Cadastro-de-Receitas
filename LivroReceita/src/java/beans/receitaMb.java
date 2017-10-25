
package beans;

import aplicacao.IngredienteControlador;
import aplicacao.ReceitaControlador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class receitaMb {

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
    
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    Receita receita; 
    Ingrediente ingrediente;
    
    public receitaMb() {
    }
    /* Ingredientes */
    public void novoIngrediente(){
        ingrediente = new Ingrediente();
    }
    
    public void salvarIngrediente(){
        IngredienteControlador.salvar(ingrediente);
        this.novoIngrediente();
    }
    
    /* Receitas */
}
