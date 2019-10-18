package com.mcommands.web.controller;


import com.mcommands.repositories.CommandRepository;
import com.mcommands.model.Command;
import com.mcommands.web.exceptions.CommandNotFoundException;
import com.mcommands.web.exceptions.ImpossibleToAddCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("command")
@RestController
public class CommandController {

    @Autowired
    private CommandRepository commandRepository;

    @PostMapping
    public ResponseEntity<Command> addCommand(@RequestBody Command command) {
        Command addedCommand = this.commandRepository.save(command);

        if (addedCommand == null)
            throw new ImpossibleToAddCommandException("Impossible to add the command");

        return new ResponseEntity<>(command, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Optional<Command> recupererUneCommande(@PathVariable int id) {
        Optional<Command> commande = this.commandRepository.findById(id);

        if (!commande.isPresent())
            throw new CommandNotFoundException("No available command");

        return commande;
    }
}
