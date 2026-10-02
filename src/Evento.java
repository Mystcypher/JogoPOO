public abstract class Evento {

    private String descricao;

    public Evento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void executar(Nave nave);
}