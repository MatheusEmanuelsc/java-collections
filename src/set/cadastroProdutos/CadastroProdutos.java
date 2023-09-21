package set.cadastroProdutos;

import util.VerificarLista;

import java.util.*;

public class CadastroProdutos {
    private Set<Produto> listaProdutos;

    public CadastroProdutos() {
        this.listaProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        listaProdutos.add(new Produto( nome,  preco,  quantidade, cod));
    }

    public Set<Produto>exibirProdutosPorNome(){
        VerificarLista.verifica(listaProdutos);
        Set<Produto> listaOrdenadaPorNome= new TreeSet<>(listaProdutos);

        return listaOrdenadaPorNome;
    }

    public Set<Produto>exibirProdutosPorPreco(){
        Set<Produto>ordenandoProPreco= new TreeSet<>(new OrdenandoPorPreco());
         ordenandoProPreco.addAll(listaProdutos);
         return ordenandoProPreco;
    }

    public static void main(String[] args) {
        try {
            CadastroProdutos cadastroProdutos = new CadastroProdutos();

            // Adicionando produtos ao cadastro
            cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
            cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
            cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
            cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

           

            // Exibindo produtos ordenados por nome
            System.out.println(cadastroProdutos.exibirProdutosPorNome());

            // Exibindo produtos ordenados por preço
            System.out.println(cadastroProdutos.exibirProdutosPorPreco());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}



