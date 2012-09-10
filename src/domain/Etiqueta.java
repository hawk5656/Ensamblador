package domain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Etiqueta {
	private String contenido;
	private ArrayList<String> errores;
	public Etiqueta(String s){
		contenido = s;
		errores = new ArrayList<String>();
	}
	
	public void procesarErrores(){
		String expresiones[] = {
				"(^[^a-zA-Z]{1}).*", "[^\\w_]+", ".{9,}"
		};
		String errores[] = {
				"la etiqueta debe iniciar con letra",
				"los caracteres validos en las etiquetas son letras, digitos(0..9) y el guion bajo",
				"la longitud maxima de una etiqueta es de ocho caracteres"			
		};
		int i = 0;
		for(String s: expresiones){
			if(i == 1 && !this.errores.isEmpty())
				continue ;
			Pattern pattern = 
	            Pattern.compile(s);

	        Matcher matcher = 
	            pattern.matcher(contenido);
	        boolean match = false;
	        while (matcher.find()) {
	        	match = true;
	        }
	        if(match){
	        	this.errores.add(errores[i]);
	        }
	        
	        i++;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(this.contenido);
		
		for(String s: errores){
			sb.append("\n\tError: ");
			sb.append(s);
		}
		return sb.toString();
	}
	
}
