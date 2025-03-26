package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import java.util.Collections;

public class ConsultaChatGPT {
    private static final String API_KEY = System.getenv("OPENAI_API_KEY");

    public static String obterResposta(String pergunta) {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("Chave da API não encontrada! Defina a variável de ambiente OPENAI_API_KEY.");
        }

        OpenAiService service = new OpenAiService(API_KEY);

        ChatCompletionRequest requisicao = ChatCompletionRequest.builder()
                .model("gpt-4o") // Modelo atualizado
                .messages(Collections.singletonList(new ChatMessage("user", pergunta)))
                .build();

        try {
            ChatCompletionResult resposta = service.createChatCompletion(requisicao);

            if (resposta.getChoices() == null || resposta.getChoices().isEmpty()) {
                return "Erro: Nenhuma resposta válida recebida do ChatGPT.";
            }

            return resposta.getChoices().get(0).getMessage().getContent().trim();
        } catch (Exception e) {
            return "Erro ao consultar ChatGPT: " + e.getMessage();
        }
    }

    public static String obterTraducao(String texto) {
        return obterResposta("Traduza para o português o seguinte texto: " + texto);
    }
}