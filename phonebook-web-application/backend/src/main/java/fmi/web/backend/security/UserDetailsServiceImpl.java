package fmi.web.backend.security;

import fmi.web.backend.entity.User;
import fmi.web.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetailsImpl loadUserByUsername(String username) {
		User user = userService.getUserByUsername(username);
		if (null == user) {
			return null;
		}
		return new UserDetailsImpl(user);
	}
}