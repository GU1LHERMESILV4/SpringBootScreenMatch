package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaChatGPT {

    // Carrega o arquivo .env
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("OPENAI_API_KEY");

    public static String obterTraducao(String texto) {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("Chave da API não encontrada! Verifique o arquivo .env.");
        } else {
            System.out.println("Variável de ambiente encontrada! Primeiros caracteres da chave: " + API_KEY.substring(0, 5) + "...");
        }

        OpenAiService service = new OpenAiService(API_KEY);

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-4o")
                .prompt("Traduza para o português o seguinte texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText().trim();
    }
}
