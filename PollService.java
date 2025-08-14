package com.application.voting.service;

import com.application.voting.entity.Poll;
import com.application.voting.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepo pollRepo;

    public List<Poll> getAllPolls(){
        return pollRepo.findAll();
    }
    public Poll getPollById(int id){
        return pollRepo.findById(id).orElse(null);
    }
    public void createPoll(Poll poll){
        pollRepo.save(poll);
    }
}
