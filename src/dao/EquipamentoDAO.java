/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.Equipamento;


/**
 *
 * @author Trabalho
 */
public class EquipamentoDAO {

	public void save(Equipamento equip) throws ClassNotFoundException {
		String sql = "INSERT INTO tb_equipamento(nome, tipo, peso) VALUES (?, ?, ?)";
		// try with resources
		try{ 
			Connection conn = ConnectionFactory.obterConexao(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, equip.getNome());
			ps.setString(2, equip.getTipo());
			ps.setFloat(3, equip.getPeso());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Equipamento> listAll() throws ClassNotFoundException {
		String sql = "SELECT * FROM tb_equipamento";
		ArrayList<Equipamento> equips = new ArrayList<>();

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Equipamento equi = new Equipamento();
				equi.setId(rs.getInt(1));
				equi.setNome(rs.getString(2));
				equi.setTipo(rs.getString(3));
				equi.setPeso(rs.getFloat(4));
				equips.add(equi);
			}
			return equips;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equips;

	}

	public int getLastId() throws ClassNotFoundException {
		String sql = "SELECT * FROM tb_equipamento order by id desc LIMIT 1";
		int id = 0;
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				id = rs.getInt(1);
			}

			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean verificaSeExiste(String nomess) throws ClassNotFoundException {
		String sql = "SELECT * FROM tb_equipamento WHERE nome = ?";
		int cad = 0;
		try (
				Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);) {
				ps.setString(1, nomess);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					cad = rs.getInt(1);
				}
				
				if(cad != 0){
					return true;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

}
