package uptc.edu.co.Parcial_SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.Parcial_SpringBoot.entityes.Cliente;
import uptc.edu.co.Parcial_SpringBoot.entityes.Producto;
import uptc.edu.co.Parcial_SpringBoot.entityes.Venta;
import uptc.edu.co.Parcial_SpringBoot.handling.ResponseHandler;
import uptc.edu.co.Parcial_SpringBoot.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/clientes")
    public ResponseEntity<Object> getClientes() {
        try {
            List<Cliente> result = ventaService.getClientes();
            return new ResponseHandler().generateResponse("Clientes obtenidos con éxito", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse("Error al obtener los clientes", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/productos")
    public ResponseEntity<Object> getProductos() {
        try {
            List<Producto> result = ventaService.getProductos();
            return new ResponseHandler().generateResponse("Productos obtenidos con éxito", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse("Error al obtener los productos", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
