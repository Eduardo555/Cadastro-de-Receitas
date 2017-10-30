package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENTES")
public class Ingrediente implements Serializable {
    @Id
    @Column(name = "cod_ingrediente")
    private Integer cod_ingrediente;
    private String Descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_receita")
    private Receita receita;

    public Integer getCodIngrediente() {
        return cod_ingrediente;
    }

    public void setCodIngrediente(Integer codIngrediente) {
        this.cod_ingrediente = codIngrediente;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Integer getCod_ingrediente() {
        return cod_ingrediente;
    }

    public void setCod_ingrediente(Integer cod_ingrediente) {
        this.cod_ingrediente = cod_ingrediente;
    }
    
}
