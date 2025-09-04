package br.com.fiap.cp4_pt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.cp4_pt2.dto.ProdutoRequest;
import br.com.fiap.cp4_pt2.entity.Produto;
import br.com.fiap.cp4_pt2.service.ProdutoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/mercado")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/novo")
    public String create(Model model) {
        model.addAttribute("produto", new Produto());
        return "formulario";
    }

    @PostMapping
    public String create(@Valid ProdutoRequest produtoRequest) {
        produtoService.create(produtoRequest);
        return "redirect:/mercado";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("produtos", produtoService.readAll());
        return "listar";
    }

    @GetMapping("/atualizar/{id}")
    public String update(Model model, @PathVariable Long id) {
        model.addAttribute("produto", produtoService.readById(id));
        model.addAttribute("produtoId", id);
        return "formulario_update";
    }

    @PostMapping("/atualizar/{id}")
    public String update(@Valid ProdutoRequest produtoRequest, @PathVariable Long id) {
        produtoService.update(id, produtoRequest);
        return "redirect:/mercado";
    }

    @GetMapping("/deletar/{id}")
    public String delete(Model model, @PathVariable Long id) {
        model.addAttribute("produtoId", id);
        return "formulario_delete";
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable Long id) {
        produtoService.delete(id);
        return "redirect:/mercado";
    }
}
