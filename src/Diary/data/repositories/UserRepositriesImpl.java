package Diary.data.repositories;

import Diary.data.models.User;

public class UserRepositriesImpl implements UserRepositries {
    private boolean isLocked = false;
    private int count = 0;

    @Override
    public void registerUser(User user) {
        count++;
    }

    @Override
    public boolean isLocked(User user) {

        return isLocked;
    }

    @Override
    public void updateUser(User user, User updatedUser) {

    }

    @Override
    public void deleteUser(User user) {
        count--;
    }

    @Override
    public void lock(User user) {
        isLocked = true;
    }

    @Override
    public void unLock(User user) {
        isLocked = false;
    }

    @Override
    public int count() {
        return count;
    }
}
