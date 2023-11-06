package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import modelos.Cliente;

public class ClienteDAO {

	
public void create(Cliente cliente) {

	String sql ="insert into cliente (nome, contato) values (?, ?)";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
	   conn = ConnectionMySQL.createConnectionToMysql();
			
	pstm = conn.prepareStatement(sql);
	
	pstm.setString(1, cliente.getNome());
	pstm.setString(2, cliente.getContato());
	
	pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		try{
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}

	
	public List<Cliente> read(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		
	    String sql = "select * from cliente";
	    
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			while (rset.next()){
				Cliente cliente = new Cliente();
				
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setContato(rset.getString("contato"));
				
				cliente.add(cliente);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		return clientes;
	}
	
	
	public void update(Cliente cliente) {
	
		 String sql = "update cliente set nome = ? contato = ? where id_cliente = ?";
		    
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {	
				
				conn = ConnectionMySQL.createConnectionToMysql();		
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getContato());
				pstm.setInt(1, cliente.getId());
				
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		try{
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
}
	}
	
		public void delete(int id) {
			 String sql = "delete from cliente where id_cliente = ?";
			 
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {	
					
					conn = ConnectionMySQL.createConnectionToMysql();
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					pstm.execute();
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		}	
		
	 
		public Cliente readById(int id) {
			Cliente cliente = new Cliente();
			
			 String sql = "select* from cliente where id_cliente= ?";
			 
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {	
					
					conn = ConnectionMySQL.createConnectionToMysql();
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					rset =pstm.executeQuery();
					rset.next();
					cliente.setId(rset.getInt(""));
					cliente.setNome(rset.getString("nome"));
					cliente.setContato(rset.getString("contato"));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		return new Cliente();
		}
}
