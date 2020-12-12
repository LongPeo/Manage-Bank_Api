package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Nguoi")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "socmt")
    @NotNull(message = "Card number is not null")
    private String cardNumber;

    @Column(name = "ngaysinh")
    @NotNull(message = "Date of birth is not null")
    private Date ngaySinh;

    @Column(name = "email")
    @NotNull(message = "Email is not null")
    private String email;

    @Column(name = "sodienthoai")
    @NotNull(message = "Phone number is not null")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diachiid", referencedColumnName = "id")
    @NotNull(message = "Address is not null")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenid", referencedColumnName = "id")
    @NotNull(message = "Name is not null")
    private FullName fullName;
}
