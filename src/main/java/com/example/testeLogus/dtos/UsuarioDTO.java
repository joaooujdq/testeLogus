package com.example.testeLogus.dtos;

import com.example.testeLogus.models.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.tomcat.jni.Local;
import org.springframework.hateoas.RepresentationModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonPropertyOrder({"idcadusuario", "dcr_usuario", "dcr_login", "dcr_senha", "dat_cadastro", "dat_desativar"})
public class UsuarioDTO extends RepresentationModel<UsuarioDTO>  {
    
    @JsonProperty("idcadusuario")
    private Integer codigo;
    
    @NotBlank
    @JsonProperty("dcr_usuario")
    private String usuario;

    @NotBlank
    @JsonProperty("dcr_login")
    private String login;

    @NotBlank
    @JsonProperty("dcr_senha")
    private String senha;
    
    @JsonProperty("dat_cadastro")
    private LocalDate datCadastro;

    @JsonProperty("dat_desativar")
    private LocalDate datDesativar;
    
    public UsuarioDTO(){

    }

    public UsuarioDTO(Usuario obj) {
        codigo = obj.getCodigo();
        usuario = obj.getUsuario();
        login = obj.getLogin();
        senha = obj.getSenha();
        datCadastro = obj.getDatCadastro();
        datDesativar = obj.getDatDesativar();
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
