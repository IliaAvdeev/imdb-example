package org.imdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private UUID id;
    @NonNull
    private String email;
    @NonNull
    private String nickName;
}