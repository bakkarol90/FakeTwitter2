package AppUser;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String name;
    private String password;
    @Column(name = "last_name")
    private String lastName;
    @CreationTimestamp
    private Date registeredSince;
    @ManyToMany(mappedBy = "following", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Set<AppUser> follower = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "follower_followed",
            joinColumns = {@JoinColumn (name = "follower_fk")},
            inverseJoinColumns = {@JoinColumn(name = "followed_fk")})
    private Set<AppUser> following = new HashSet<>();



    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisteredSince() {
        return registeredSince;
    }

    public void setRegisteredSince(Date registeredSince) {
        this.registeredSince = registeredSince;
    }

    public Set<AppUser> getFollower() {
        return follower;
    }

    public Set<AppUser> getFollowing() {
        return following;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", following=" + following +
                ", followed=" + follower +
                ", registretedSince=" + registeredSince +
                '}';
    }

    public static class UserBuilder {
        private String name;
        private String lastName;
        private String login;
        private String password;
        private String email;
        private Date registeredSince;
        public static UserBuilder getBuilder() {
            return new UserBuilder();
        }
        public UserBuilder login(String login) {
            this.login = login;
            return this;

        }
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder registeredSince(Date dateOfRegistration) {
            this.registeredSince = dateOfRegistration;
            return this;
        }
        public AppUser build() {
            AppUser user = new AppUser();
            user.setLogin(this.login);
            user.setPassword(this.password);
            user.setName(this.name);
            user.setLastName(this.lastName);
            user.setEmail(this.email);
            user.setRegisteredSince(this.registeredSince);
            return user;
        }
    }

}
