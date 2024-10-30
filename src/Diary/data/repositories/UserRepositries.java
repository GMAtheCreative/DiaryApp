package Diary.data.repositories;

import Diary.data.models.User;

public interface UserRepositries {
    void registerUser(User user);
    boolean isLocked(User user);
    void updateUser(User user, User updatedUser);
    void deleteUser(User user);

    void lock(User user);

    void unLock(User user);

    int count();

}
