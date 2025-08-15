package net.engineeringDigest.Jaurnal.All.service;

import net.engineeringDigest.Jaurnal.All.entity.JournalEntry;
import net.engineeringDigest.Jaurnal.All.reposotory.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveJournalEntry(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);

    }


   public List<JournalEntry> getAll() {

        return journalEntryRepo.findAll();
    }


    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id) {
        journalEntryRepo.deleteById(id);
    }


}
