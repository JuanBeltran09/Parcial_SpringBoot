package uptc.edu.co.Parcial_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.Parcial_SpringBoot.entityes.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

}
