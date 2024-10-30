import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private CarroEletrico carro;
    private Motorista motorista;
    private List<Eletroposto> paradas;
    private double distanciaTotal;
    private double distanciaPercorrida;

    public Viagem(CarroEletrico carro, Motorista motorista, double distanciaTotal) {
        this.carro = carro;
        this.motorista = motorista;
        this.distanciaTotal = distanciaTotal;
        this.distanciaPercorrida = 0;
        this.paradas = new ArrayList<>();
    }

    public void adicionarParada(Eletroposto eletroposto) {
        if (eletroposto.verificarDisponibilidade()) {
            paradas.add(eletroposto);
            eletroposto.ocuparVaga();
            System.out.println("Parada adicionada no Eletroposto ID: " + eletroposto.getId());
        } else {
            System.out.println("Eletroposto ID: " + eletroposto.getId() + " está sem vagas.");
        }
    }

    public void iniciarViagem() {
        while (distanciaPercorrida < distanciaTotal) {
            double autonomiaAtual = carro.getAutonomia();

            if (autonomiaAtual >= (distanciaTotal - distanciaPercorrida)) {
                distanciaPercorrida = distanciaTotal;
                System.out.println("Viagem concluída sem necessidade de paradas adicionais.");
            } else {
                System.out.println("Autonomia insuficiente para concluir a viagem sem recarga.");
                for (Eletroposto parada : paradas) {
                    if (parada.verificarDisponibilidade()) {
                        recarregarCarro(parada);
                        break;
                    }
                }
            }
        }
    }

    public void recarregarCarro(Eletroposto eletroposto) {
        if (paradas.contains(eletroposto)) {
            System.out.println("Carro recarregado no eletroposto " + eletroposto.getId() + ". Autonomia restaurada.");
            eletroposto.liberarVaga();
        } else {
            System.out.println("O eletroposto não faz parte das paradas planejadas.");
        }
    }

    public double getDistanciaPercorrida() { return distanciaPercorrida; }
    public double getDistanciaTotal() { return distanciaTotal; }
    public List<Eletroposto> getParadas() { return paradas; }
}
