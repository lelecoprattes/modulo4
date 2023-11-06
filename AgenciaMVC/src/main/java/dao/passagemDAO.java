package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import modelos.passagem;

public class passagemDAO {
	public void create(Passagem passage) {

		String sql ="insert into passagem (destino, dataPassagem) values (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
		   conn = ConnectionMySQL.createConnectionToMysql();
				
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, passage.getDestino());
		pstm.setString(2, passage.getDataPassagem());
		
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

		//read consulta
		public List<Passagem> read(){
			List<Passagem> clientes = new ArrayList<Passagem>();
			
		    String sql = "select * from passagem";
		    
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				while (rset.next()){
					Passagem pedi = new Passagem();
					
					pedi.setId(rset.getInt("id_passagem"));
					pedi.setDataPassagem(rset.getString("DataPassagem"));
					
					passagem.add(pedi);
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
			return pedi;
		}
		
		//update atualizar
		public void update(Passagem passage) {
		
			 String sql = "update passagem set destino = '?', dataPassagem = '?' where id_passagem = ?;";
			    
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {	
					
					conn = ConnectionMySQL.createConnectionToMysql();		
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, passage.getDestino());
					pstm.setString(2, passage.getDataPassagem());
					pstm.setInt(1, passage.getId());
					
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
		//delete
			public void delete(int id) {
				 String sql = "delete from cliente where id_passagem = ?";
				 
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
			
		//readById 
			public Passagem readById(int id) {
				Passagem pedi = new Passagem();
				
				 String sql = "select* from cliente where id_passagem = ?";
				 
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;
					
					try {	
						
						conn = ConnectionMySQL.createConnectionToMysql();
						pstm = conn.prepareStatement(sql);
						
						pstm.setInt(1, id);
						rset =pstm.executeQuery();
						rset.next();
						pedi.setId(rset.getInt("id_passagem"));
						pedi.setDestino(rset.getString("destino"));
						pedi.setDataPassagem(rset.getString("dataPassagem"));
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
			return new Passagem();
			}
	}