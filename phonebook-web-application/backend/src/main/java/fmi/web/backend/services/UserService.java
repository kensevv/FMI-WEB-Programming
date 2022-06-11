package fmi.web.backend.services;

import fmi.web.backend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BasicService {
	public User getUserByUsername(String username) {
		return em.createNamedQuery(User.getUserByUsername, User.class).setParameter("username", username).getResultList().stream().findFirst().orElse(null);
	}

	public User getUserByEmail(String email) {
		return em.createNamedQuery(User.getUserByEmail, User.class).setParameter("email", email).getResultList().stream().findFirst().orElse(null);
	}

	public void createUser(User newUser) {
		em.persist(newUser);
	}
}
