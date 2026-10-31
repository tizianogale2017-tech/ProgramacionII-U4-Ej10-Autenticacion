package Ejercicio10_Autenticacion;

import java.util.Set;

public class AuthOAuthProveedor implements MecanismoAutenticacion {
    private static final Set<String> PROVEEDORES_CONFIABLES = Set.of("google", "github", "facebook");
    private final String proveedor;

    public AuthOAuthProveedor(String proveedor) {
        this.proveedor = proveedor.toLowerCase();
    }

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {
        // El token válido tiene la forma "<proveedor>-token-<algo>".
        return PROVEEDORES_CONFIABLES.contains(proveedor)
                && credencial != null
                && credencial.startsWith(proveedor + "-token-")
                && credencial.length() > (proveedor + "-token-").length();
    }
}
