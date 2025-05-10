package br.com.fiap.gestao.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "residuo")
@Data
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "residuo_seq")
    @SequenceGenerator(name = "residuo_seq", sequenceName = "SEQ_RESIDUO", allocationSize = 1)
    @Column(name = "id_residuo")
    private Long idResiduo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descricao")
    private String descricao;

}