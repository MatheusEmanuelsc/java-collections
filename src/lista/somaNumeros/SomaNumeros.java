package lista.somaNumeros;

import util.VerificarLista;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros =  new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        VerificarLista.verifica(numeros);
        int somaNumeros=0;
        for (Integer numero : numeros){
            somaNumeros+=numero;
        }

        return somaNumeros;
    }

    public  int encontrarMaiorNumero(){
        VerificarLista.verifica(numeros);
        int maiorNumero=Integer.MIN_VALUE;
        for (Integer numero : numeros){
            if (maiorNumero<numero){
                maiorNumero=numero;
            }
        }
        return maiorNumero;
    }

    public  int encontrarMenorNumero(){
        VerificarLista.verifica(numeros);
        int menorNumero= Integer.MAX_VALUE;

        for (Integer numero : numeros){
            if (menorNumero>numero){
                menorNumero=numero;
            }
        }
        return menorNumero;

    }

    public List  exibirNumeros(){
        VerificarLista.verifica(numeros);
        return numeros;
    }

    public static void main(String[] args) {
        // Criando uma instância da classe SomaNumeros
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando números à lista
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        // Exibindo a lista de números adicionados
        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        // Calculando e exibindo a soma dos números na lista
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        // Encontrando e exibindo o maior número na lista
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        // Encontrando e exibindo o menor número na lista
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
