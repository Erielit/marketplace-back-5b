package mx.edu.utez.erielit.contact.controller;

import mx.edu.utez.erielit.utils.EmailService;
import mx.edu.utez.erielit.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"*"})
public class ContactController {
    @Autowired
    EmailService sender;

    @PostMapping("/")
    public ResponseEntity<Message> sendMail(@RequestBody EmailDTO email) {
        if (sender.sendContactMail(email)) {
            return new ResponseEntity<>(new Message("Correo electrónico enviado correctamente", false, null),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Erorr al enviar el correo", true, null),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
