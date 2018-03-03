package com.safaricom.safaricom.repository;

import com.safaricom.safaricom.model.Hacker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HackerRepository extends JpaRepository<Hacker, Integer> {
	public Hacker findByName(String name);
}

 