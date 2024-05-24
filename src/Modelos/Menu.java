package Modelos;

import Serviços.ConsumoApi;

import java.util.Scanner;

public class Menu {
    public void exibir() {
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("*********************************");
            System.out.println("Bem Vindo ao conversor de Moedas, Por favor escolha uma opção abaixo ");
            System.out.println("(1) - BRL (real Brasileiro) para USD (Dólar)");
            System.out.println("(2) - EUR (Euro) para CAD (Dólar Canadense)");
            System.out.println("(3) - ARS (Peso Argentino) GBP para (Libra esterlina)");
            System.out.println("(4) - COP (Peso Colombiano) para GHS (Cedi ganês)");
            System.out.println("(5) - EGP (Libra egípcia) para AUD (Dólar Australiano)");
            System.out.println("(6) - KRW (Won sul-coreano) para FJD (Dólar Fiji)");
            System.out.println("(7) - Digitar moeda de origem, destino e valor");
            System.out.println("(8) - Sair ");
            System.out.println("*********************************");

            System.out.print("Escolha uma opção válida: ");
            opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    ConsumoApi.buscaMoeda("BRL", "USD", leitura);
                    break;
                case 2:
                    ConsumoApi.buscaMoeda("EUR", "CAD", leitura);
                    break;
                case 3:
                    ConsumoApi.buscaMoeda("ARS", "GBP", leitura);
                    break;
                case 4:
                    ConsumoApi.buscaMoeda("COP", "GHS", leitura);
                    break;
                case 5:
                    ConsumoApi.buscaMoeda("EGP", "AUD", leitura);
                    break;
                case 6:
                    ConsumoApi.buscaMoeda("KRW", "FJD", leitura);
                    break;
                case 7:
                    System.out.println("Digite a abreviação da moeda");
                    System.out.println("Moedas --> USD, BRL, EUR, JPY...");
                    System.out.println("Digite a moeda de origem: ");
                    String tipoDeMoedaInicial = leitura.next().toUpperCase();
                    System.out.print("Digite a moeda de destino: ");
                    String tipoDeMoedaFinal = leitura.next().toUpperCase();
                    ConsumoApi.buscaMoeda(tipoDeMoedaInicial, tipoDeMoedaFinal, leitura);
                    break;
                case 8:
                    System.out.println("Fechando o aplicativo");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    System.out.println("Enter para voltar ao menu principal");
                    leitura.nextLine();
            }
        } while (opcao != 8);
        leitura.close();
    }


}
