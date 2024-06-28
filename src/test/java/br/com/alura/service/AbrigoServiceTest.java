package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private AbrigoService abrigoService = new AbrigoService(client);
    private Abrigo abrigo = new Abrigo("Teste", "123456789", "abrigo_alura@gmail.com");

    @Test
    public void deveVerificarSeDisparaRequisicaoGetSeraChamado() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigoCadastrados = "Abrigos cadastrados:";
        String expectedIdNome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        abrigoService.listarAbrigos();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastros = lines[0];
        String actualIdNome = lines[1];

        assertEquals(expectedAbrigoCadastrados, actualAbrigosCadastros);
        assertEquals(expectedIdNome, actualIdNome);
    }
}
