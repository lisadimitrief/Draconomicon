package com.draconomicon.api;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.draconomicon.api.config.Rank;
import com.draconomicon.api.model.User;
import com.draconomicon.api.repository.UserRepository;
import com.draconomicon.api.service.UserService;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Random;

@SpringBootTest
class UserServiceTests {

	@Test
	void testGetUser() {
		UserService userService = new UserService();
		UserRepository userRepository = mock(UserRepository.class);
		userService.setUserRepository(userRepository);

		long id = new Random().nextLong();

		when(userRepository.findById(id)).thenReturn(Optional.of(User.builder().username("toto").mail("toto@gmail.com").role(Rank.USER).build()));
		
		Optional<User> userOptional = userService.getUser(id);

		Assert.assertTrue(userOptional.isPresent());
		User user = userOptional.get();
		Assert.assertEquals("toto", user.getUsername());
		Assert.assertEquals("toto@gmail.com", user.getMail());
		Assert.assertEquals(Rank.USER, user.getRole());
	}

	@Test
	void testUpdateUser() {
		UserService userService = new UserService();
		UserRepository userRepository = mock(UserRepository.class);
		userService.setUserRepository(userRepository);

		User currentUser = User.builder().username("toto").mail("toto@gmail.com").role(Rank.USER).build();
		User userUpdate = User.builder().mail("tata@gmail.com").age(25).build();

		userService.updateUser(currentUser, userUpdate);

		verify(userRepository).save(argThat(x -> (
			x.getUsername() == "toto" &&
			x.getMail() == "tata@gmail.com" &&
			x.getAge() == 25 &&
			x.getRole() == Rank.USER)));
	}

}
