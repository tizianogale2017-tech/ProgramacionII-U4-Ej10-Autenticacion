package Ejercicio10_Autenticacion;

public class Main {
    public static void main(String[] args) {
        AuthPasswordTradicional password = new AuthPasswordTradicional();
        password.registrar("tiziano", "clave123");
        AuthBiometrica biometria = new AuthBiometrica();
        biometria.registrarHuella("tiziano", "A1B2C3D4E5F6G7H8I9J0");
        MecanismoAutenticacion oauth = new AuthOAuthProveedor("google");

        ControladorAcceso controlador = new ControladorAcceso();
        controlador.iniciarSesion(password, "tiziano", "clave123");
        controlador.iniciarSesion(password, "tiziano", "otraClave");
        controlador.iniciarSesion(biometria, "tiziano", "A1B2C3D4E5F6G7H8I9J0");
        controlador.iniciarSesion(biometria, "tiziano", "ZZZZZZZZZZZZZZZZZZZZ");
        controlador.iniciarSesion(oauth, "tiziano@gmail.com", "google-token-8f3a");
        controlador.iniciarSesion(oauth, "tiziano@gmail.com", "token-falso");
    }
}
