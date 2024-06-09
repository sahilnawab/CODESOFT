package com.codesoft.sloats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotReposatory extends JpaRepository<Slots, Long> {

	
}
