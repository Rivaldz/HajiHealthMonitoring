package com.valdo.hajihealthmonitoring.model;

public class RegisterModel {
    String nama, email,noHp,pass;

    public RegisterModel(String nama, String email, String noHp, String pass) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", noHp='" + noHp + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
