package entidades;

public class Tiempo {
	private long horas;
	private long minutos;
	private long segundos;
	private long centesimas;
	
	public Tiempo() {
		super();
	}

	
	public Tiempo(long horas, long minutos, long segundos, long centesimas) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		this.centesimas = centesimas;
	}
	
	public long getHoras() {
		return horas;
	}
	public void setHoras(long horas) {
		this.horas = horas;
	}
	public long getMinutos() {
		return minutos;
	}
	public void setMinutos(long minutos) {
		this.minutos = minutos;
	}
	public long getSegundos() {
		return segundos;
	}
	public void setSegundos(long segundos) {
		this.segundos = segundos;
	}
	public long getCentesimas() {
		return centesimas;
	}
	public void setCentesimas(long centesimas) {
		this.centesimas = centesimas;
	}
	
	@Override
	public String toString() {
		return "Tiempo =" + horas + ":" + minutos + ":" + segundos + ","
				+ centesimas;
	}
	
}
