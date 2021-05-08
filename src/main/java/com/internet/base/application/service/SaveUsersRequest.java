package com.internet.base.application.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveUsersRequest {
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
    private Date createdAt;
}
