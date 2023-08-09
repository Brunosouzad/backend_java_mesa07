import Model.Figura;
import db.FiguraRepository;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Figura figura = new Figura("","Cicurlo","Vermelha");
        Figura figura2 = new Figura("","Cicurlo","Branco");
        Figura figura3 = new Figura("","Quadrado","Preto");
        Figura figura4 = new Figura("","Quadrado","Vermelha");
        Figura figura5 = new Figura("","Quadrado","Vermelha");

        FiguraRepository figuraRepository = new FiguraRepository();
        figuraRepository.criarFigura(figura);
        figuraRepository.criarFigura(figura2);
        figuraRepository.criarFigura(figura3);
        figuraRepository.criarFigura(figura4);
        figuraRepository.criarFigura(figura5);

        Figura Corconsultada = figuraRepository.buscarFiguraCor(figura.getCor());
        log.info("Figura" + Corconsultada);

    }
}

