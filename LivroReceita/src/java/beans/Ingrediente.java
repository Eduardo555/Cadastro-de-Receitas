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
    @Column(name = "COD_INGREDIENTES")
    private Integer codIngrediente;
    private String Descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_RECEITA")
    private Receita receita;
    
    public Integer getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(Integer codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
}
