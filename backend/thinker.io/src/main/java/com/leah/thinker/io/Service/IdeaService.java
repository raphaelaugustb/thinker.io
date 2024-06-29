package com.leah.thinker.io.Service;

import com.leah.thinker.io.Request.IdeaRequest;
import com.leah.thinker.io.entity.Account;
import com.leah.thinker.io.entity.Idea;
import com.leah.thinker.io.repository.AccountRepository;
import com.leah.thinker.io.repository.IdeaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdeaService {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    IdeaRepository ideaRepository;

    public void createNewIdea(UUID id, IdeaRequest ideaRequest) {
        Account account = accountService.getAccountInfoById(id);
        if (account == null) {
            throw new RuntimeException("Conta não encontrada");
        } else {
            Idea idea = new Idea();
            idea.setTittle(ideaRequest.getTittle());
            idea.setDescription(ideaRequest.getDescription());
            account.getIdeiaList().add(idea);
            ideaRepository.save(idea);
            accountRepository.save(account);
        }
    }
    public void removeIdea(UUID id, Long idIdea){
        Account account = accountService.getAccountInfoById(id);
        Idea ideaDelete = ideaRepository.getById(idIdea);
        if ( account == null){
            throw new RuntimeException("Conta não encontrada");
        } else {
            account.getIdeiaList().remove(ideaDelete);
            ideaRepository.delete(ideaDelete);
            accountRepository.save(account);
        }
    }
    public List<Idea> listIdeasAccount(UUID id){
        Account account = accountService.getAccountInfoById(id);
        return account.getIdeiaList();
    }
    public void updateIdeaInfo(UUID id,Long idIdea,  IdeaRequest ideaRequest) {
        Account account = accountService.getAccountInfoById(id);
        Idea ideaUpdate = ideaRepository.findById(idIdea).get();
        if (account == null) {
            throw new RuntimeException("Conta não encontrada");
        } else {
            ideaUpdate.setTittle(ideaRequest.getTittle());
            ideaUpdate.setDescription(ideaRequest.getDescription());
            ideaUpdate.setFinished(ideaRequest.isFinished());
            ideaRepository.save(ideaUpdate);
        }
    }
}
