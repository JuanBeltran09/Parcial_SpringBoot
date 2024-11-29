package uptc.edu.co.Parcial_SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.Parcial_SpringBoot.entityes.Producto;
import uptc.edu.co.Parcial_SpringBoot.handling.ResponseHandler;
import uptc.edu.co.Parcial_SpringBoot.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Object> getProductos() {
        try {
            List<Producto> result = productoService.getProductos();
            return new ResponseHandler().generateResponse("Productos obtenidos con éxito", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse("Error al obtener los productos", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Producto producto) {
        if (producto == null) {
            return new ResponseHandler().generateResponse("Producto no puede ser nulo", HttpStatus.BAD_REQUEST, null);
        }
        try {
            Producto result = productoService.save(producto);
            return new ResponseHandler().generateResponse("Producto creado con éxito", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
