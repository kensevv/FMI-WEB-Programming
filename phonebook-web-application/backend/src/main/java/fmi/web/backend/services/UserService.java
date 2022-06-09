package fmi.web.backend.services;

import fmi.web.backend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BasicService {
	public User getUserByUsername(String username) {
		return em.createNamedQuery(User.getUserByUsername, User.class).setParameter("username", username).getSingleResult();
	}
}
