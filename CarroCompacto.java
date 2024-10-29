public class CarroCompacto extends CarroEletrico {
    private int autonomia;
    private int tempoDeRecarga;

    public CarroCompacto(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMaxima, int autonomia, int tempoDeRecarga) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMaxima);
        this.autonomia = autonomia;
        this.tempoDeRecarga = tempoDeRecarga;
    }
}

