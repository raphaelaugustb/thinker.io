package com.leah.thinker.io.Service;

import com.leah.thinker.io.dto.request.IdeaRequest;
import com.leah.thinker.io.entity.Account;
import com.leah.thinker.io.entity.Idea;
import com.leah.thinker.io.exception.IdeaNotFoundException;
import com.leah.thinker.io.exception.InvalidRequestException;
import com.leah.thinker.io.repository.AccountRepository;
import com.leah.thinker.io.repository.IdeaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdeaService {

    AccountService accountService;

    AccountRepository accountRepository;

    public IdeaService(AccountService accountService, AccountRepository accountRepository, IdeaRepository ideaRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.ideaRepository = ideaRepository;
    }

    IdeaRepository ideaRepository;

    public void createNewIdea(UUID idUser, IdeaRequest ideaRequest) {
        Account account = accountService.getAccountInfoById(idUser);
        Idea idea = new Idea();
        if (ideaRequest.tittle() == null || ideaRequest.description() == null)
            throw new InvalidRequestException("Fields cannot be null");
        if (!ideaRequest.isFinished()) {
            idea.setFinished(true);
        }
        idea.setTittle(ideaRequest.tittle());
        idea.setDescription(ideaRequest.description());
        account.getIdeiaList().add(idea);
        ideaRepository.save(idea);
        accountRepository.save(account);

    }

    public void removeIdea(UUID idUser, Long idIdea) {
        Account account = accountService.getAccountInfoById(idUser);
        Idea ideaDelete = ideaRepository.findById(idIdea).orElseThrow(() -> new IdeaNotFoundException("Idea not found on user documents"));
        account.getIdeiaList().remove(ideaDelete);
        ideaRepository.delete(ideaDelete);
        accountRepository.save(account);
    }

    public List<Idea> findIdeaByTittle(UUID idUser, String tittle) {
        Account account = accountService.getAccountInfoById(idUser);
        List<Idea> ideaList = null;
        for (Idea idea : account.getIdeiaList()) {
            if (idea.getTittle().equals(tittle)) {
                ideaList.add(idea);
            }
        }
        if (ideaList.isEmpty())
            throw new IdeaNotFoundException("nome matches with title on user documents");
        return ideaList;
    }

    public List<Idea> listIdeasAccount(UUID idUser) {
        return accountService.getAccountInfoById(idUser).getIdeiaList();
    }

    public void updateIdeaStatus(UUID idUser, Long idIdea) {
        Idea idea = ideaRepository.findById(idIdea).orElseThrow(() -> new IdeaNotFoundException("Idea not found on user documents"));
        idea.setFinished(true);
        ideaRepository.save(idea);
    }

    public void updateIdeaInfo(UUID id, Long idIdea, IdeaRequest ideaRequest) {
        Idea ideaUpdate = ideaRepository.findById(idIdea).orElseThrow(() -> new IdeaNotFoundException("Idea not found on user documents"));
        if (ideaRequest.tittle() == null || ideaRequest.description() == null)
            throw new InvalidRequestException("Fields cannot be null");
        ideaUpdate.setTittle(ideaRequest.tittle());
        ideaUpdate.setDescription(ideaRequest.description());
        ideaUpdate.setFinished(ideaRequest.isFinished());
        ideaRepository.save(ideaUpdate);

    }
}
