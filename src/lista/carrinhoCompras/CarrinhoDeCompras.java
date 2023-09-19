package lista.carrinhoCompras;

import util.VerificarLista;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeCompra;

    public CarrinhoDeCompras() {
        this.listaDeCompra = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaDeCompra.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome){
        VerificarLista.verifica(listaDeCompra);
        List<Item>listaDeItensParaRemover= new ArrayList<>();
        for (Item item : listaDeCompra){
            if (item.getNome().equalsIgnoreCase(nome)){
                listaDeItensParaRemover.add(item);
            }
        }
        listaDeCompra.removeAll(listaDeItensParaRemover);
    }

    private double valorTotalItem(Item item){
        return item.getPreco()*item.getQuantidade();
    }
    public double calcularValorTotal(){
        VerificarLista.verifica(listaDeCompra);
        double total=0;

        for (Item item : listaDeCompra){
            total += valorTotalItem(item);
        }
        return total;
    }

    public void exibirItens(){

        VerificarLista.verifica(listaDeCompra);
        System.out.println(listaDeCompra);
    }

    public static void main(String[] args) {
        try {
            CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

            carrinhoDeCompras.adicionarItem("tablet", 500.0, 2);
            carrinhoDeCompras.adicionarItem("kindle", 150.0, 5);
            carrinhoDeCompras.adicionarItem("celular", 1000d, 5);
            carrinhoDeCompras.adicionarItem("fone", 50d, 2);

            carrinhoDeCompras.exibirItens();

            carrinhoDeCompras.removerItem("celular");

            carrinhoDeCompras.exibirItens();

            System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
        }catch (RuntimeException  e){
            System.out.println(e.getMessage());
        }

    }


}
