package Diary.data.repositories;

import Diary.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositriesImplTest {
    private UserRepositries userRepositries;
    @BeforeEach
    void setUp() {
        userRepositries = new UserRepositriesImpl();
    }

    @Test
    void testToRegisterUser() {
        User user = new User("tim","correctPasword");
        userRepositries.registerUser(user);
        assertEquals(1, userRepositries.count());
    }
    @Test
    void testUserCreatedIsUnlocked() {
        User user = new User("tim","correctPassword");
        assertFalse(userRepositries.isLocked(user));
    }
    @Test
    void testToDeleteUser() {
        User user = new User("tim","correctPasword");
        userRepositries.registerUser(user);
        userRepositries.deleteUser(user);
        assertEquals(0, userRepositries.count());
    }
    @Test
    void testUserCanBeLocked() {
        User user = new User("tim","correctPassword");
        userRepositries.lock(user);
        assertTrue(userRepositries.isLocked(user));
    }
    @Test
    void testUserCanBeUnlocked() {
        User user = new User("tim","correctPassword");
        userRepositries.unLock(user);
        assertFalse(userRepositries.isLocked(user));
    }
    @Test
    void testUserCanBeUpdated() {
        User user = new User("tim","correctPassword");
        userRepositries.registerUser(user);
        User updatedUser = new User("tim","correctedPassword");
        userRepositries.updateUser(user,updatedUser);
        assertEquals("correctedPassword",user.getPassword());

    }
}