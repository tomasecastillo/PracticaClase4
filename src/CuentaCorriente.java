public class CuentaCorriente {
    private long numeroCuenta;
    private int numeroCaja;
    private int dni;
    private double saldo;
    private String nombre;

    public CuentaCorriente(long numeroCuenta, int numeroCaja, int dni, double saldo, String nombre) {
        this.numeroCuenta = numeroCuenta;
        this.numeroCaja = numeroCaja;
        this.dni = dni;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(CuentaCorriente c) {
        this.numeroCuenta = c.getNumeroCuenta();
        this.numeroCaja = c.getNumeroCaja();
        this.dni = c.getDni();
        this.saldo = c.getSaldo();
        this.nombre = c.getNombre();
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double ingreso ( double cantidad){
        this.setSaldo(this.getSaldo()+cantidad);
        return this.getSaldo();
    }

    public double egreso ( double cantidad){
        if(this.getSaldo()>cantidad)
            this.setSaldo(this.getSaldo()-cantidad);
        else
            System.out.println("Saldo insuficiente");
        return this.getSaldo();
    }

    public double reintegro (double cantidad){
        return ingreso(cantidad);
    }

    public double transferencia (CuentaCorriente c1,   double monto){
        if(this.getSaldo()>=monto){
            c1.setSaldo(c1.getSaldo()+monto);
            this.setSaldo(this.getSaldo()-monto);
        }else{
            System.out.println("No se puede realizar la transferencia, saldo insuficiente");
        }
        return monto;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "numeroCuenta=" + numeroCuenta +
                ", numeroCaja=" + numeroCaja +
                ", dni=" + dni +
                ", saldo=" + saldo +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public static void main (String [] args){
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(1,1,123,100,"Tomas");
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(2,1,434,50,"Pepe");
        CuentaCorriente cuentaCorriente3 = new CuentaCorriente(cuentaCorriente1);
        cuentaCorriente3.ingreso(1000);
        cuentaCorriente1.egreso(10);
        cuentaCorriente2.transferencia(cuentaCorriente1,100);
        cuentaCorriente2.transferencia(cuentaCorriente1,20);
        System.out.println(cuentaCorriente1);
        System.out.println(cuentaCorriente2);
        System.out.println(cuentaCorriente3);

    }


}
