package fmi.web.backend.services;

import fmi.web.backend.entity.User;
import fmi.web.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public void createUser(User newUser) {
		userRepository.save(newUser);
	}
}
