class Eletroposto:
    def __init__(self, id, local, num_vagas, tempo_carga):
        self._id = id  # ID do eletroposto
        self._local = local  # Localização do eletroposto
        self._num_vagas = num_vagas  # Número total de vagas disponíveis
        self._vagas_ocupadas = 0  # Inicialmente, nenhuma vaga ocupada
        self._tempo_carga = tempo_carga  # Tempo médio para carregar um carro (em minutos)

    # Getters e Setters
    @property
    def id(self):
        return self._id

    @property
    def local(self):
        return self._local

    @property
    def num_vagas(self):
        return self._num_vagas

    @property
    def vagas_ocupadas(self):
        return self._vagas_ocupadas

    @property
    def tempo_carga(self):
        return self._tempo_carga

    def ocupar_vaga(self):
        """Marca uma vaga como ocupada se houver disponibilidade."""
        if self._vagas_ocupadas < self._num_vagas:
            self._vagas_ocupadas += 1
            print(f"Uma vaga foi ocupada no eletroposto {self._id}.")
        else:
            print(f"Eletroposto {self._id} está com todas as vagas ocupadas.")

    def liberar_vaga(self):
        """Libera uma vaga no eletroposto."""
        if self._vagas_ocupadas > 0:
            self._vagas_ocupadas -= 1
            print(f"Uma vaga foi liberada no eletroposto {self._id}.")
        else:
            print(f"Todas as vagas no eletroposto {self._id} já estão livres.")

    def verificar_disponibilidade(self):
        """Retorna se há vagas disponíveis no eletroposto."""
        return self._vagas_ocupadas < self._num_vagas

    def __str__(self):
        return (f"Eletroposto ID: {self._id}, Local: {self._local}, "
                f"Vagas: {self._num_vagas - self._vagas_ocupadas}/{self._num_vagas}, "
                f"Tempo médio de carga: {self._tempo_carga} minutos")
