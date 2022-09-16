package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Getter
@Setter

public class Usuario {
    @Id
    private String nameUser;

    @Column
    private String password;
    @Column
    private String namePeople;

    public Usuario() {
    }

    public Usuario(String nameUser, String password, String namePeople) {
        this.nameUser = nameUser;
        this.password = password;
        this.namePeople = namePeople;
    }
}
