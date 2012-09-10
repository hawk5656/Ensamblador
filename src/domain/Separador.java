package domain;

public class Separador {

	public Linea separa(String cadena){
		Linea l = null;
		char carActual;
		boolean codop = false;
		int ini, i;
		StringBuilder sb = new StringBuilder("");
		if(cadena.charAt(0) == ';'){
			l = new Comentario(cadena);
		}else{
			Instruccion ins = new Instruccion();
			l = ins;
			i = 0;
			ini = 0;
			while(i < cadena.length()){

				while(i < cadena.length() && (Character.isWhitespace(cadena.charAt(i)))){
					i++;
				}
				ini = i;
				//dejo de ser espacio en blanco
				while(i < cadena.length() && (!Character.isWhitespace(cadena.charAt(i)) || codop)){
					i++;
				}
				//no admitir campos vacios
				if(i - ini > 1){
					if(ini == 0){
						ins.setEtiqueta(new Etiqueta(cadena.substring(ini, i)));
					}else{
						if(codop){
							ins.setOperando(new Operando(cadena.substring(ini, i)));					
						} else {
							codop = true;
							ins.setOperador(new Operador(cadena.substring(ini, i)));
						}
					}
				}
				
			}
		}
		return l;
	}
}
