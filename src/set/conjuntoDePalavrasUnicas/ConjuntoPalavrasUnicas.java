package set.conjuntoDePalavrasUnicas;

import util.VerificarLista;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> conjuntoPalavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.conjuntoPalavrasUnicas= new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        conjuntoPalavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra){
        VerificarLista.verifica(conjuntoPalavrasUnicas);
        conjuntoPalavrasUnicas.remove(palavra);
    }

    public boolean verificarPalavra(String palavra){
        VerificarLista.verifica(conjuntoPalavrasUnicas);
       return conjuntoPalavrasUnicas.contains(palavra);
    }

    public  void exibirPalavrasUnicas(){
        System.out.println(conjuntoPalavrasUnicas);
    }

    public static void main(String[] args) {
       try {
           // Criando uma instância da classe ConjuntoPalavrasUnicas
           ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

           // Adicionando linguagens únicas ao conjunto
           conjuntoLinguagens.adicionarPalavra("Java");
           conjuntoLinguagens.adicionarPalavra("Python");
           conjuntoLinguagens.adicionarPalavra("JavaScript");
           conjuntoLinguagens.adicionarPalavra("Python");
           conjuntoLinguagens.adicionarPalavra("C++");
           conjuntoLinguagens.adicionarPalavra("Ruby");

           // Exibindo as linguagens únicas no conjunto
           conjuntoLinguagens.exibirPalavrasUnicas();

           // Removendo uma linguagem do conjunto
           conjuntoLinguagens.removerPalavra("Python");
           conjuntoLinguagens.exibirPalavrasUnicas();

           // Removendo uma linguagem inexistente
           conjuntoLinguagens.removerPalavra("Swift");

           // Verificando se uma linguagem está no conjunto
           System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
           System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

           // Exibindo as linguagens únicas atualizadas no conjunto
           conjuntoLinguagens.exibirPalavrasUnicas();
       }catch (RuntimeException e){
           System.out.println(e.getMessage());
       }
    }
}
