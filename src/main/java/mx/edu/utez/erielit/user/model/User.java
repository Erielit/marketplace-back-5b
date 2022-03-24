package mx.edu.utez.erielit.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.erielit.person.model.Person;
import mx.edu.utez.erielit.role.model.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

    public User() {
    }

    public User(String username, String password, Set<Role> roles, Person person) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.person = person;
    }

    public User(long id, String username, String password, Set<Role> roles, Person person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
