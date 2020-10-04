package AppUserDAO;

import AppUser.AppUser;

import java.util.HashSet;

public interface AppUserDao {

    HashSet<AppUser> getAll();

    void saveUser(AppUser user);

    void deleteUser(AppUser user);

    AppUser getUserById(Long id);

    AppUser getUserByEmail(String email);

    HashSet<AppUser> getFollowedUsers (AppUser loggedUser);

    HashSet<AppUser> getNotFollowedUsers(AppUser loggedUser);

    HashSet<AppUser> getFollowers (AppUser loggedUser);

    void follow(AppUser logged, AppUser userToFollow);

    void unfollow(AppUser logged, AppUser userToFollow);



}
