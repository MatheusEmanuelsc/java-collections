package map.contagemPalavras;

import util.VerificaMap;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String,Integer>contagemPalavras;

    public ContagemPalavras() {
        this.contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        contagemPalavras.put(palavra,contagem);
    }

    public void removerPalavra(String palavra){
        VerificaMap.verifica(contagemPalavras);
        contagemPalavras.remove(palavra);
    }

    public int exibirContagemPalavras(){
        VerificaMap.verifica(contagemPalavras);
        int contagemTotal = 0;
        for (int contagem : contagemPalavras.values()) {
            contagemTotal += contagem;
        }
        return contagemTotal;
    }

    public String encontrarPalavrasMaisFrequente() {
        String linguagemMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        return linguagemMaisFrequente;
    }

    public static void main(String[] args) {
        try {
            ContagemPalavras contagemLinguagens = new ContagemPalavras();

            // Adiciona linguagens e suas contagens
            contagemLinguagens.adicionarPalavras("Java", 2);
            contagemLinguagens.adicionarPalavras("Python", 8);
            contagemLinguagens.adicionarPalavras("JavaScript", 1);
            contagemLinguagens.adicionarPalavras("C#", 6);

            // Exibe a contagem total de linguagens
            System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

            // Encontra e exibe a linguagem mais frequente
            String linguagemMaisFrequente = contagemLinguagens.encontrarPalavrasMaisFrequente();
            System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }


}
