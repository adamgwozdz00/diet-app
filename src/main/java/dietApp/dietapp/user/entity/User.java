package dietApp.dietapp.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Size(min = 3, max = 20, message = "username should be between 3 and 20 characters long ")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    private String name;

    @Size(min = 6, message = "password too short")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "enabled")
    private boolean active = true;
    //By default
    private String roles = "USER";

}
