package br.com.fiap.cp4_pt2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String tipo;
    private String setor;
    private String tamanho;
    private int preco;
}
