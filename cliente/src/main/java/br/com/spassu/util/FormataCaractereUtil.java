package br.com.spassu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataCaractereUtil {

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
	
	

}
