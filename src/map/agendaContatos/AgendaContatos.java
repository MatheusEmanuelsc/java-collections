package map.agendaContatos;

import set.agendaContatos.Contato;
import util.VerificaMap;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    Map<String,Integer>agendaContatos;

    public AgendaContatos( ){
        this.agendaContatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatos.put(nome,telefone);
    }

    public void removerContato(String nome){
        VerificaMap.verifica(agendaContatos);
        agendaContatos.remove(nome);
    }

    public void exibirContatos(){
        VerificaMap.verifica(agendaContatos);
        System.out.println(agendaContatos);
    }

    public Integer pesquisarPorNome(String nome){
      VerificaMap.verifica(agendaContatos);
      Integer numero= agendaContatos.get(nome);
      return numero;
    }

    public static void main(String[] args) {
        try {

            AgendaContatos agendaContatos = new AgendaContatos();

            // Adicionar contatos
            agendaContatos.adicionarContato("Camila", 123456);
            agendaContatos.adicionarContato("João", 5665);
            agendaContatos.adicionarContato("Carlos", 1111111);
            agendaContatos.adicionarContato("Ana", 654987);
            agendaContatos.adicionarContato("Maria", 1111111);
            agendaContatos.adicionarContato("Camila", 44444);

            agendaContatos.exibirContatos();

            // Remover um contato
            agendaContatos.removerContato("Maria");
            agendaContatos.exibirContatos();

            // Pesquisar número por nome
            String nomePesquisa = "João";
            Integer numeroPesquisa = agendaContatos.pesquisarPorNome("João");
            System.out.println("Número de telefone de " + nomePesquisa + ": " + numeroPesquisa);

            String nomePesquisaNaoExistente = "Paula";
            Integer numeroPesquisaNaoExistente = agendaContatos.pesquisarPorNome(nomePesquisaNaoExistente);
            System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
