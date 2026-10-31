package Ejercicio10_Autenticacion;

public interface MecanismoAutenticacion {
    boolean validarIdentidad(String identificador, String credencial);
}
