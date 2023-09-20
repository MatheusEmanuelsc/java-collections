package lista.OrdenacaoPessoas;

import util.VerificarLista;

import java.util.*;

public class OrdenacaoPessoas {

    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        VerificarLista.verifica(listaPessoas);
        List<Pessoa> pessoaPorIdade = new ArrayList<>(listaPessoas);

        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;

    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> listaDePessoasPorAltura = new ArrayList<>(listaPessoas);
        Collections.sort(listaDePessoasPorAltura, new ComparandoPorAltura());
        return listaDePessoasPorAltura;
    }

    public static void main(String[] args) {
        try {
            // Criando uma instância da classe OrdenacaoPessoas
            OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

            // Adicionando pessoas à lista
            ordenacaoPessoas.adicionarPessoa("Alice", 20, 1.56);
            ordenacaoPessoas.adicionarPessoa("Bob", 30, 1.80);
            ordenacaoPessoas.adicionarPessoa("Charlie", 25, 1.70);
            ordenacaoPessoas.adicionarPessoa("David", 17, 1.56);


            // Ordenando e exibindo por idade
            System.out.println(ordenacaoPessoas.ordenarPorIdade());

            // Ordenando e exibindo por altura
            System.out.println(ordenacaoPessoas.ordenarPorAltura());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ComparandoPorAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return Double.compare(o1.getAltura(), o2.getAltura());
    }
}
