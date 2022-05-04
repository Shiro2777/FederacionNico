package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import entidades.Metal;
import entidades.Oro;
import utils.ConexBD;

public class MetalDAO implements operacionesCRUD<Metal> {
	
	Connection conex;

	public MetalDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Metal m) {
		boolean ret = false;
		
		
		String consultaInsertStr1 = "insert into metales(idMetal, fecha, asignada, pureza, idOro, idPlata, idBronce) values (?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, m.getIdMetal());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				System.out.println("Se ha insertado correctamente el nuevo Atleta.");
				ret = true;
			}
			
			if (conex != null) {
				conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}

	@Override
	public long insertarSinID(Metal elemento) {
		
		return 0;
	}

	@Override
	public Metal buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Metal> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Metal elemento) {
		
		return false;
	}

	@Override
	public boolean eliminar(Metal elemento) {
		
		return false;
	}

}