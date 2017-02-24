package com.synerzip.service;

import java.sql.SQLException;

import com.synerzip.model.StudentModel;

public interface StudentService {

	public void save(StudentModel studentModel) throws SQLException, ClassNotFoundException;
	
	public void update(StudentModel studentModel) throws ClassNotFoundException, SQLException;
	
	public void delete(int rollNo) throws ClassNotFoundException, SQLException;
	
	public StudentModel search(int rollNo) throws ClassNotFoundException, SQLException;
	
	public StudentModel first() throws ClassNotFoundException, SQLException;
	
	public StudentModel last() throws ClassNotFoundException, SQLException;
	
	public void resulset() throws SQLException, ClassNotFoundException;
	
	public StudentModel prev() throws ClassNotFoundException, SQLException;
	
	public StudentModel next() throws ClassNotFoundException, SQLException;
}
