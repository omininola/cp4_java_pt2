package br.com.fiap.cp4_pt2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank
    private String setor;

    @NotBlank
    private String tamanho;

    @NotNull
    @Positive
    private int preco;
}
