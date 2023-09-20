package set.conjutoConvidados;

import util.VerificarLista;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> conjuntoConvidados;

    public ConjuntoConvidados() {
        this.conjuntoConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        conjuntoConvidados.add(new Convidado(nome,codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        VerificarLista.verifica(conjuntoConvidados);
        Convidado convidadoASerRemovido=null;
        for(Convidado convidado : conjuntoConvidados){
            if (convidado.getCodigoConvite()==codigoConvite){
                convidadoASerRemovido=convidado;
                break;
            }

        }
        conjuntoConvidados.remove(convidadoASerRemovido);
    }

    public int contarConvidados(){
        VerificarLista.verifica(conjuntoConvidados);
        return  conjuntoConvidados.size();
    }

    public Set<Convidado> exibirConvidados(){
        VerificarLista.verifica(conjuntoConvidados);
        return conjuntoConvidados;
    }

    public static void main(String[] args) {
       try {
           // Criando uma instância da classe ConjuntoConvidados
           ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

           // Exibindo o número de convidados no conjunto (deve ser zero)
//           System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

           // Adicionando convidados ao conjunto
           conjuntoConvidados.adicionarConvidado("Alice", 1234);
           conjuntoConvidados.adicionarConvidado("Bob", 1235);
           conjuntoConvidados.adicionarConvidado("Charlie", 1235);
           conjuntoConvidados.adicionarConvidado("David", 1236);

           // Exibindo os convidados no conjunto
           System.out.println("Convidados no conjunto:");
           conjuntoConvidados.exibirConvidados();

           // Exibindo o número atualizado de convidados no conjunto
           System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

           // Removendo um convidado do conjunto por código de convite
           conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
           System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");

           // Exibindo os convidados atualizados no conjunto
           System.out.println("Convidados no conjunto após a remoção:");
           conjuntoConvidados.exibirConvidados();
       }catch (RuntimeException e){
           System.out.println(e.getMessage());
       }
    }
}
