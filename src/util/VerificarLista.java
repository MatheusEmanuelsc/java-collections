package util;

import java.util.Collection;
import java.util.List;

public class VerificarLista {

    public static void verifica(Collection colecao){
        if (colecao.isEmpty()){
            throw new RuntimeException("lista vazia");
        }

    }
}
