package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarPadraoService implements ProdutoAlterarService {
    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;
    @Override
    public Produto alterar(Produto produto) {
        if (produto.getPreco() <= 0) {
            throw new RuntimeException("Preco invalido!");
        } else if (validaCodBarras(produto) == false) {
            throw new RuntimeException("Código de Barras Inválido!");
        }
        return produtoRepository.update(produto);
    }

    private boolean validaCodBarras(Produto produto) {
        String[] cod = produto.getCodigoBarra().split("");
        int verificador = 0;
        int resul_impar = 0;
        int resul_par = 0;
        for (int i = 0; i < cod.length - 1; i++) {
            if (i % 2 != 0) {
                resul_impar += Integer.parseInt(cod[i]) * 3;
            } else {
                resul_par += Integer.parseInt(cod[i]);
            }
        }
        int soma = resul_impar + resul_par + Integer.parseInt(cod[cod.length-1]);
        if (soma % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
