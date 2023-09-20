package set.agendaContatos;

import util.VerificarLista;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> agendaContatos;

    public AgendaContatos() {
        this.agendaContatos = new HashSet<>();
    }

    public  void adicionarContato(String nome, int numero){
        agendaContatos.add( new Contato(nome,numero));
    }

    public void exibirContatos(){
        VerificarLista.verifica(agendaContatos);
        System.out.println(agendaContatos);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        VerificarLista.verifica(agendaContatos);

        Set<Contato>conjutoContatosPorNome=new HashSet<>();

        for (Contato contato: agendaContatos){
            if (contato.getNome().startsWith(nome)){
                conjutoContatosPorNome.add(contato);
            }
        }
        return  conjutoContatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        VerificarLista.verifica(agendaContatos);
        Contato contatoAtualizado=null;
        for (Contato contato : agendaContatos){
            if (contato.getNome().equalsIgnoreCase(nome)){
                contato.setNumero(novoNumero);
                contatoAtualizado=contato;
                break;

            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
     try {
         // Criando uma instância da classe AgendaContatos
         AgendaContatos agendaContatos = new AgendaContatos();

         // Exibindo os contatos no conjunto (deve estar vazio)
//         agendaContatos.exibirContatos();

         // Adicionando contatos à agenda
         agendaContatos.adicionarContato("João", 123456789);
         agendaContatos.adicionarContato("Maria", 987654321);
         agendaContatos.adicionarContato("Maria Fernandes", 55555555);
         agendaContatos.adicionarContato("Ana", 88889999);
         agendaContatos.adicionarContato("Fernando", 77778888);
         agendaContatos.adicionarContato("Carolina", 55555555);

         // Exibindo os contatos na agenda
         agendaContatos.exibirContatos();

         // Pesquisando contatos pelo nome
         System.out.println(agendaContatos.pesquisarPorNome("Maria"));

         // Atualizando o número de um contato
         Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina", 44443333);
         System.out.println("Contato atualizado: " + contatoAtualizado);

         // Exibindo os contatos atualizados na agenda
         System.out.println("Contatos na agenda após atualização:");
         agendaContatos.exibirContatos();
     }catch (RuntimeException e){
         System.out.println(e.getMessage());
     }
    }
}
