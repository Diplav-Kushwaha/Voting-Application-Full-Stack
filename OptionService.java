package com.application.voting.service;

import com.application.voting.entity.VoteOptions;
import com.application.voting.repo.OptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepo optionRepo;

    public List<VoteOptions> getAllOptions(){
        return optionRepo.findAll();
    }
    public void createVote(int optionId){
        VoteOptions voteOptions = optionRepo.findById(optionId).orElseThrow();
        voteOptions.setVotes(voteOptions.getVotes()+1);
        optionRepo.save(voteOptions);

    }

}
