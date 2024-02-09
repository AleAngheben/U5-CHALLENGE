package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void save(User user){

        userDAO.save(user);
        System.out.println("Congratulazioni, USER salvato con successo !");

    }

}
