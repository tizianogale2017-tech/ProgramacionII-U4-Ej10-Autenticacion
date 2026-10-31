package Ejercicio10_Autenticacion;

import java.util.HashMap;
import java.util.Map;

public class AuthBiometrica implements MecanismoAutenticacion {
    private static final int COINCIDENCIA_MINIMA = 90;
    private final Map<String, String> huellasRegistradas = new HashMap<>();

    public void registrarHuella(String usuario, String plantilla) {
        huellasRegistradas.put(usuario, plantilla);
    }

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {
        String registrada = huellasRegistradas.get(identificador);
        if (registrada == null || credencial == null) {
            return false;
        }
        int iguales = 0;
        int largo = Math.min(registrada.length(), credencial.length());
        for (int i = 0; i < largo; i++) {
            if (registrada.charAt(i) == credencial.charAt(i)) {
                iguales++;
            }
        }
        return registrada.length() > 0 && iguales * 100 / registrada.length() >= COINCIDENCIA_MINIMA;
    }
}
