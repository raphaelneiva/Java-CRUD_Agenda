package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
public class GerenteDeConexao implements IConfiguracaoBanco{
//
public static Connection getConexao()
        throws Exception{
        Class.forName(DRIVER); ///Carregar para a memória o driver JDBC do MySQL
        Connection conexao = DriverManager.getConnection(HOST,USUARIO,SENHA);
        return conexao;
    }

    
}