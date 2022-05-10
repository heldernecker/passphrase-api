package com.necker.passphrasegen;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PassphraseController {

    PassphraseService service = new PassphraseService();

    @CrossOrigin
    @GetMapping("/passphrase")
    public ResponseEntity<PassphraseDto> getPassphrase(@RequestParam int length) {
        if (length > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Length has to be equal or less than 100"
            );
        }
        return new ResponseEntity<>(service.generatePassphrase(length), HttpStatus.OK);
    }
}
