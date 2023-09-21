package map.estoqueProduto;

import util.VerificaMap;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map <Long,Produto>estoqueProduto;

    public EstoqueProdutos() {
        this.estoqueProduto =  new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProduto.put(cod,new Produto(nome,preco,quantidade));
    }

    public void exibirProdutos(){
        VerificaMap.verifica(estoqueProduto);
        System.out.println(estoqueProduto);
    }

    public double calcularValorTotalEstoque(){
        VerificaMap.verifica(estoqueProduto);
        double totalEstoque = 0;

        for (Produto prod : estoqueProduto.values()){
            totalEstoque += prod.getPreco()*prod.getQuantidade();
        }
        return totalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        VerificaMap.verifica(estoqueProduto);
        Produto produtoMaisCaro=null;
        double maiorPreco=Double.MIN_VALUE;

        for (Produto prod: estoqueProduto.values()){
            if (prod.getPreco()>maiorPreco){
                maiorPreco=prod.getPreco();
                produtoMaisCaro=prod;
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        try {
            EstoqueProdutos estoque = new EstoqueProdutos();

            // Exibe o estoque vazio
//            estoque.exibirProdutos();

            // Adiciona produtos ao estoque
            estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
            estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
            estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
            estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

            // Exibe os produtos no estoque
            estoque.exibirProdutos();

            // Calcula e exibe o valor total do estoque
            System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

            // Obtém e exibe o produto mais caro
            Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
            System.out.println("Produto mais caro: " + produtoMaisCaro);


        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
