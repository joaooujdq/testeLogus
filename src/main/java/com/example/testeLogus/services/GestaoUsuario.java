package com.example.testeLogus.services;

import com.example.testeLogus.dtos.UsuarioDTO;
import com.example.testeLogus.models.Usuario;
import com.example.testeLogus.repositories.UsuarioDAO;
import com.example.testeLogus.services.exceptions.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GestaoUsuario {
    private UsuarioDAO usuarioDAO;

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAll(Pageable pageable) {
        Page<Usuario> result = usuarioDAO.findAll(pageable);
        return result.map(obj -> new UsuarioDTO(obj));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Integer id) {
        Usuario result = usuarioDAO.findById(id).orElseThrow(() -> new BusinessException("Registros não encontrados"));
        return new UsuarioDTO(result);
    }

    @Transactional(readOnly = true)
    public boolean existById(Integer id) {
        return usuarioDAO.existsById(id);
    }

    @Transactional
    public UsuarioDTO update(UsuarioDTO obj) {
        Usuario entity = usuarioDAO.findById(obj.getCodigo()).orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
        entity.setUsuario(obj.getUsuario());
        entity.setLogin(obj.getLogin());
        entity.setSenha(obj.getSenha());
        entity.setDatCadastro(obj.getDatCadastro());
        entity.setDatDesativar(obj.getDatDesativar());
        return new UsuarioDTO(usuarioDAO.save(entity));
    }

    @Transactional
    public UsuarioDTO save(Usuario obj) {
        boolean loginExists = usuarioDAO.findByLogin(obj.getLogin()).stream().anyMatch(objResult -> !objResult.equals(obj));
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasDigit = digit.matcher(obj.getSenha());
        Matcher hasSpecial = special.matcher(obj.getSenha());
        if(obj.getSenha()=="" || obj.getUsuario()=="" || obj.getLogin()==""){
            throw new BusinessException("Os campos com * são obrigatórios!");
        }else if(obj.getSenha().length() < 8 && hasDigit.find() && hasSpecial.find()){
            throw new BusinessException("A senha deve ter no mínimo 8 caracteres, 1 número e 1 símbolo.");
        } else if (loginExists) {
            throw new BusinessException("Login já existente!");
        }
        return new UsuarioDTO(usuarioDAO.save(obj));
    }

    @Transactional
    public void deleteById(Integer id) {
        usuarioDAO.deleteById(id);
    }

    public GestaoUsuario(final UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
