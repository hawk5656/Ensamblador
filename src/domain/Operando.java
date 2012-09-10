package domain;

public class Operando {
	private String contenido;
	
	public Operando(String s){
		contenido = s;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(this.contenido);

		return sb.toString();
	}
	
}
