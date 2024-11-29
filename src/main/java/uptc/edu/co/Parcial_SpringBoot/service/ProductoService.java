package uptc.edu.co.Parcial_SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.Parcial_SpringBoot.entityes.Cliente;
import uptc.edu.co.Parcial_SpringBoot.entityes.Producto;
import uptc.edu.co.Parcial_SpringBoot.repository.ClienteRepository;
import uptc.edu.co.Parcial_SpringBoot.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoService(){}

    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
}
