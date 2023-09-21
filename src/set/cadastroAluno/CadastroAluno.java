package set.cadastroAluno;

import util.VerificarLista;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroAluno {

    private Set<Aluno>listaAluno;

    public CadastroAluno() {
        this.listaAluno = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        listaAluno.add(new Aluno(nome,matricula,media));
    }

    public void removerAluno(long matricula){
        VerificarLista.verifica(listaAluno);

        for(Aluno aluno:listaAluno){
            if (aluno.getMatricula()==matricula){
                listaAluno.remove(aluno);
                break;
            }
        }
    }

    public Set<Aluno>exibirAlunosPorNome(){
        VerificarLista.verifica(listaAluno);

        Set<Aluno>listaOrdenadaPorNome=new TreeSet<>(listaAluno);
        return listaOrdenadaPorNome;
    }

    public Set<Aluno>exibirAlunosPorNota(){
        VerificarLista.verifica(listaAluno);

        Set<Aluno>listaOrdenadaPorNota=new TreeSet<>(new OrdenandoPorNota());
        listaOrdenadaPorNota.addAll(listaAluno);
        return listaOrdenadaPorNota;
    }

    public void exibirAlunos(){
        VerificarLista.verifica(listaAluno);
        System.out.println(listaAluno);
    }

    public static void main(String[] args) {
        try {
            // Criando uma instância do GerenciadorAlunos
            CadastroAluno gerenciadorAlunos = new CadastroAluno();
            // Adicionando alunos ao gerenciador
            gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
            gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
            gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
            gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

            // Exibindo todos os alunos no gerenciador
            System.out.println("Alunos no gerenciador:");
            gerenciadorAlunos.exibirAlunos();

            // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
            gerenciadorAlunos.removerAluno(000L);
            gerenciadorAlunos.removerAluno(123457L);
            gerenciadorAlunos.exibirAlunos();

            // Exibindo alunos ordenados por nome

            System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
            // Exibindo alunos ordenados por nota
            System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
