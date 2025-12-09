package br.edu.ifpr.demo.service;

import br.edu.ifpr.demo.domain.TravelRequest;
import br.edu.ifpr.demo.domain.TravelRequestRepository;
import br.edu.ifpr.demo.domain.TravelRequestStatus;
import br.edu.ifpr.demo.exception.InvalidStatusException;
import br.edu.ifpr.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TravelServices {

    private final TravelRequestRepository repository;

    public TravelServices(TravelRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TravelRequest createTravelRequest(TravelRequest request) {
        //criando uma viagem e alterando o estado para created
        request.setStatus(TravelRequestStatus.CREATED);
        return repository.save(request);
    }

    @Transactional
    public TravelRequest acceptTravelRequest(Long requestId) {
        //Erro 404 - caso a viagem não seja encontrada
        TravelRequest request = repository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Viagem " + requestId + " não foi encontrada (Erro: 404)."
                ));

        if (request.getStatus() != TravelRequestStatus.CREATED) {
            //Erro 400 -para viagens que já estão no estado de accepted e finised
            if (request.getStatus() == TravelRequestStatus.ACCEPTED || request.getStatus() == TravelRequestStatus.FINISHED) {
                 throw new InvalidStatusException(
                    "Viagem já está em no final (" + request.getStatus() + ")(Error 400)."
                 );
            }
            
            throw new InvalidStatusException(
                    "Viagem com status diferente de CREATED, Status atual: " + request.getStatus() + " (Error 400)."
            );
        }

        //Quando motorista aceita uma viagem o estado vai para acepted
        request.setStatus(TravelRequestStatus.ACCEPTED);
        return repository.save(request);
    }
}
