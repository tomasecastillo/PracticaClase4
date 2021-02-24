public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador) {
        this.numerador = numerador;
        denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "numerador=" + numerador +
                ", denominador=" + denominador +
                '}';
    }

    public Fraccion sumar(Fraccion fraccion) {

        int mcm = mcm(this.denominador, fraccion.getDenominador());
        int divisorFraccion1 = mcm / this.denominador;
        int divisorFraccion2 = mcm / fraccion.getDenominador();
        int multiploFraccion1 = divisorFraccion1 * this.numerador;
        int multiploFraccion2 = divisorFraccion2 * fraccion.getNumerador();
        Fraccion suma = new Fraccion();
        suma.setNumerador(multiploFraccion1 + multiploFraccion2);
        suma.setDenominador(mcm);
        return suma;
    }

    public Fraccion sumar(int entero) {

        return this.sumar(new Fraccion(entero, 1));
    }

    public Fraccion restar(Fraccion fraccion) {

        int mcm = mcm(this.denominador, fraccion.getDenominador());
        int divisorFraccion1 = mcm / this.denominador;
        int divisorFraccion2 = mcm / fraccion.getDenominador();
        int multiploFraccion1 = divisorFraccion1 * this.numerador;
        int multiploFraccion2 = divisorFraccion2 * fraccion.getNumerador();
        Fraccion suma = new Fraccion();
        suma.setNumerador(multiploFraccion1 - multiploFraccion2);
        suma.setDenominador(mcm);
        return suma;
    }

    public Fraccion restar(int entero) {

        return this.restar(new Fraccion(entero, 1));
    }

    public Fraccion multiplicar(Fraccion fraccion) {

        Fraccion multiplicacion = new Fraccion();
        multiplicacion.setDenominador(this.denominador * fraccion.getDenominador());
        multiplicacion.setNumerador(this.numerador * fraccion.getNumerador());

        return multiplicacion;
    }

    public Fraccion multiplicar(int entero) {

        return this.multiplicar(new Fraccion(entero, 1));
    }

    public Fraccion dividir(Fraccion fraccion) {

        return this.multiplicar(new Fraccion(fraccion.denominador, fraccion.numerador));
    }

    public Fraccion dividir(int entero) {

        return this.dividir(new Fraccion(entero, 1));
    }

    private int mcm(int num1, int num2) {
        int mcm = 1;
        int i = 2;
        while (i <= num1 || i <= num2) {
            if (num1 % i == 0 || num2 % i == 0) {
                mcm = mcm * i;
                if (num1 % i == 0) num1 = num1 / i;
                if (num2 % i == 0) num2 = num2 / i;
            } else
                i = i + 1;
        }
        return mcm;
    }

    public static void main(String[] args) {
        Fraccion fraccion1 = new Fraccion(1,2);
        Fraccion fraccion2 = new Fraccion(3,4);

        System.out.println(fraccion1.sumar(fraccion2));
        System.out.println(fraccion1.restar(fraccion2));
        System.out.println(fraccion1.dividir(fraccion2));
        System.out.println(fraccion1.multiplicar(fraccion2));
        System.out.println(fraccion1.sumar(5));
        System.out.println(fraccion1.restar(5));
        System.out.println(fraccion1.multiplicar(5));
        System.out.println(fraccion1.dividir(5));

    }
}