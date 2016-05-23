/**
 * Created by ricardoramos on 5/22/16.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;
import static sun.plugin.javascript.navig.JSType.Document;

public class main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriba una direccion web (no olvides especificar http o https): ");
        String url = scanner.next();

        scanner.close();
        Document document = Jsoup.connect(url).get();
        String [] lines = document.html().split("\n");
        System.out.println("a) Cantidad de lineas: "+ lines.length);
        Elements paragrahs = document.select("p");
        System.out.print("b) Cantidad de etiquetas P: ");
        System.out.println(paragrahs.size());

        Elements images = document.select("img");
        System.out.print("c) Cantidad de etiquetas img: ");
        System.out.println(images.size());

        Elements forms = document.select("form");
        System.out.print("d) Cantidad de etiquetas form: ");
        System.out.println(forms.size());

        for (Element form : forms){
            Elements inputs = form.select("input");
            System.out.println("e) Formulario:  ");
            System.out.println(form.text());
            for(Element input : inputs){
                String type = input.attr("type");
                System.out.println("Campo: " + input+"\n\tTipo: " + type );
            }
        }
    }

}