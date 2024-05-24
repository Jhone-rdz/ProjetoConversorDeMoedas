package Serviços;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsumoApi {
    public static void buscaMoeda(String tipoDeMoedaInicial, String tipoDeMoedaFinal,
                           Scanner leitura)  {

        try{
        String endereco = "https://v6.exchangerate-api.com/v6/7b578d31dd27e7658ee3f5d3/latest/" + tipoDeMoedaFinal;


        URL url = new URL(endereco);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
        double taxaDeCambio = conversionRates.get(tipoDeMoedaFinal).getAsDouble();

        System.out.print("Digite o valor: ");
        double valor = leitura.nextDouble();

        double valorConvertido = valor * taxaDeCambio;

        System.out.println("----Resultado----");
        System.out.println(" --- " + valor + " --- " + tipoDeMoedaInicial + " Igual a " + valorConvertido + " " + tipoDeMoedaFinal);
        System.out.println("***********************************");
        System.out.println("\nPressione Enter para voltar ao menu principal...");
        leitura.nextLine();
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        System.exit(1);
    }
    }
}
