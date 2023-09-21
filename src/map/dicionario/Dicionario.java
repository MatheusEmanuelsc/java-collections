package map.dicionario;

import util.VerificaMap;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String,String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionario.put(palavra,definicao);
    }

    public void removerPalavra(String palavra){
        VerificaMap.verifica(dicionario);
        dicionario.remove(palavra);
    }

    public void exibirPalavras(){
        VerificaMap.verifica(dicionario);
        System.out.println(dicionario);
    }

    public String  pesquisarPorPalavra(String palavra){
        VerificaMap.verifica(dicionario);
        String definicao = dicionario.get(palavra);
        return definicao;
    }

    public static void main(String[] args) {
        try {
            Dicionario dicionario = new Dicionario();

            // Adicionar palavras (linguagens de programação)
            dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
            dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
            dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

            // Exibir todas as palavras
            dicionario.exibirPalavras();

            // Pesquisar palavras
            String definicaoJava = dicionario.pesquisarPorPalavra("java");
            System.out.println("Definição da linguagem 'java': " + definicaoJava);

            String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
            System.out.println(definicaoCSharp);

            // Remover uma palavra
            dicionario.removerPalavra("typescript");
            dicionario.exibirPalavras();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
