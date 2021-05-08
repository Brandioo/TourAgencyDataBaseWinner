package com.internet.base.application.service;

import com.internet.base.application.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public Client addUser(Client users);

    public List<Client> getUsers();

    public ResponseEntity<?> getUserById(Long usersId);

    public ResponseEntity<?> updateUser(Long usersId, Client userRequest);

    public ResponseEntity<?> deleteUser(Long userId);

    Long save(SaveUsersRequest request);

}
