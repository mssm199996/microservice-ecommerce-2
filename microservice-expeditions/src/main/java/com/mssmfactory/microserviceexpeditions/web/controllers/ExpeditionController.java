package com.mssmfactory.microserviceexpeditions.web.controllers;

import com.mssmfactory.microserviceexpeditions.model.Command;
import com.mssmfactory.microserviceexpeditions.model.Expedition;
import com.mssmfactory.microserviceexpeditions.proxies.CommandProxy;
import com.mssmfactory.microserviceexpeditions.repositories.ExpeditionRepository;
import com.mssmfactory.microserviceexpeditions.web.exceptions.CommandNotFoundException;
import com.mssmfactory.microserviceexpeditions.web.exceptions.ExpeditionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("expedition")
public class ExpeditionController {

    @Autowired
    private ExpeditionRepository expeditionRepository;

    @Autowired
    private CommandProxy commandProxy;

    @PostMapping
    public ResponseEntity registerExpedition(@Valid @RequestBody Expedition expedition) {
        Optional<Command> commandOptional = this.commandProxy.findById(expedition.getCommandId());

        if (commandOptional.isPresent()) {
            this.expeditionRepository.save(expedition);

            return new ResponseEntity(expedition, HttpStatus.OK);
        } else throw new CommandNotFoundException();
    }

    @GetMapping("{id}")
    public Expedition findById(@PathVariable("id") Integer expeditionId) {
        Optional<Expedition> expeditionOptional = this.expeditionRepository.findById(expeditionId);

        if (expeditionOptional.isPresent())
            return expeditionOptional.get();
        else throw new ExpeditionNotFoundException();
    }

    @PutMapping
    public void updateExpedition(@Valid @RequestBody Expedition expedition) {
        this.expeditionRepository.save(expedition);
    }
}
