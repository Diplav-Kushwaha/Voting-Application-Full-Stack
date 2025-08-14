package com.application.voting.repo;

import com.application.voting.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepo extends JpaRepository<Poll, Integer> {
}
