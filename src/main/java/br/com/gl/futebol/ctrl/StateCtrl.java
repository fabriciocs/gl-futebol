package br.com.gl.futebol.ctrl;


public class StateCtrl {

	private StateType state = StateType.READ;
	
	public void setNovo(){
		state = StateType.CREATE;
	}
	
	public void setLer(){
		state = StateType.READ;
	}
	public void setRemover(){
		state = StateType.DELETE;
	}
	public void setEditar(){
		state = StateType.UPDATE;
	}
	
	public boolean isNovo(){
		return state == StateType.CREATE;
	}
	
	public boolean isLer(){
		return state == StateType.READ;
	}
	
	public boolean isRemover(){
		return state == StateType.DELETE;
	}
	public boolean isEditar(){
		return state == StateType.UPDATE;
	}
	
	
}
