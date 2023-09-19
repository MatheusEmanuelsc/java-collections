package lista.catalogoLivros;

import util.VerificarLista;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogoDeLivros;

    public CatalogoLivros() {
        catalogoDeLivros= new ArrayList<>();
    }


    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
            catalogoDeLivros.add(new Livro(titulo,autor,anoPublicacao));
    }

    public void pesquisarPorAutor(String autor){


        VerificarLista.verifica(catalogoDeLivros);
        List <Livro> listaDeLivroAutor= new ArrayList<>();
            for (Livro livro : catalogoDeLivros){
                if (livro.getAutor().equalsIgnoreCase(autor)){
                    listaDeLivroAutor.add(livro);
                }else{
                    System.out.println("Autor não encontrado");
                }

            System.out.println(listaDeLivroAutor);
        }


    }


}
