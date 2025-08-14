package com.application.voting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vote_options")
public class VoteOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String desc;
    private int votes;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

}
