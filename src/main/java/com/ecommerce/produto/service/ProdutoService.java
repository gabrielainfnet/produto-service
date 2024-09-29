package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Optional<Produto> create(Produto produto);

    Optional<Produto> findById(Long id);

    List<Produto> findAll();

    void deleteById(Long id);

    Produto update(Long id, Produto produto);

}
