package br.com.fiap.gestao.dto;

import br.com.fiap.gestao.model.Residuo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResiduoDTO {

    private Long idResiduo;
    private String tipo;
    private String descricao;

    public ResiduoDTO(Residuo residuo){

        this.idResiduo = residuo.getIdResiduo();
        this.tipo = residuo.getTipo();
        this.descricao = residuo.getDescricao();

    }
}