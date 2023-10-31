package com.example.gachoncrpytouserservice.user.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private int studentId;

    public static User createUser(int studentId, String name){
        return User.builder()
                .name(name)
                .studentId(studentId)
                .build();
    }
}
