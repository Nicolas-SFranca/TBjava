public class Eletroposto {
    private int id;              // ID do eletroposto
    private String local;        // Localização do eletroposto
    private int numVagas;        // Número total de vagas
    private int vagasOcupadas;   // Número de vagas ocupadas
    private int tempoCarga;      // Tempo médio de carga em minutos

    // Construtor
    public Eletroposto(int id, String local, int numVagas, int tempoCarga) {
        this.id = id;
        this.local = local;
        this.numVagas = numVagas;
        this.vagasOcupadas = 0;  // Inicialmente, todas as vagas estão livres
        this.tempoCarga = tempoCarga;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public int getTempoCarga() {
        return tempoCarga;
    }

    // Métodos para gerenciar vagas
    public void ocuparVaga() {
        if (vagasOcupadas < numVagas) {
            vagasOcupadas++;
            System.out.println("Uma vaga foi ocupada no eletroposto " + id + ".");
        } else {
            System.out.println("Eletroposto " + id + " está com todas as vagas ocupadas.");
        }
    }

    public void liberarVaga() {
        if (vagasOcupadas > 0) {
            vagasOcupadas--;
            System.out.println("Uma vaga foi liberada no eletroposto " + id + ".");
        } else {
            System.out.println("Todas as vagas no eletroposto " + id + " já estão livres.");
        }
    }

    public boolean verificarDisponibilidade() {
        return vagasOcupadas < numVagas;
    }

    @Override
    public String toString() {
        return "Eletroposto ID: " + id + ", Local: " + local + ", Vagas: " + 
                (numVagas - vagasOcupadas) + "/" + numVagas + 
                ", Tempo médio de carga: " + temp

