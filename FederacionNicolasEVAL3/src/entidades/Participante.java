package entidades;

public class Participante {
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;
	private Tiempo tm;
	private boolean penalizacion=false;
	private String otros;

	public Participante(long id, int dorsal, char calle) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
	}

	public Participante(long id, int dorsal, char calle, Tiempo tm, boolean penalizacion) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.tm = tm;
		this.penalizacion = penalizacion;
	}

	public Participante(long id, int dorsal, char calle, Tiempo tm, boolean penalizacion, String otros) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.tm = tm;
		this.penalizacion = penalizacion;
		this.otros = otros;
	}

	public Participante() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}
	

	public Tiempo getTm() {
		return tm;
	}

	public void setTm(Tiempo tm) {
		this.tm = tm;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + ", tm=" + tm + ", penalizacion="
				+ penalizacion + ", otros=" + otros + "]";
	}

}
