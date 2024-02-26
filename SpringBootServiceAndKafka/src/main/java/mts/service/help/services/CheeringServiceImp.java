package mts.service.help.services;

import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CheeringServiceImp implements CheeringService {

    private CheeringInMemRepository repository;

    public CheeringServiceImp(CheeringInMemRepository repository) {
        this.repository = repository;
    }

    public CheeringServiceImp() {
    }

    public CheeringPhrase getCheeringPhrase() {
        return repository.getCheeringPhrase();
    }

    public CheeringResponse addCheeringPhrase(CheeringRequest request) {
        repository.addCheeringPhrase(request.getCheeringPhrase());
        return new CheeringResponse("Фраза '" + request.getCheeringPhrase() + "' добавлена", HttpStatus.CREATED);
    }

}
