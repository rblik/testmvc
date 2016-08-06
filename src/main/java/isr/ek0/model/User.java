package isr.ek0.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by JBlik on 04.08.2016.
 */
@Entity
@Table(name = "user")
public class User {

    private int id;
    private String name;
    private Integer age;
    private boolean admin;
    private Date createdDate;

    public User() {
    }

    public User(String name, int age, boolean admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    @Size(min = 3, max = 10)
    @NotNull
    @Pattern(regexp = "\\D*")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "isAdmin")
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Column(name = "createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
