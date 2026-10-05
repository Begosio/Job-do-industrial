package com.has.etec.projectShelock.services;



import com.has.etec.projectShelock.dtos.caso.CasoResponse;
import com.has.etec.projectShelock.entities.Caso;
import com.has.etec.projectShelock.repositories.CasoRepository;
import org.springframework.stereotype.Service;

@Service
public class CasoService {

    private final CasoRepository casoRepository;

    public CasoService(CasoRepository casoRepository) {
        this.casoRepository = casoRepository;
    }

    public CasoResponse buscarPorId(Long id) {

        Caso caso = casoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Caso não encontrado!")
                );

        return new CasoResponse(
                caso.getId(),
                caso.getTitulo(),
                caso.getDescricao(),
                caso.getAlternativas()
        );
    }
}