package com.ufcg.psoft.mercadofacil.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import com.ufcg.psoft.mercadofacil.service.ProdutoAlterarPadraoService;
import com.ufcg.psoft.mercadofacil.service.ProdutoAlterarService;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de Produtos")
public class ProdutoV1ControllerTests {
    @Autowired
    MockMvc driver;

    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    Produto produto;
    Produto prod_2;
    Produto prod_3;

    @BeforeEach
    void setup() {
        produto = produtoRepository.find(10L);
        prod_2 = produtoRepository.find(5L);
        prod_3 = produtoRepository.find(6L);
    }

    @AfterEach
    void tearDown() {
        produto = null;
    }

    @Nested
    @DisplayName("Conjunto de casos de verificação de campos obrigatórios")
    class ProdutoValidacaoCamposObrigatorios {

        @Test
        @DisplayName("Quando alteramos o nome do produto com dados válidos")
        void quandoAlteramosNomeDoProdutoValido() throws Exception {
            // Arrange
            produto.setNome("Produto Dez Alterado");

            // Act
            String responseJsonString = driver.perform(put("/v1/produtos/" + produto.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(produto)))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Produto resultado = objectMapper.readValue(responseJsonString, Produto.ProdutoBuilder.class).build();

            // Assert
            assertEquals(resultado.getNome(), "Produto Dez Alterado");
        }

    }

    @Nested
    @DisplayName("Conjunto de casos de verificação da regra sobre o preço")
    class ProdutoValidacaoRegrasDoPreco {
        @Test
        @DisplayName("Quando alteramos o preço do produto com dados válidos")
        void alteraPrecoValido() throws Exception {
            // Arrange
            produto.setPreco(232.20);
            String responseJsonString = driver.perform(put("/v1/produtos/" + produto.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(produto)))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            //Act
            Produto resultado = objectMapper.readValue(responseJsonString, Produto.ProdutoBuilder.class).build();

            // Assert
            assertEquals( 232.20, resultado.getPreco());
        }

        @Test
        @DisplayName("Quando alteramos o preço menor ou igual a zero do produto com dados inválidos")
        void alteraPrecoInvalido() throws Exception {
            // Arrange
            prod_2.setPreco(0.00);

            //Act
            ServletException thrown = assertThrows( ServletException.class,
                    () -> driver.perform(put("/v1/produtos/" + prod_2.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(prod_2)))
                            .andExpect(status().isBadRequest())
            );

            //Assert
            assertTrue(thrown.getMessage().contains("Preco invalido!"));
        }
    }

    @Nested
    @DisplayName("Conjunto de casos de verificação da validação do código de barras")
    class ProdutoValidacaoCodigoDeBarras {
        @Test
        @DisplayName("Quando alteramos o código de barras com dados válidos")
        void alteraCodBarroDadosValidos() throws Exception {
            //Arrange
            produto.setCodigoBarra("7898357417892");
            String responseJsonString = driver.perform(put("/v1/produtos/" + produto.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(produto)))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            //Act
            Produto resultado = objectMapper.readValue(responseJsonString, Produto.ProdutoBuilder.class).build();

            //Assert
            assertEquals("7898357417892", resultado.getCodigoBarra());
        }

        @Test
        @DisplayName("Quando alteramos o código de barras com dados inválidos")
        void alteraCodBarroDadosInvalidos() throws Exception {
            //Arrange
            prod_3.setCodigoBarra("7898357417890");

            //Act
            ServletException thrown = assertThrows( ServletException.class,
                    () -> driver.perform(put("/v1/produtos/" + prod_3.getId())
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(prod_3)))
                            .andExpect(status().isBadRequest())
            );

            //Assert
            assertTrue(thrown.getMessage().contains("Código de Barras Inválido!"));
        }
    }

}
