package dietApp.dietapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)

    private String username;

    private String name;

    private String password;

    @Transient

    private String confirmPassword;

    @Column(name = "enabled")
    private boolean active = true;
    //By default
    private String roles = "USER";

//    public User(String username, String name, String password, String roles) {
//        this.username = username;
//        this.name = name;
//        this.password = password;
//        this.roles = roles;
//    }
}
