package map.livrariaOnline;

import util.VerificaMap;

import java.util.*;

public class LivrariaOnline {

    Map<String,Livro> listaLivros;

    public LivrariaOnline() {
        this.listaLivros = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor,  double preco){
        listaLivros.put(link,new Livro(titulo,autor,preco));
    }

    public void removerLivro(String titulo) {
        VerificaMap.verifica(listaLivros);
        List<String> chavesRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : listaLivros.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
            }
        }
        for (String chave : chavesRemover) {
          listaLivros.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        VerificaMap.verifica(listaLivros);
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(listaLivros.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        VerificaMap.verifica(listaLivros);
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(listaLivros.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        VerificaMap.verifica(listaLivros);
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosPorAutor.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)) {
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro() {
        VerificaMap.verifica(listaLivros);
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

            for (Livro livro : listaLivros.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }


        for(Map.Entry<String, Livro> entry: listaLivros.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = listaLivros.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> obterLivroMaisBarato() {
        VerificaMap.verifica(listaLivros);
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;


            for (Livro livro : listaLivros.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }


        for(Map.Entry<String, Livro> entry: listaLivros.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo =listaLivros.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo);
            }
        }
        return livrosMaisBaratos;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("seilar","podeser","oxente",20d);
        livrariaOnline.adicionarLivro("numsei","eita","blabla",5d);
        livrariaOnline.adicionarLivro("vi não","borracha","tantofaz",20d);
        livrariaOnline.adicionarLivro("kkk","lapis","nem vi",20d);




        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.listaLivros);

    }
}
