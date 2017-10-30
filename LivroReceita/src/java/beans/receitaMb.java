
package beans;

import aplicacao.IngredienteControlador;
import aplicacao.ReceitaControlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature;

@ManagedBean
@SessionScoped
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
        carregarLista();
    }
    
    public void excluirReceita(Receita receita){
        ReceitaControlador.excluir(receita);
        carregarLista();
    }
    
    public void carregarLista(){
        receitas = ReceitaControlador.getPedidos();
    }
    
    public void novaReceitaRedirect(){
        novoReceita();
        try 
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(receitaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //colocamos dados em sessao para editar
    public void editarReceita(Receita receita){
        
        try 
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("receita", receita);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            
            setReceita(receita);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(receitaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
