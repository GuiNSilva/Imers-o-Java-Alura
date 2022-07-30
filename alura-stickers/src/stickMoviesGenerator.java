import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickMoviesGenerator {
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException{
        //ler imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/imagemMaior.jpg"));
        //InputStream inputStream =
        //                new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
        BufferedImage ImagemOriginal= ImageIO.read( inputStream );

        //nova imagem em memoria com transparencia e tamanho ajustado
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);
         
        //copiar imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.createGraphics(); 
        graphics.drawImage(ImagemOriginal, 0, 0, null);
        
      
        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,  64);
        graphics.setFont(fonte);
        graphics.setColor(Color.yellow);

        //escrever um frase na nova imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);


        //gravar a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

   
    
}
