package br.com.farmtech.productmanager.controller;

import br.com.farmtech.productmanager.domain.DadosAtualizacaoProduto;
import br.com.farmtech.productmanager.domain.DadosCadastroProduto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroProduto> dadosCadastroProdutoJson;

    @Autowired
    private JacksonTester<DadosAtualizacaoProduto> dadosAtualizacaoProdutoJson;

    @Test
    @DisplayName("Deveria devolver codigo http 400 no cadastro quando informacoes estao invalidas")
    void cadastrarProdutoInvalido() throws Exception {
        var response = mvc.perform(post("/produtos")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 no cadastro quando o nome for menor que o minimo")
    void cadastrarProdutoNomeInvalido() throws Exception {
        var response = mvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroProdutoJson.write(
                        new DadosCadastroProduto("Sa", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 no cadastro quando o nome vazio")
    void cadastrarProdutoNomeNulo() throws Exception {
        var response = mvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroProdutoJson.write(
                        new DadosCadastroProduto("", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 no cadastro quando nome duplicado")
    void cadastrarProdutoNomeDuplicado() throws Exception {
        var response = mvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroProdutoJson.write(
                        new DadosCadastroProduto("Frigideira", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 no cadastro quando status invalido")
    void cadastrarProdutoStatusInvalido() throws Exception {
        var response = mvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroProdutoJson.write(
                        new DadosCadastroProduto("Frigideira", "tivo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 no cadastro quando estiver tudo correto")
    void cadastrarProdutoValido() throws Exception {
        var response = mvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroProdutoJson.write(
                        new DadosCadastroProduto("Panela de Inox", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 ao editar quando nome duplicado")
    void alterarProdutoNomeDuplicado() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(101L, "Frigideira", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 ao editar quando nome menor que o minimo")
    void alterarProdutoNomeMenorMinimo() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(101L, "Fa", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 ao editar quando nome invalido")
    void alterarProdutoNomeInvalido() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(101L, "", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 ao editar quando id nulo")
    void alterarProdutoIdNulo() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(null, "Frigideira", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 404 ao editar quando id invalido")
    void alterarProdutoIdInvalido() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(10L, "Frigideira", "ativo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 ao editar quando status invalido")
    void alterarProdutoStatusInvalido() throws Exception {
        var response = mvc.perform(put("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosAtualizacaoProdutoJson.write(
                        new DadosAtualizacaoProduto(100L, "Frigideira", "tivo")
                ).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

}
