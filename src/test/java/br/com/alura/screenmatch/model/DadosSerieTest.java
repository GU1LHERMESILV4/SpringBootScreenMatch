package br.com.alura.screenmatch.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class DadosSerieTest {

    @Test
    public void testDesserializacaoJson() throws Exception {
        String json = """
            {
              "Title": "Breaking Bad",
              "totalSeasons": 5,
              "imdbRating": "9.5",
              "Genre": "Crime, Drama, Thriller",
              "Actors": "Bryan Cranston, Aaron Paul, Anna Gunn",
              "Poster": "some_url",
              "Plot": "A high school chemistry teacher..."
            }
        """;

        ObjectMapper mapper = new ObjectMapper();
        DadosSerie dadosSerie = mapper.readValue(json, DadosSerie.class);

        assertEquals("Breaking Bad", dadosSerie.titulo());
        assertEquals(5, dadosSerie.totalTemporadas());
        assertEquals("9.5", dadosSerie.avaliacao());
        assertEquals("Crime, Drama, Thriller", dadosSerie.genero());
        assertEquals("Bryan Cranston, Aaron Paul, Anna Gunn", dadosSerie.atores());
        assertEquals("some_url", dadosSerie.poster());
        assertEquals("A high school chemistry teacher...", dadosSerie.sinopse());
    }
}
