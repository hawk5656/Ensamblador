package domain;

public class Comentario extends Linea{

	public Comentario(String s){
		this.literal = s;
	}
	
	@Override
	public String toString() {

		return "COMENTARIO";
	}
	
}
