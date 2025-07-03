package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto) {
        String apiKey = System.getenv("OPENAI_APIKEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("⚠️ OPENAI_API_KEY não definida. Tradução será ignorada.");
            return texto;
        }

        try {
            OpenAiService service = new OpenAiService(apiKey);

            CompletionRequest requisicao = CompletionRequest.builder()
                    .model("text-davinci-003")
                    .prompt("Traduza para o português o texto: " + texto)
                    .maxTokens(1000)
                    .temperature(0.7)
                    .build();

            var resposta = service.createCompletion(requisicao);
            return resposta.getChoices().get(0).getText().trim();

        } catch (Exception e) {
            System.err.println("❌ Erro ao chamar a API da OpenAI: " + e.getMessage());
            return texto;
        }
    }
}
