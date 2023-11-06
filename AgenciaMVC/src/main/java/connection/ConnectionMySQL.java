package connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionMySQL {

	private static final String username = "root";
	private static final String password = "l76058310.P";
	private static final String database_url = "jdbc:mysql://localhost:3306/crud";
	public static Connection createConnectionToMysql()throws
	Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

	Connection connection =
	DriverManager.getConnection(database_url, username, password);
	return connection;
	}
	public static void main(String[] args)throws Exception{
		Connection con = createConnectionToMysql();
		if(con!=null) {
			System.out.println("conexao obtida com sucesso!"+con);
			con.close();
		}
	}
	}
