package uptc.edu.co.Parcial_SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.Parcial_SpringBoot.entityes.Cliente;
import uptc.edu.co.Parcial_SpringBoot.entityes.Producto;
import uptc.edu.co.Parcial_SpringBoot.repository.ClienteRepository;
import uptc.edu.co.Parcial_SpringBoot.repository.ProductoRepository;
import uptc.edu.co.Parcial_SpringBoot.repository.VentaRepository;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public VentaService(){}

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public boolean validarStock(Producto producto, int cantidad){
        return producto.getStock() >= cantidad;
    }

    public void updateStock(Producto producto, int cantidad){
        producto.setStock(producto.getStock()-cantidad);
        productoRepository.save(producto);
    }
}
