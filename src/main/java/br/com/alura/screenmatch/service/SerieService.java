package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.traducao.TranslationService;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
    private final TranslationService translationService;

    public SerieService(TranslationService translationService) {
        this.translationService = translationService;
    }

    public Serie criarSerie(DadosSerie dadosSerie) {
        // Traduzindo a sinopse antes de criar a Série
        String sinopseTraduzida = translationService.translate(dadosSerie.sinopse());
        return new Serie(dadosSerie, sinopseTraduzida);
    }
}
