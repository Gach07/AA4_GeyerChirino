import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalCuenta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        Cuenta cuentaActual = null;
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("0) Salir");
            System.out.println("1) Crear Cuenta");
            System.out.println("2) Ver cantidad de cuentas creadas");
            System.out.println("3) Listar cuentas");
            System.out.println("4) Seleccionar cuenta actual");
            System.out.println("5) Depositar");
            System.out.println("6) Retirar");
            System.out.println("7) Consultar saldo");
            System.out.println("8) Consultar estado de cuenta");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del cuenta-habiente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese saldo inicial: ");
                    double saldo = sc.nextDouble();
                    Cuenta nueva = new Cuenta(nombre, saldo);
                    cuentas.add(nueva);
                    System.out.println("Cuenta creada con código: " + nueva.getCodCuenta());
                    break;

                case 2:
                    System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantCuentasCreadas());
                    break;

                case 3:
                    for (Cuenta c : cuentas) {
                        System.out.println(c.getCodCuenta() + " - " + c.getSaldo());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese código de cuenta: ");
                    String cod = sc.nextLine();
                    cuentaActual = null;
                    for (Cuenta c : cuentas) {
                        if (c.getCodCuenta().equals(cod)) {
                            cuentaActual = c;
                            break;
                        }
                    }
                    if (cuentaActual != null) {
                        System.out.println("Cuenta seleccionada: " + cuentaActual.getCodCuenta());
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 5:
                    if (cuentaActual != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        double montoDep = sc.nextDouble();
                        double nuevoSaldo = cuentaActual.depositar(montoDep);
                        System.out.println("Nuevo saldo: " + nuevoSaldo);
                    } else {
                        System.out.println("No hay cuenta seleccionada.");
                    }
                    break;

                case 6:
                    if (cuentaActual != null) {
                        System.out.print("Ingrese monto a retirar: ");
                        double montoRet = sc.nextDouble();
                        double nuevoSaldo = cuentaActual.retirar(montoRet);
                        System.out.println("Nuevo saldo: " + nuevoSaldo);
                    } else {
                        System.out.println("No hay cuenta seleccionada.");
                    }
                    break;

                case 7:
                    if (cuentaActual != null) {
                        System.out.println("Saldo actual: " + cuentaActual.getSaldo());
                    } else {
                        System.out.println("No hay cuenta seleccionada.");
                    }
                    break;

                case 8:
                    if (cuentaActual != null) {
                        System.out.println("--- Estado de cuenta ---");
                        System.out.println(cuentaActual.toString());
                    } else {
                        System.out.println("No hay cuenta seleccionada.");
                    }
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}