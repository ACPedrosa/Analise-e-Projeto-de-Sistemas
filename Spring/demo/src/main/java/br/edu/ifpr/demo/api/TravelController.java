package br.edu.ifpr.demo.api;

import br.edu.ifpr.demo.service.TravelServices; 
import br.edu.ifpr.demo.domain.TravelRequest;
import br.edu.ifpr.demo.domain.TravelRequestRepository; 
import br.edu.ifpr.demo.exception.InvalidStatusException;
import br.edu.ifpr.demo.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/travels", produces = MediaType.APPLICATION_JSON_VALUE)

public class TravelController {

    @Autowired
    private TravelServices travelService;

    @Autowired
    private TravelRequestRepository travelRequestRepository; 

    //Criação de uma nova viagem e mudança de estado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelRequest createTravelRequest(@RequestBody TravelRequest request) {
        return travelService.createTravelRequest(request);
    }
    
    @PutMapping("/{id}/accept")
    public TravelRequest acceptTravelRequest(@PathVariable("id") Long id) {
        try {
            return travelService.acceptTravelRequest(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (InvalidStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    // Para listar as viagens
    @GetMapping
    public List<TravelRequest> listTravels() {
        return travelRequestRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public TravelRequest findTravel(@PathVariable("id") Long id) {
        return travelRequestRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viagem não encontrada."));
    }
}