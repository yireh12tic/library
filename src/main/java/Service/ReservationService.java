package Service;

import Repository.ReservationRepository;
import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        } else{
            Optional<Reservation> reservationEncontrada =  reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationEncontrada.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation  reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (!reservationEncontrado.isEmpty()){
                if (reservation.getStartDate() != null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null){
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationEncontrado.get());
            }
        }
        return  reservation;
    }
    public boolean delete(int id){
        Boolean respuesta = getReservation(id).map(elemento -> {
            reservationRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
