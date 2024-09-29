package com.ecommerce.produto.service.impl;

import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.ProdutoRepository;
import com.ecommerce.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Optional<Produto> create(Produto produto) {
        return Optional.of(produtoRepository.save(produto));
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto update(Long id, Produto produto) {
        Optional<Produto> optProduto = produtoRepository.findById(id);
        if (optProduto.isPresent()) {
            Produto existingProduto = optProduto.get();
            existingProduto.setNome(produto.getNome());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setPreco(produto.getPreco());
            existingProduto.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(existingProduto);
        } else {
            throw new RuntimeException("Produto com id " + id + " não encontrado");
        }
    }
}
