package db;

import Model.Figura;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FiguraRepository {
    private static final Logger log = Logger.getLogger(FiguraRepository.class);
    private static final String SQL_BUSCA_POR_COR = "SELECT * FROM Figura WHERE cor = ?";

    private final Connection connection;

    public FiguraRepository() throws Exception {
        this.connection = ConnectionConfiguration.getConnetion();
    }
    public Figura buscarFiguraCor(String cor) {
        log.info("bucando Figura por cor" + cor);
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_BUSCA_POR_COR)) {
            preparedStatement.setString(1,cor);
            log.info("executando select por cor");
            ResultSet resultSet = preparedStatement.executeQuery();
            log.info("lendo resultado encontrado");
            while (resultSet.next()){
                System.out.println(("Foi encontrado figura " +
                        "" +
                        "cor: %s figura: %s").formatted(resultSet.getString("cor"), resultSet.getString("figura")));
            }
            return null;

        } catch (Exception e){
            log.info(e);
            return null;
        }
    }

    private static final String SQL_DE_CRIACAO =  """
                INSERT INTO Figura(id, figura, cor)
                VALUES(?, ?, ?);
            """;
    public Figura criarFigura(Figura figura) throws SQLException {
        log.info("Criando figura");
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DE_CRIACAO)) {
            preparedStatement.setString(1,figura.getId());
            preparedStatement.setString(2,figura.getFigura());
            preparedStatement.setString(3,figura.getCor());

            log.info("executando criação");
            preparedStatement.execute();
            log.info("Figura criada com os seguintes valores: \nid: %s | figura: %s | cor: %s".formatted(figura.getId(),figura.getFigura(),figura.getCor()));
            return figura;
        } catch (Exception e){
            log.error(e);
            connection.rollback();
            return null;
        }
    }

}
