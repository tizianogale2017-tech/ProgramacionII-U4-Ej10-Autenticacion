package Ejercicio10_Autenticacion;

import java.util.HashMap;
import java.util.Map;

public class AuthPasswordTradicional implements MecanismoAutenticacion {
    private final Map<String, Integer> hashesPorUsuario = new HashMap<>();

    public void registrar(String usuario, String password) {
        // Se guarda un hash, nunca la contraseña en texto plano (simulación didáctica).
        hashesPorUsuario.put(usuario, password.hashCode());
    }

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {
        Integer hash = hashesPorUsuario.get(identificador);
        return hash != null && credencial != null && hash == credencial.hashCode();
    }
}
