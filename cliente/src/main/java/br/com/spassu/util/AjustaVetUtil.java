package br.com.spassu.util;

import java.util.Arrays;

public class AjustaVetUtil {

	public int[] ajustaVet(int[] original) {
		
	     // remover repetidos
        int[ ] unicos = new int[ original.length ];
        int qtd = 0;
        for( int i = 0 ; i < original.length ; i++ ) {
            boolean existe = false;
            for( int j = 0 ; j < qtd ; j++ ) {
                if( unicos[ j ] == original[ i ] ) {
                    existe = true;
                    break;
                }
            }
            if( !existe ) {
                unicos[ qtd++ ] = original[ i ];
            }
        }

        // ajuste do tamanho do vetor resultante
        unicos = Arrays.copyOf( unicos , qtd );

       return unicos;
		
	}

}
