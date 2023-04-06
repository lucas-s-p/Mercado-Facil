package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testes do repositório de Lotes")
class LoteRepositoryTests {

    @Autowired
    LoteRepository<Lote, Long> driver;

    Lote lote;
    Produto produto;
    Lote loteAlternativo;
    Lote resultado;
    @BeforeEach
    void setUp() {
        produto = Produto.builder()
                .id(1L)
                .nome("Produto Base")
                .codigoBarra("123456789")
                .fabricante("Fabricante Base")
                .preco(100.00)
                .build();
        lote = Lote.builder()
                .id(1L)
                .produto(produto)
                .numeroDeItens(100)
                .build();

        loteAlternativo = Lote.builder()
                .id(1L)
                .numeroDeItens(200)
                .produto(produto)
                .build();
    }

    @AfterEach
    void tearDown() {
        produto = null;
        lote = null;
    }

    @Test
    @DisplayName("Inserir o primeiro lote de produtos no banco de dados")
    void inserirPrimeiroLoteNoBD() {
        // Arrange
        driver.deleteAll();
        // Act
        Lote resultado = driver.save(lote);
        // Assert
        assertNotNull(resultado);
        assertEquals(1, driver.findAll().size());
        assertEquals(lote.getId().longValue(), resultado.getId().longValue());
        assertEquals(produto, resultado.getProduto());
    }

    @Test
    @DisplayName("Inserir o segudo ou posterior lote de produtos no banco")
    void inserirSegundoOuPosteriorLoteDeProdutosNoBanco() {
        // Arrange
        driver.deleteAll();
        Produto produto2 = Produto.builder()
                .id(2L)
                .nome("Produto Dois")
                .codigoBarra("987654321")
                .fabricante("Fabricante Dois")
                .preco(200.00)
                .build();
        Lote lote2 = Lote.builder()
                .id(2L)
                .produto(produto2)
                .numeroDeItens(200)
                .build();
        driver.save(lote);

        // Act
        Lote resultado = driver.save(lote2);

        // Assert
        assertNotNull(resultado);
        assertEquals(2, driver.findAll().size());
        assertEquals(lote2.getId().longValue(), resultado.getId().longValue());
        assertEquals(produto2, resultado.getProduto());

    }

    @Test
    @DisplayName("Adcionar lote com mesmo identificador")
    void testeLoteComMesmoIdentificador() {
        Produto produtoAlternativo = Produto.builder()
                .id(2L)
                .nome("Produto Alternativo")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();

        Lote resultado_x = driver.save(lote);
        Lote resultado_y = driver.save(loteAlternativo);

        // Para fins de identificação que deveria ser pelo ID não deveria aceitar
        // lote com o mesmo ID. Algo que está acontecendo.
        assertEquals(driver.findAll().size(), 2);
    }

    @Test
    @DisplayName("Teste de procurar o Lote")
    void testFindRetornoDeLote() {
        resultado = driver.save(lote);
        assertEquals(driver.findAll().size(), 1);
        /*
         * Forma que esse teste, em específico, poderia funcionar:
         * int pos = 0;
         * Long n = Long.valueOf(pos);
         * assertEquals(driver.find(n), resultado);
         */
        // Esse teste da erro, pois a coleção usada para armazenamento
        // não posusui como chave o ID ou o parseInt("" + id) como chave.
        assertEquals(driver.find(resultado.getId().longValue()), resultado);
    }

    @Test
    @DisplayName("Teste o retorno de todos os Lotes armazenados")
    void testFindAll() {
        driver.save(lote);
        driver.save(loteAlternativo);

        List lista = new ArrayList<Lote>();
        lista.add(lote);
        lista.add(loteAlternativo);
        assertEquals(driver.findAll(), lista);
    }

    @Test
    @DisplayName("Teste: Atualizar um lote, com lista de lotes tamanho um.")
    void testUpdate() {
        driver.save(lote);
        driver.update(loteAlternativo);
        int pos = 0;
        Long n = Long.valueOf(pos);
        assertEquals(driver.findAll().size(), 1);
        assertEquals(driver.find(n), loteAlternativo);
    }

    @Test
    @DisplayName("Teste: Atualizar um lote, com lista de lotes tamanho dois ou mais.")
    void testUpdateLotesTamanhoMaiorQueDois() {
        driver.save(lote);
        driver.save(loteAlternativo);
        driver.update(loteAlternativo);
        // O método de atualizar está apagando todos os lotes e adicionando
        // apenas o lote recebido.
        assertEquals(driver.findAll().size(), 2);
    }

    @Test
    @DisplayName("Teste: Deletar um lote da coleção de lotes.")
    void testDelete() {
        driver.save(lote);
        driver.save(loteAlternativo);
        driver.delete(lote);
        // O método deveria apagar apenas o lote passado.
        assertEquals(1, driver.findAll().size());
    }

    @Test
    @DisplayName("Teste: Deletar todos os lotes na coleção")
    void testDeleteAll() {
        driver.save(lote);
        driver.save(loteAlternativo);
        driver.deleteAll();
        assertEquals(0, driver.findAll().size());
    }
}