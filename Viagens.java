import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private CarroEletrico carro;         // Carro utilizado na viagem
    private Motorista motorista;         // Motorista da viagem
    private List<Eletroposto> paradas;   // Eletropostos planejados para a viagem
    private double distanciaTotal;       // Distância total da viagem em km
    private double distanciaPercorrida;  // Distância percorrida até o momento

    // Construtor
    public Viagem(CarroEletrico carro, Motorista motorista, double distanciaTotal) {
        this.carro = carro;
        this.motorista = motorista;
        this.distanciaTotal = distanciaTotal;
        this.distanciaPercorrida = 0;
        this.paradas = new ArrayList<>();
    }

    // Método para adicionar uma parada no eletroposto
    public void adicionarParada(Eletroposto eletroposto) {
        if (eletroposto.verificarDisponibilidade()) {
            paradas.add(eletroposto);
            eletroposto.ocuparVaga();
            System.out.println("Parada adicionada no Eletroposto ID: " + eletroposto.getId());
        } else {
            System.out.println("Eletroposto ID: " + eletroposto.getId() + " está sem vagas.");
        }
    }

    // Método para planejar paradas com base na autonomia do carro
    public void planejarParadas() {
        double autonomiaAtual = getAutonomiaAtual();

        // Verifica se a autonomia é suficiente para a viagem
        if (autonomiaAtual >= distanciaTotal) {
            System.out.println("A autonomia do carro é suficiente para a viagem sem paradas.");
        } else {
            System.out.println("A autonomia do carro exige paradas para recarga.");
            // Aqui, seria possível implementar a lógica de cálculo para as paradas
        }
    }

    // Método para atualizar a autonomia do carro após cada recarga
    public void recarregarCarro(Eletroposto eletroposto) {
        if (paradas.contains(eletroposto)) {
            double autonomiaMaxima = carro.getAutonomiaMaxima();
            System.out.println("Carro recarregado no eletroposto " + eletroposto.getId() + ". Autonomia restaurada.");
            eletroposto.liberarVaga();
        } else {
            System.out.println("O eletroposto não faz parte das paradas planejadas.");
        }
    }

    // Método para iniciar a viagem e fazer as paradas conforme necessário
    public void iniciarViagem() {
        while (distanciaPercorrida < distanciaTotal) {
            if (getAutonomiaAtual() >= (distanciaTotal - distanciaPercorrida)) {
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

    // Método para obter a autonomia atual do carro
    private double getAutonomiaAtual() {
        if (carro instanceof CarroCompacto) {
            return ((CarroCompacto) carro).getAutonomia();
        } else if (carro instanceof CarroSUV) {
            return ((CarroSUV) carro).getAutonomia();
        } else if (carro instanceof CarroSedan) {
            return ((CarroSedan) carro).getAutonomia();
        } else {
            return carro.getAutonomiaMaxima(); // Valor padrão para qualquer outro caso
        }
    }

    // Getters para distância
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public List<Eletroposto> getParadas() {
        return paradas;
    }
}
