package domain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operador {
	private String contenido;
	private ArrayList<String> errores;
	
	public Operador(String s){
		contenido = s;
		errores = new ArrayList<String>();
	}
	
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public void procesarErrores(){
		String expresiones[] = {
				"(^[^a-zA-Z]{1}).*", "[^a-zA-Z\\.]", ".*\\..*\\..*",  ".{6,}"
		};
		
		String errores[] = {
				"los codigos de operacion deben iniciar con letra",
				"los caracteres validos de los codigos de operacion son letras y el caracter del punto",
				"los codigos de operacion no pueden tener mas de un punto",
				"la longitud maxima de un codigo de operacion es de 5 caracteres"
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
