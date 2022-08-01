import java.io.InputStream;
import java.net.URL;
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
        ExtratorDeConteudo extrator = new ExtratorConteudoImdb();
        
        
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudo extrator = new ExtratorConteudoNasa();
       
       
       
        var http = new ClienteHttp();
        String json =   http.buscaDados(url);
       

        //Buscar informções relevantes(título, poster,classificação)

      
       // System.out.println(listaDeFilmes.size()); 
        //System.out.println(listaDeFilmes.get(0));


        //Exibir e manipular os dados de acordo com a necessidade.
       
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
       
        var stickMoviesGenerator = new stickMoviesGenerator();
        
        
        for (int i  = 0 ;i <3; i++) {

            Conteudo conteudo = conteudos.get(i);

 
           
           
           
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";


            stickMoviesGenerator.cria(inputStream, nomeArquivo);


            System.out.println(conteudo.getTitulo());
            System.out.println();


            
        }
    
    
    }
}
