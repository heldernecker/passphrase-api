package com.necker.passphrasegen;

public class PassphraseDto {
    private String passphrase;

    public PassphraseDto(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }
}
