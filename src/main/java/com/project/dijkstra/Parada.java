package com.project.dijkstra;

public class Parada {
    
    public static double calcularCustoParadas(int numeroDeParadas) {
        double custoSemParadas = 0.0;
        double custoPorParada = 30.0;

        switch (numeroDeParadas) {
            case 0:
                return custoSemParadas;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return custoSemParadas + numeroDeParadas * custoPorParada;
            default:
                System.out.println("erro");
                return -1; //valor negativo indica um erro
        }

    }


}
