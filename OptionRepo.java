package com.application.voting.repo;

import com.application.voting.entity.VoteOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<VoteOptions, Integer> {
}
