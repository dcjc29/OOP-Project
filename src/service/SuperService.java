package service;

import java.util.ArrayList;



public interface SuperService<T,ID> {
	
	 	public void add(T t);

	    public T getByID(ID id);

	    public T update(ID id, T t);

	    public void remove(ID id);

	    public ArrayList<T> getAll();

		
}
