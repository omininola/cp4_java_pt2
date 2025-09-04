package br.com.fiap.cp4_pt2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CP4_TB_PRODUTO")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_produto", nullable = false)
    private String nome;

    @Column(name = "ds_tipo", nullable = false)
    private String tipo;

    @Column(name = "ds_setor", nullable = false)
    private String setor;

    @Column(name = "ds_tamanho", nullable = false)
    private String tamanho;

    @Column(name = "preco", nullable = false)
    private int preco; // Preço em int por questões de precisão
}
