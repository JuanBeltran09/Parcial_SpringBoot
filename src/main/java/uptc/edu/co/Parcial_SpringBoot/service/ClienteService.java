package uptc.edu.co.Parcial_SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.Parcial_SpringBoot.entityes.Cliente;
import uptc.edu.co.Parcial_SpringBoot.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(){}

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
