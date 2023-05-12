package com.hedima.frontback.controladores;


import com.hedima.frontback.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorUsuarios {

    private List<Usuario> usuarios = new ArrayList<>();
    private boolean primearavez = true;
    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model modelo){
        if(primearavez) {
            usuarios.add(new Usuario(1, "Raul Gómez", "rg@gmail.com"));
            usuarios.add(new Usuario(2, "Ana Flores", "af@gmail.com"));
            usuarios.add(new Usuario(3, "Gonzalo Cruz", "gc@gmail.com"));
            primearavez = false;
        }
        modelo.addAttribute("usuarios", usuarios);


        return "usuarios";
    }
    @GetMapping("usuario/nuevo")
    public String mostrarFormulario(Model modelo){
        modelo.addAttribute("usuario",new Usuario());
        return "formularioUsuario";
    }

    @PostMapping("usuario/usuario/guardar")
    public String guardarFormulario(Usuario usuario, RedirectAttributes ra){
        System.out.println(usuario.toString());
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }
}
