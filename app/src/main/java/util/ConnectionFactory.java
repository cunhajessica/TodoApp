package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/* O jdbc é um driver para conexão com o banco de dados. Se fosse banco Postgree
teria que trocar, tirando o mysql.
URL: quando o banco está fora da maquina local, não é mais localhost, é o 
IP do servidor. Número 3306 é o múmero da porta mysql do banco de dados.
USER: O nome do usuario para acesso ao banco de dados
PASS: Senha para acesso ao banco de dados.
 */
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static java.sql.Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conex�o com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        closeConnection(connection);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }

    }

}
