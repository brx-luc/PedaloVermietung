package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    public ReservationController(ReservationRepository reservationRepository){ this.reservationRepository=reservationRepository;}
    @GetMapping
        public List<Reservation> getReservation(){return reservationRepository.findAll();}

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id)      {
        return reservationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createReservation(@RequestBody Reservation reservation) throws URISyntaxException{
        Reservation saveReservation = reservationRepository.save(reservation);
        return ResponseEntity.created(new URI("/reservation/" + saveReservation.getId())).body(saveReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReservation(@PathVariable Long id, @RequestBody Reservation reservation){
        Reservation currentReservation = reservationRepository.findById(id).orElseThrow(RuntimeException::new);
        currentReservation.setName(reservation.getName());
        currentReservation.setVorname(reservation.getVorname());
        currentReservation.setDatum(reservation.getDatum());
        currentReservation.setZeitpunkt(reservation.getZeitpunkt());
        currentReservation.setEmail(reservation.getEmail());
        currentReservation = reservationRepository.save(currentReservation);

        return ResponseEntity.ok(currentReservation);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
