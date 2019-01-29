package web_maven_proj;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.lti.trining.day7.jdbc.DataAccessException;
import web_maven_proj.dto.Emp;


public class EmployeeDao {
	public void storeAll(Emp emp) throws DataAccessException
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			//y not fileiInputStream is=new FileInputStream("prod-db.properties");
			
			InputStream is=this.getClass().getClassLoader().getResourceAsStream("prod-db.properties");
			Properties dbProps=new Properties();
			dbProps.load(is);
			String driverClassName=dbProps.getProperty("driverClassName");
			String url=dbProps.getProperty("url");
			String username=dbProps.getProperty("username");
			String password=dbProps.getProperty("password");
		Class.forName(driverClassName);
		conn=DriverManager.getConnection(url,username,password);
		stmt=conn.prepareStatement("insert into  TBL_E values(?,?,?)");
		stmt.setString(1, emp.getName());
		stmt.setInt(2,emp.getEmp_id());
		stmt.setDouble(3,emp.getSalary());
		stmt.executeUpdate();
					}
		catch( ClassNotFoundException | SQLException | IOException e )
		{
			throw new DataAccessException("prog while loading ",e);
		}
		finally {
				try { stmt.close();} catch(Exception e) {
			}
				try { conn.close();} catch(Exception e) {
					
				}
		}
	
	}

}
