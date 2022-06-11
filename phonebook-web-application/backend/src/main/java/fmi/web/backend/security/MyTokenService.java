package fmi.web.backend.security;

import fmi.web.backend.services.BasicService;
import fmi.web.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;


@Service
public class MyTokenService extends BasicService {

	private static final String SECURE_KEY = "KenanSecurity";
	private static final String SPLITTER = "&@";
	private static final long EXPIRE_AFTER_HOURS = 1;
	private static final SecureRandom random = new SecureRandom();

	public String generateToken(String username) {
		LocalDateTime expirationDate = LocalDateTime.now().plusHours(EXPIRE_AFTER_HOURS);

		return SECURE_KEY + SPLITTER + username + SPLITTER +
				expirationDate + SPLITTER + random.nextLong();
	}

	public boolean validateToken(String token) {
		return StringUtils.hasText(token) && token.startsWith(SECURE_KEY) && extractExpirationDate(token).isAfter(LocalDateTime.now());
	}

	public String extractUsernameFromToken(String token) {
		return token.split(SPLITTER)[1];
	}

	public LocalDateTime extractExpirationDate(String token) {
		return LocalDateTime.parse(token.split(SPLITTER)[2]);
	}

	public Long extractSecureKey(String token) {
		return Long.parseLong(token.split(SPLITTER)[3]);
	}

	public String encryptToken(String token) {
		try {
			return Base64.getEncoder()
					.encodeToString(MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			throw new Error("NO SUCH ALGORITHM SHA-256");
		}
	}

	public boolean compareTokens(String token, String encodedToken) {
		return encryptToken(token).equals(encodedToken);
	}

}
