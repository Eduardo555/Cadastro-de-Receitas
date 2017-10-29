
package beans;

import aplicacao.IngredienteControlador;
import aplicacao.ReceitaControlador;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class receitaMb {

    public List<Receita> receitas;
    
    Receita receita = new Receita(); 
    Ingrediente ingrediente = new Ingrediente();
    
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
    
    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
    
    //colocar aqui para executar no load
    public receitaMb() {
        carregarLista();
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
    public void novoReceita(){
        receita = new Receita();
    }
    
    public void salvarReceita(){
        ReceitaControlador.salvar(receita);
        this.novoReceita();
    }
    
    public void excluirReceita(Receita receita){
        ReceitaControlador.excluir(receita);
        carregarLista();
    }
    
    public void carregarLista(){
        receitas = ReceitaControlador.getPedidos();
    }
    
    
    
    
    
    
    
}
