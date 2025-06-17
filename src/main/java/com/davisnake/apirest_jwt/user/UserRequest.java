package com.davisnake.apirest_jwt.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    int id;
    String userName;
    String firstName;
    String lastName;
    String country;
}
