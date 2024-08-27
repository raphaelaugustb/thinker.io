package com.leah.thinker.io.Controller;

import com.leah.thinker.io.dto.request.IdeaRequest;
import com.leah.thinker.io.Service.AccountService;
import com.leah.thinker.io.Service.IdeaService;
import com.leah.thinker.io.entity.Account;
import com.leah.thinker.io.entity.Idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class IdeaController {
    IdeaService ideaService;
    AccountService accountService;

    public IdeaController(AccountService accountService, IdeaService ideaService) {
        this.accountService = accountService;
        this.ideaService = ideaService;
    }

    @GetMapping("/user/{id}/idea")
    public ResponseEntity<List<Idea>> getIdea(@PathVariable UUID id) {
        List<Idea> ideaList = ideaService.listIdeasAccount(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(ideaList);
    }

    @GetMapping("/user/{id}/idea/{tittle}")
    public ResponseEntity<List<Idea>> getIdeaByTittle(@PathVariable UUID id, @PathVariable String tittle) {
        return ResponseEntity.status(HttpStatus.FOUND).body(ideaService.findIdeaByTittle(id, tittle));
    }

    @PutMapping("/user/{id}/idea/{idIdea}")
    public ResponseEntity<Account> updateIdea(@PathVariable UUID id, @PathVariable Long idIdea, @RequestBody IdeaRequest ideaRequest) {
        ideaService.updateIdeaInfo(id, idIdea, ideaRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.getAccountInfoById(id));
    }

    @PostMapping("/user/{id}/idea")
    public ResponseEntity<IdeaRequest> createNewIdea(@PathVariable UUID id, @RequestBody IdeaRequest ideaRequest) {
        ideaService.createNewIdea(id, ideaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ideaRequest);
    }

    @DeleteMapping("/user/{id}/idea/{idIdea}")
    public ResponseEntity<String> deleteIdea(@PathVariable UUID id, @PathVariable Long idIdea) {
        ideaService.removeIdea(id, idIdea);
        return ResponseEntity.status(HttpStatus.OK).body("Idea removed from your list");
    }
}
