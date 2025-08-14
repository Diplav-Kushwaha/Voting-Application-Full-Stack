package com.application.voting.controller;


import com.application.voting.entity.VoteOptions;
import com.application.voting.entity.Poll;
import com.application.voting.entity.PollData;
import com.application.voting.service.OptionService;
import com.application.voting.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;
    @Autowired
    private OptionService optionService;

    @GetMapping("/api")
    public String homePage(Model model){
        model.addAttribute("polls", pollService.getAllPolls());
        return "index";
    }
    @GetMapping("/poll/{id}")
    public String viewPoll(@PathVariable int id, Model model){
        Poll poll = pollService.getPollById(id);
        if (poll == null) {
            return "redirect:/api";
        }
        model.addAttribute("poll", poll);
        return "poll";
    }
    @PostMapping("/api/poll")
    public String createPoll(@RequestParam("question") String question, @RequestParam("option") List<String> options) {

        Poll poll = new Poll();
        poll.setQuestion(question);

        List<VoteOptions> optionEntities = new java.util.ArrayList<>();
        for (String text : options) {
            if (text == null || text.trim().isEmpty()) continue;
            VoteOptions o = new VoteOptions();
            o.setDesc(text.trim());
            o.setVotes(0);
            o.setPoll(poll);
            optionEntities.add(o);
        }
        poll.setVoteOptionsList(optionEntities);
        pollService.createPoll(poll);
        return "redirect:/api";
    }

    @PostMapping("/api/vote")
    public String createVote(int optionId){
        optionService.createVote(optionId);

        return "redirect:/api";
    }
    @GetMapping("/poll/{id}/results")
    public String pollResults(@PathVariable int id, Model model){
        model.addAttribute("poll", pollService.getPollById(id));

        return "results";
    }
}
