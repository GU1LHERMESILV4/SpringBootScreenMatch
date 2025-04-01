package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.service.SerieService;
import br.com.alura.screenmatch.service.traducao.TranslationService;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumo = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final SerieService serieService;
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=918ea8e";
    private final List<DadosSerie> dadosSeries = new ArrayList<>();

    // 🔹 Agora recebe SerieService no construtor
    public Principal(SerieService serieService) {
        this.serieService = serieService;
    }

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            String menu = """
                1 - Buscar séries
                2 - Buscar episódios
                3 - Listar séries buscadas
                
                0 - Sair                                 
                """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas(); // 🔹 Agora o método não precisa de parâmetro
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        dadosSeries.add(dados);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca:");
        String nomeSerie = leitura.nextLine();
        String json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        return conversor.obterDados(json, DadosSerie.class);
    }

    private void buscarEpisodioPorSerie() {
        DadosSerie dadosSerie = getDadosSerie();
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumo.obterDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }

    private void listarSeriesBuscadas() {
        List<Serie> series = dadosSeries.stream()
                .map(serieService::criarSerie) // 🔹 Usando SerieService para criar Series corretamente
                .collect(Collectors.toList());

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        TranslationService translationService = new TranslationService();
        SerieService serieService = new SerieService(translationService);
        Principal principal = new Principal(serieService);
        principal.exibeMenu();
    }

}
