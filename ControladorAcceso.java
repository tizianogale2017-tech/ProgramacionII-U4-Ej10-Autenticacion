package Ejercicio10_Autenticacion;

public class ControladorAcceso {
    public boolean iniciarSesion(MecanismoAutenticacion mecanismo, String identificador, String credencial) {
        boolean ok = mecanismo.validarIdentidad(identificador, credencial);
        System.out.printf("%-22s usuario '%s': %s%n", mecanismo.getClass().getSimpleName(),
                identificador, ok ? "ACCESO CONCEDIDO" : "ACCESO DENEGADO");
        return ok;
    }
}
