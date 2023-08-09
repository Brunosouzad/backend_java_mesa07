package Model;

import java.util.UUID;

public class Figura {
    private String id;
    private String figura;
    private String cor;

    public Figura(String id, String figura, String cor) {
        this.id = UUID.randomUUID().toString();
        this.figura = figura;
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
