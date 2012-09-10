package domain;

public class Instruccion extends Linea{
	private Etiqueta etiqueta;
	private Operador operador;
	private Operando operando;
	
	public Etiqueta getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	public Operando getOperando() {
		return operando;
	}
	public void setOperando(Operando operando) {
		this.operando = operando;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("\nETIQUETA = ");
		if(this.etiqueta != null){
			this.etiqueta.procesarErrores();
			sb.append(this.etiqueta);
		} else {
			sb.append("NULL");
		}
		sb.append("\nCODOP = ");
		if(this.operador != null){
			this.operador.procesarErrores();
			sb.append(this.operador);
		} else {
			sb.append("NULL");
			sb.append("\n\tError: siempre debe haber un codigo de operacion");
		}
		sb.append("\nOPERANDO = ");
		if(this.operando != null){
			sb.append(this.operando);
		} else {
			sb.append("NULL");
		}

		sb.append("\n");
		return sb.toString();
	}
	
	
	
	
}
