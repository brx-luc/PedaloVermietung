package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pedalo")
public class PedaloController {

    private final PedaloRepository pedaloRepository;

    public PedaloController(PedaloRepository pedaloRepository){
        this.pedaloRepository = pedaloRepository;
    }

    @GetMapping
    public List<Pedalo> getPedalo(){
        return pedaloRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedalo getPedalo(@PathVariable Long id){
        return pedaloRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createPedalo(@RequestBody Pedalo pedalo) throws URISyntaxException {
        Pedalo savedPedalo = pedaloRepository.save(pedalo);
        return ResponseEntity.created(new URI("/pedalo/" + savedPedalo.getId())).body(savedPedalo);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePedalo(@PathVariable Long id, @RequestBody Pedalo pedalo){
        Pedalo currentPedalo = pedaloRepository.findById(id).orElseThrow(RuntimeException::new);
        currentPedalo.setBeschreibung(pedalo.getBeschreibung());
        currentPedalo.setPlaetze(pedalo.getPlaetze());
        currentPedalo.setZusatz(pedalo.getZusatz());
        currentPedalo.setBeschreibung(pedalo.getBeschreibung());
        currentPedalo.setPreis(pedalo.getPreis());
        currentPedalo = pedaloRepository.save(currentPedalo);

        return ResponseEntity.ok(currentPedalo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePedalo(@PathVariable Long id) {
        pedaloRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
