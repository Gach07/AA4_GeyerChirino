public class Cuenta {
    private String codCuenta;
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas = 0;

    // Constructor con saldo
    public Cuenta(double pSaldo) {
        this("SinNombre", pSaldo);
    }

    // Constructor con nombre y saldo
    public Cuenta(String pNombreCuentaHabiente, double pSaldo) {
        cantCuentasCreadas++;
        this.codCuenta = "C" + cantCuentasCreadas;
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
        this.saldo = pSaldo;
        this.fechaCreacion = java.time.LocalDate.now().toString();
        this.cantDepositosRealizados = 0;
        this.cantRetirosExitososRealizados = 0;
    }

    public void setNombreCuentaHabiente(String pNombreCuentaHabiente) {
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            cantDepositosRealizados++;
        }
        return saldo;
    }

    public double retirar(double monto) {
        if (validarRetiro(monto)) {
            saldo -= monto;
            cantRetirosExitososRealizados++;
        }
        return saldo;
    }

    public boolean validarRetiro(double monto) {
        return saldo >= monto;
    }

    public static int getCantCuentasCreadas() {
        return cantCuentasCreadas;
    }

    public String toString() {
        return "Codigo: " + codCuenta +
               "\nNombre: " + nombreCuentaHabiente +
               "\nSaldo: " + saldo +
               "\nFecha de creacion: " + fechaCreacion +
               "\nDepositos realizados: " + cantDepositosRealizados +
               "\nRetiros exitosos: " + cantRetirosExitososRealizados;
    }
}