package com.internet.base.application.service.Impl;//package com.internet.base.com.internet.base.application.service.Impl;
//
//import com.internet.base.com.internet.base.application.model.Client;
//import com.internet.base.com.internet.base.application.repository.ClientRepository;
//import com.internet.base.com.internet.base.application.service.SaveUsersRequest;
//import com.internet.base.com.internet.base.application.service.UserService;
//import lombok.var;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@Service
//public class UserServiceImpl implements UserService {
//	@Autowired
//	private ClientRepository userRepository;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Override
//	public Client addUser(Client users) {
//		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//		return userRepository.save(users);
//	}
//	@Override
//	public List<Client> getUsers() {
//		return userRepository.findAll();
//	}
//
//
//	@Override
//	public ResponseEntity<?> updateUser(Long usersId, Client userRequest) {
//		Client users = userRepository.findOne(usersId);
//		if (users != null) {
//
//			users.setEmail(userRequest.getEmail());
//			users.setName(userRequest.getName());
//			users.setSurname(userRequest.getSurname());
//
//			userRepository.save(users);
//
//			Map<String, Client> result = new HashMap<String, Client>();
//			result.put("User Updated ", users);
//			return new ResponseEntity<Map<String, Client>>(result, HttpStatus.OK);
//		} else {
//			Map<String, Long> result = new HashMap<String, Long>();
//			result.put("not found User with Id ", usersId);
//			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//		}
//	}
//	@Override
//	public ResponseEntity<?> deleteUser(Long userId) {
//		Client users = userRepository.findOne(userId);
//		if (users != null) {
//
//			userRepository.delete(users);
//
//			Map<String, Long> result = new HashMap<String, Long>();
//			result.put("Successfully deleted user with Id: ", userId);
//			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);
//
//		} else {
//			Map<String, Long> result = new HashMap<String, Long>();
//			result.put("not found User with Id ", userId);
//			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//		}
//
//	}
//
//	@Override
//	public Long save(SaveUsersRequest request) {
//		var dbClient = userRepository.findById(request.getId());
//		if (dbClient.isPresent()) {
//			dbClient.get().setEmail(request.getName());
//			dbClient.get().setName(request.getEmail());
//			userRepository.save(dbClient.get());
//			return dbClient.get().getId();
//		}
//		var newUser = Client.builder()
//				.email(request.getEmail())
//				.name(request.getName())
//				.build();
//		userRepository.save(newUser);
//		return newUser.getId();
//	}
//
//
//	@Override
//	public ResponseEntity<?> getUserById(Long usersId) {
//		Client users = userRepository.findOne(usersId);
//		if (users != null) {
//
//			Map<String, Client> result = new HashMap<String, Client>();
//			result.put("User: ", users);
//			return new ResponseEntity<Map<String, Client>>(result, HttpStatus.OK);
//
//		} else {
//			Map<String, Long> result = new HashMap<String, Long>();
//			result.put("not found User with Id ", usersId);
//			return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//		}
//	}
//
//
//
//}
