package com.synerzip.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.synerzip.helper.DbHelper;
import com.synerzip.model.StudentModel;
import com.synerzip.service.StudentService;

public class StudentServiceImpl implements StudentService {

	java.sql.PreparedStatement ps;
	private DbHelper dbHelper;
	private StudentModel studentModel;
	public ResultSet res;

	public StudentServiceImpl() {
		try {
			resulset();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//for save
	@Override
	public void save(StudentModel studentModel) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub
		ps = dbHelper.getConnection().prepareStatement("insert into student values(?,?,?,?,?,?)");

		ps.setInt(1, studentModel.getRollno());
		ps.setString(2, studentModel.getName());
		ps.setString(3, studentModel.getAddress());
		ps.setFloat(4, studentModel.getMarks());
		ps.setString(5, studentModel.getAge());
		ps.setString(6, studentModel.getGender());

		ps.execute();
	}

	//for update
	public void update(StudentModel studentModel) throws ClassNotFoundException, SQLException {

		ps = dbHelper.getConnection()
				.prepareStatement("update student set name=?, address=?, marks=?, age=?, gender=? where rollno=? ");

		ps.setString(1, studentModel.getName());
		ps.setString(2, studentModel.getAddress());
		ps.setFloat(3, studentModel.getMarks());
		ps.setString(4, studentModel.getAge());
		ps.setString(5, studentModel.getGender());
		ps.setInt(6, studentModel.getRollno());

		ps.execute();
	}
	
	//for delete

	public void delete(int rollNo) throws ClassNotFoundException, SQLException {
		ps = dbHelper.getConnection().prepareStatement("delete from student  where rollno=" + rollNo);

		ps.executeUpdate();
	}
	
	//for search

	public StudentModel search(int rollNo) throws ClassNotFoundException, SQLException {

		String chkquery = "select rollno,name,address,marks,age,gender from student where rollno =" + rollNo;
		Statement statement = dbHelper.getConnection().createStatement();
		ResultSet rs;

		rs = statement.executeQuery(chkquery);

		if (rs != null) {
			studentModel = new StudentModel();
			while (rs.next()) {
				studentModel.setRollno(rs.getInt("rollno"));
				studentModel.setName(rs.getString("name"));
				studentModel.setAddress(rs.getString("address"));
				studentModel.setMarks(rs.getFloat("marks"));
				studentModel.setAge(rs.getString("age"));
				studentModel.setGender(rs.getString("gender"));
			}
		}
		return studentModel;

	}

	//for first search
	
	public StudentModel first() throws ClassNotFoundException, SQLException {
		if (res.first()) {
			studentModel = new StudentModel();
			studentModel.setRollno(res.getInt("rollno"));
			studentModel.setName(res.getString("name"));
			studentModel.setAddress(res.getString("address"));
			studentModel.setMarks(res.getFloat("marks"));
			studentModel.setAge(res.getString("age"));
			studentModel.setGender(res.getString("gender"));

		}
		return studentModel;
	}

	public StudentModel prev() throws ClassNotFoundException, SQLException {

		if (!res.isBeforeFirst() && !res.isFirst() && res.previous()) {
			studentModel = new StudentModel();
			studentModel.setRollno(res.getInt("rollno"));
			studentModel.setName(res.getString("name"));
			studentModel.setAddress(res.getString("address"));
			studentModel.setMarks(res.getFloat("marks"));
			studentModel.setAge(res.getString("age"));
			studentModel.setGender(res.getString("gender"));

		}
		return studentModel;
	}

	public StudentModel next() throws ClassNotFoundException, SQLException {

		if (!res.isLast() && res.next()) {
			studentModel = new StudentModel();
			studentModel.setRollno(res.getInt("rollno"));
			studentModel.setName(res.getString("name"));
			studentModel.setAddress(res.getString("address"));
			studentModel.setMarks(res.getFloat("marks"));
			studentModel.setAge(res.getString("age"));
			studentModel.setGender(res.getString("gender"));

		}
		return studentModel;
	}

	public StudentModel last() throws ClassNotFoundException, SQLException {

		if (res.last()) {
			studentModel = new StudentModel();
			studentModel.setRollno(res.getInt("rollno"));
			studentModel.setName(res.getString("name"));
			studentModel.setAddress(res.getString("address"));
			studentModel.setMarks(res.getFloat("marks"));
			studentModel.setAge(res.getString("age"));
			studentModel.setGender(res.getString("gender"));

		}
		return studentModel;
	}

	public void resulset() throws SQLException, ClassNotFoundException {

		String chkquery = "select * from student";
		Statement statement = dbHelper.getConnection().createStatement();

		res = statement.executeQuery(chkquery);

		if (res != null) {
			studentModel = new StudentModel();
			res.beforeFirst();

		}

	}

}
