package br.com.alura.screenmatch.testes;

import br.com.alura.screenmatch.service.traducao.TranslationService;

public class TesteTraducao {
    public static void main(String[] args) {
        TranslationService translationService = new TranslationService();
        String textoOriginal = "This is a test sentence.";
        String traduzido = translationService.translate(textoOriginal);
        System.out.println("Texto traduzido: " + traduzido);
    }
}
