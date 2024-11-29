package uptc.edu.co.Parcial_SpringBoot.entityes;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false, length = 30)
    private String phone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

    public Cliente() {}

    public Cliente(Long id, String name, String phone, List<Venta> ventas) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ventas = ventas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
