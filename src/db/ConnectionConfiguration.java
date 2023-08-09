package db;

import org.apache.log4j.Logger;
import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionConfiguration {
    public static final Logger log = Logger.getLogger(ConnectionConfiguration.class);
    private static Connection connection;

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS Figura;
                     CREATE TABLE Figura(
                         id      VARCHAR(36) PRIMARY KEY,
                         figura    VARCHAR(100) NOT NULL,
                         cor  VARCHAR(19) NOT NULL
                     );;
            """;

    public static Connection getConnetion() throws Exception{
        log.info("Validando uma conexão existente");

        if (connection == null) {
            log.info("nenhuma conexão disponível, criando nova conexão");

            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            log.info("criando tabale no banco de dados!");

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }
        return connection;
    }


}
