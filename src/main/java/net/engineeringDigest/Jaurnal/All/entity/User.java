package net.engineeringDigest.Jaurnal.All.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id ;
    @Indexed(unique = true)
    @NonNull
    private String UserName;
    @NonNull
    private String password;


}

