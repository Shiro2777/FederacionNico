package entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Responsable {
	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;
	private DatosPersona persona;

	public Responsable() {
		super();
	}

	public Responsable(long id, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona persona) {
		super();
		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.persona = persona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	public DatosPersona getPersona() {
		return persona;
	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Responsable [id=" + id + ", telefonoProf=" + telefonoProf + ", horarioIni=" + horarioIni
				+ ", horarioFin=" + horarioFin + ", persona=" + persona + "]";
	}

	public String data() {
		String ret = "";
		ret += "" + this.getId() + "|" + persona.getId() + "|" + this.getTelefonoProf() + "|"
				+ this.getHorarioIni().format(DateTimeFormatter.ofPattern("HH:mm")) + "|"
				+ this.getHorarioFin().format(DateTimeFormatter.ofPattern("HH:mm"));
		return ret;
	}
}
