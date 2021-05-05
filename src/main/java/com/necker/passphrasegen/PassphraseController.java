package com.necker.passphrasegen;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassphraseController {

    PassphraseService service = new PassphraseService();

    @CrossOrigin
    @GetMapping("/passphrase")
    public String getPassphrase(@RequestParam int length) {
        return service.generatePassphrase(length);
    }
}
