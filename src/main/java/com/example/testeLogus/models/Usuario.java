package com.example.testeLogus.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cadusuarios")
public class Usuario{
    @Id
    @Column(name = "idcadusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "dcr_usuario", nullable = false, length = 45)
    private String usuario;

    @Column(name = "dcr_login", nullable = false, length = 45)
    private String login;

    @Column(name = "dcr_senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "dat_cadastro", nullable = false)
    private LocalDate datCadastro;

    @Column(name = "dat_desativacao")
    private LocalDate datDesativar;

    public Usuario(){

    }

    public Usuario(Integer codigo, String usuario, String login, String senha) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.login = login;
        this.senha = senha;
        LocalDate agora = LocalDate.now();
        this.datCadastro = agora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDatCadastro() {
        return datCadastro;
    }

    public void setDatCadastro(LocalDate datCadastro) {
        this.datCadastro = datCadastro;
    }

    public LocalDate getDatDesativar() {
        return datDesativar;
    }

    public void setDatDesativar(LocalDate datDesativar) {
        this.datDesativar = datDesativar;
    }

    }


