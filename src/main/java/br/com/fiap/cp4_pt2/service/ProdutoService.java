package br.com.fiap.cp4_pt2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.cp4_pt2.dto.ProdutoRequest;
import br.com.fiap.cp4_pt2.dto.ProdutoResponse;
import br.com.fiap.cp4_pt2.entity.Produto;
import br.com.fiap.cp4_pt2.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse create(ProdutoRequest produtoRequest) {
        Produto produto = produtoRepository.save(ProdutoService.toProduto(produtoRequest));
        return ProdutoService.toResponse(produto);
    }

    public List<ProdutoResponse> readAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoService.toResponse(produtos);
    }

    public Optional<ProdutoResponse> readById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            return Optional.empty();

        return Optional.of(ProdutoService.toResponse(produto.get()));
    }

    public Optional<ProdutoResponse> update(Long id, ProdutoRequest produtoRequest) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            return Optional.empty();

        Produto newProduto = toProduto(produtoRequest);
        newProduto.setId(id);

        produtoRepository.save(newProduto);
        return Optional.of(ProdutoService.toResponse(newProduto));
    }

    public boolean delete(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            return false;

        produtoRepository.deleteById(id);
        return true;
    }

    private static ProdutoResponse toResponse(Produto produto) {
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setId(produto.getId());
        produtoResponse.setNome(produto.getNome());
        produtoResponse.setTipo(produto.getTipo());
        produtoResponse.setSetor(produto.getSetor());
        produtoResponse.setTamanho(produto.getTamanho());
        produtoResponse.setPreco(produto.getPreco());
        return produtoResponse;
    }

    private static List<ProdutoResponse> toResponse(List<Produto> produtos) {
        return produtos.stream().map(produto -> ProdutoService.toResponse(produto)).collect(Collectors.toList());
    }

    private static Produto toProduto(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setTipo(produtoRequest.getTipo());
        produto.setSetor(produtoRequest.getSetor());
        produto.setTamanho(produtoRequest.getTamanho());
        produto.setPreco(produtoRequest.getPreco());

        return produto;
    }
}
