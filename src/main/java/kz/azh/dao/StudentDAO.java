package kz.azh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kz.azh.model.Student;

public class StudentDAO {

	/*static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/test";
	
	
	static final String USER = "postgres";
	static final String PASS = "postgres";*/

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet result = null;
	
	public static void addStudent(Long _id, String _name, String _age) {
		
		StringBuilder insert = new StringBuilder("'");        
        insert.append(_id).append("', '").append(_name).append("', '").append(_age).append("')");
        
        try {    		
    		conn = DBConnection.getter().getConnection();
			stmt = conn.createStatement();
			String sql = "INSERT INTO student (id, name, age) VALUES (" + insert;
			result = stmt.executeQuery(sql);
        }catch(SQLException e) {
    		e.printStackTrace();
    	}        
	}
	
	public static void deleteStudent(Long _id){
		
		StringBuilder delete = new StringBuilder("WHERE 1 = 1");		
		delete.append(" AND id = ").append(_id);
		try {    		
    		conn = DBConnection.getter().getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM student " + delete;
			result = stmt.executeQuery(sql);
        }catch(SQLException e) {
    		e.printStackTrace();
    	}  		
	}
	
	public static Student getById(Long _id) {
		
		Student st = new Student();
        StringBuilder where = new StringBuilder("WHERE 1 = 1");
        where.append(" id = ").append(_id);
        try { 
			conn = DBConnection.getter().getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, name, age FROM student "+where;
			result = stmt.executeQuery(sql);
	        st.setId(result.getLong(1));
	        st.setName(result.getString(2));
	        st.setAge(result.getLong(3));
        }catch(SQLException e) {
    		e.printStackTrace();
    	}
        return st;
	}

	
	public static ArrayList<Student> getByName(String _name){
        
        ArrayList<Student> list =  new ArrayList<Student>();
        StringBuilder where = new StringBuilder("WHERE 1 = 1");
		
		if(_name !=null && !_name.isEmpty()) {
			where.append(" AND name like'%").append(_name).append("%'");
		}
		
		try {    		
    		conn = DBConnection.getter().getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, name, age FROM student "+where;
			result = stmt.executeQuery(sql);
			
			while(result.next()) {
				Long id = result.getLong(1);
				String name = result.getString(2);
				Long age = result.getLong(3);
				list.add(new  Student(id, name, age));
			}			
		}catch(SQLException e) {
    		e.printStackTrace();
    	}		
		return list;
	}
}
