import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + año +
                '}';
    }

    public Fecha() {
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean verificar(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.año,this.mes,this.dia);
        gregorianCalendar.setLenient(false);
        try{
            gregorianCalendar.get(Calendar.DAY_OF_MONTH);
            gregorianCalendar.get(Calendar.MONTH);
            gregorianCalendar.get(Calendar.YEAR);
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Fecha invalida");
            throw new RuntimeException();

        }

        return true;

    }

    public Fecha(int dia, int mes, int año) {


        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.verificar();
    }

    public Fecha sumarDia(){
        this.verificar();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.año,this.mes,this.dia);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH,1);
        return new Fecha(gregorianCalendar.get(Calendar.DAY_OF_MONTH),gregorianCalendar.get(Calendar.MONTH),gregorianCalendar.get(Calendar.YEAR));
    }

    public static void main(String[] args) {
        Fecha fecha = new Fecha(3,3,2021);
        fecha.verificar();

        Fecha fecha2 = new Fecha(1,2,2021);
        fecha2.verificar();

        System.out.println(fecha);

        System.out.println(fecha2.sumarDia());

        System.out.println(fecha2.dayOfWeek());

        Fecha fecha3 = new Fecha(38,2,2021);
        fecha3.verificar();


    }

    public String dayOfWeek(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.año,this.mes,this.dia);
        return "Dia: "+gregorianCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
    }
}
