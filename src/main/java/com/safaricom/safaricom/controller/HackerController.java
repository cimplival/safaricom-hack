package com.safaricom.safaricom.controller;

import com.safaricom.safaricom.model.Hacker;
import com.safaricom.safaricom.repository.HackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
 
 
@RestController
@RequestMapping("/api")
public class HackerController {

    @Autowired
    HackerRepository hackerRepository;

    @GetMapping("/hackers")
    public List<Hacker> getAllHackers() {
        return hackerRepository.findAll();
    }

    @GetMapping("/hackers/{id}")
    public ResponseEntity<Hacker> getHackerById(@PathVariable(value = "id") Long hackerId) {
        Hacker hacker = hackerRepository.findByName(hackerId);
        if(hacker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(hacker);
    }

    // Create a hacker
    @PostMapping("/hacker")
    public Hacker createHacker(@Valid @RequestBody Hacker hacker) {
        return hackerRepository.save(hacker);
    }

    @PutMapping("/hackers/{id}")
    public ResponseEntity<Hacker> updateHacker(@PathVariable(value = "id") Long hackerId,
                                           @Valid @RequestBody Hacker hackerDetails) {
        Hacker hacker = hackerRepository.findByName(hackerId);
        if(hacker == null) {
            return ResponseEntity.notFound().build();
        }
        hacker.setName(hackerDetails.getName());
        hacker.setPhone(hackerDetails.getPhone());

        Hacker updatedHacker = hackerRepository.save(hacker);
        return ResponseEntity.ok(updatedHacker);
    }

    @DeleteMapping("/hackers/{id}")
    public ResponseEntity<Hacker> deleteHacker(@PathVariable(value = "id") Long hackerId) {
        Hacker hacker = hackerRepository.findByName(hackerId);
        if(hacker == null) {
            return ResponseEntity.notFound().build();
        }

        hackerRepository.delete(hacker);
        return ResponseEntity.ok().build();
    }
}
