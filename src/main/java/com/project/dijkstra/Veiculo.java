package com.project.dijkstra;

import com.project.dijkstra.No;

import java.util.ArrayList;

public class Veiculo {

    private String tipo;
    private double distancia = getDistancia();
    private double consumoTotal;

    public static void selecionarVeiculo(Veiculo veiculo, No pontoOrigem, No pontoDestino) {

        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();

        Veiculo motocicleta = new Veiculo("Motocicleta");
        Veiculo carro = new Veiculo("Carro");
        Veiculo microonibus = new Veiculo("Micro-Onibus");
        Veiculo onibus = new Veiculo("Onibus");
        Veiculo caminhao = new Veiculo("Caminhão");

        switch (veiculo.getTipo().toLowerCase()) {
            case "motocicleta":
                calcularConsumoMotocicleta(veiculo, pontoOrigem, pontoDestino);
                break;
            case "carro":
                calcularConsumoCarro(veiculo, pontoOrigem, pontoDestino);
                break;
            case "microonibus":
                calcularConsumoMicroonibus(veiculo, pontoOrigem, pontoDestino);
                break;
            case "onibus":
                calcularConsumoOnibus(veiculo, pontoOrigem, pontoDestino);
                break;
            case "caminhao":
                calcularConsumoCaminhao(veiculo, pontoOrigem, pontoDestino);
                break;
            default:
                System.out.println("Tipo de veículo não reconhecido.");
                break;
        }
        
    }

    private static void calcularConsumoCaminhao(Veiculo veiculo, No pontoOrigem, No pontoDestino) {
    }

    private static void calcularConsumoOnibus(Veiculo veiculo, No pontoOrigem, No pontoDestino) {
    }

    private static void calcularConsumoMicroonibus(Veiculo veiculo, No pontoOrigem, No pontoDestino) {
    }

    private static void calcularConsumoCarro(Veiculo veiculo, No pontoOrigem, No pontoDestino) {
    }

    private static void calcularConsumoMotocicleta(Veiculo veiculo, No pontoOrigem, No pontoDestino) {
        double distancia = veiculo.getDistancia();
        double consumoMedio = 0.0; // substituir

        if (distancia > 0.0) {
            double consumoTotal = distancia / consumoMedio;
        } else {
            System.out.println("Algo deu errado.");
        }
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return getDistancia();
    }

    public Veiculo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
