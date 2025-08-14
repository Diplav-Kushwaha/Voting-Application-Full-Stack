package com.application.voting.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PollData {
    private String question;
    private List<String> options;
}
