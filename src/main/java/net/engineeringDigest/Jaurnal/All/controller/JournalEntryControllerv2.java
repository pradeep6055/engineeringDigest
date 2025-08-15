package net.engineeringDigest.Jaurnal.All.controller;

import net.engineeringDigest.Jaurnal.All.entity.JournalEntry;
import net.engineeringDigest.Jaurnal.All.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {


    @Autowired
    private JournalEntryService JournalEntryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournalEntry> all = JournalEntryService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            JournalEntryService.saveJournalEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = JournalEntryService.findById(myId);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId myId) {
        JournalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateById(@PathVariable ObjectId id, @RequestBody JournalEntry updatedEntry) {
        JournalEntry old = JournalEntryService.findById(id).orElse(null);
        if (old != null) {
            old.setTitle(updatedEntry.getTitle() != null && !updatedEntry.getTitle().equals(" ") ? updatedEntry.getTitle() : old.getTitle());
            old.setContent(updatedEntry.getContent() != null && updatedEntry.getContent().equals("") ? updatedEntry.getContent() : old.getContent());
        }
        JournalEntryService.saveJournalEntry(old);
        return old;
    }


}
