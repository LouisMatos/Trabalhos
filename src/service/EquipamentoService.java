package service;

import java.util.ArrayList;

import dao.EquipamentoDAO;
import model.Equipamento;

public class EquipamentoService {

	 private EquipamentoDAO dao = new EquipamentoDAO();
	 
	 public void salvar(Equipamento equip) throws ClassNotFoundException{		 
		 try {
			dao.save(equip);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	  
	 public int ultimoId(){
		try {
			return dao.getLastId();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	 }
	 
	 public ArrayList<Equipamento> listaTodos(){
		 try {
			return dao.listAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }

	public boolean verificaSeExiste(String nome) throws ClassNotFoundException {
		return dao.verificaSeExiste(nome);
	}
}
