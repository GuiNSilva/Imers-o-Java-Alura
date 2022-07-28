import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");

        //Criar um conexão http para buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build(); 
        HttpResponse<String> response =client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //Buscar informções relevantes(título, poster,classificação)

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
       // System.out.println(listaDeFilmes.size()); 
        //System.out.println(listaDeFilmes.get(0));


        //Exibir e manipular os dados de acordo com a necessidade.
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));


            
        }
    
    
    }
}
