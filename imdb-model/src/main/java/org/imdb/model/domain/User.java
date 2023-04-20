package org.imdb.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @NonNull
    private String email;
    @NonNull
    private String nickName;
}