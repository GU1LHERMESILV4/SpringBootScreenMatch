package br.com.alura.screenmatch.service.traducao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {
    private static final String TRANSLATE_API_URL = "https://libretranslate.de/translate";

    public String translate(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("q", text);
        requestBody.put("source", "en");
        requestBody.put("target", "pt");
        requestBody.put("format", "text");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                TRANSLATE_API_URL, HttpMethod.POST, request, Map.class
        );

        Map<String, Object> responseBody = response.getBody();
        return responseBody != null ? responseBody.get("translatedText").toString() : "Erro na tradução";
    }
}
