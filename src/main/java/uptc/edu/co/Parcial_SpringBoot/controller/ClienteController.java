package uptc.edu.co.Parcial_SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.Parcial_SpringBoot.entityes.Cliente;
import uptc.edu.co.Parcial_SpringBoot.handling.ResponseHandler;
import uptc.edu.co.Parcial_SpringBoot.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Cliente cliente){

        try{
            Cliente result = clienteService.save( cliente );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getClientes(){

        try{
            List<Cliente> result = clienteService.getClientes();

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        }catch(Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){

        try {
            clienteService.deleteById(id);
            return new ResponseHandler().generateResponse("Cliente eliminado con éxito", HttpStatus.OK, null);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }
}
