package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import utils.ConexBD;
import principal.PrincipalExam10;
import utils.Datos;
import entidades.DatosPersona;

public class Patrocinador implements operacionesCRUD<Patrocinador>{
	private long id;
	private String nombre;
	private String web;
	private double dotacion;
	private Responsable rp;

	public Patrocinador() {
		super();
	}

	public Patrocinador(long id, String nombre, String web, double dotacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
	}

	public Patrocinador(long id, String nombre, String web, double dotacion, Responsable rp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.rp = rp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public Responsable getRp() {
		return rp;
	}

	public void setRp(Responsable rp) {
		this.rp = rp;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + ", web=" + web + ", dotacion=" + dotacion + ", rp="
				+ rp + "]";
	}

	public String data() {
		String ret = "";
		ret += "" + this.getId() + "|" + rp.getId() + "|" + this.getNombre() + "|"
				+ this.dotacion + "|" + this.web;
		return ret;
	}
	
	@Override
	public boolean insertarConID(Patrocinador p) {
		boolean ret = false;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr1 = "insert into responsables(id, telefonoProf, horarioIni, horarioFin, idpersona) values (?,?,?,?,?)";
		String consultaInsertStr2 = "insert into patrocinadores(id, nombre, web, dotacion, idresponsable) values (?,?,?,?,?)";
		try {
			
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, p.getRp().getId());
			pstmt.setString(2, p.getRp().getTelefonoProf());
			java.sql.Time HoraSQL = java.sql.Time.valueOf(p.getRp().getHorarioIni());
			pstmt.setTime(4, HoraSQL);
			java.sql.Time HoraSQL2 = java.sql.Time.valueOf(p.getRp().getHorarioFin());
			pstmt.setTime(5, HoraSQL2);
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr2);
				pstmt2.setLong(1, p.getId());
				pstmt2.setString(2, p.getNombre());
				pstmt2.setString(3, p.getWeb());
				pstmt2.setDouble(4, p.getDotacion());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Patrocinador con ID.");
					ret = true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}

	@Override
	public long insertarSinID(Patrocinador p) {
		
		return 0;
	}
}
