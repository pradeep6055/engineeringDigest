package net.engineeringDigest.Jaurnal.All.reposotory;

import net.engineeringDigest.Jaurnal.All.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.SpringDataMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {


}
