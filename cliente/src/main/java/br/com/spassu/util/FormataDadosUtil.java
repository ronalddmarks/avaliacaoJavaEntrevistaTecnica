package br.com.spassu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FormataDadosUtil {

	public Double removePontuacao(String valor) {
				
		valor = valor.replaceAll(" ", "");
		valor = valor.replace(".", "");
		valor = valor.replaceAll(",", ".");
		

		double valorDouble = Double.parseDouble(valor);
		
		return valorDouble;
		
	}
	
	public Date formataData(String valor) throws ParseException {
		
		valor.replaceAll(" ", "");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (Date) formato.parse(valor);
		
				
		return data;
		
	}
	
	public String getDataFormatada (Date date) {
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		fmt.format(date);
		
		return fmt.format(date);
	}
	
	public int[] removeValorDuplicadoVet(int[] original) {
		
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
