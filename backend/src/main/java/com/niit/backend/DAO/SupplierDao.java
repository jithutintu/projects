package com.niit.backend.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.backend.model.Supplier;

@Repository
public interface SupplierDao {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete (Supplier supplier);
	public Supplier  get(String id);

	public List<Supplier>list();

}
