package modelo;

import android.util.Log;

import java.util.Arrays;

public class PlazoFijo {

    private Integer dias;
    private Double monto;
    private Boolean avisarVencimiento;
    private Boolean renovarAutomaticamente;
    private Moneda moneda;
    private String[] tasas;
    private Cliente cliente;

    public PlazoFijo(String[] tasas) {
        Log.d("APP_01", tasas+"");
        Log.d("APP_01", Arrays.toString(tasas));
        this.tasas=tasas;
        this.monto=0.0;
        this.dias=0;
        this.avisarVencimiento=false;
        this.renovarAutomaticamente=false;
        this.moneda=Moneda.PESO;
    }

    public Integer getDias() {
        return dias;
    }


    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double m) {
        this.monto = m;
    }

    public Boolean getAvisarVencimiento() {
        return avisarVencimiento;
    }

    public void setAvisarVencimiento(Boolean avisarVencimiento) {
        this.avisarVencimiento = avisarVencimiento;
    }

    public Boolean getRenovarAutomaticamente() {
        return renovarAutomaticamente;
    }

    public void setRenovarAutomaticamente(Boolean renovarAutomaticamente) {
        this.renovarAutomaticamente = renovarAutomaticamente;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String[] getTasas() {
        return tasas;
    }

    public void setTasas(String[] tasas) {
        this.tasas = tasas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double calcularTasa(){

        if(this.dias<30 && this.monto<=5000){
            return 25.0;
        }
        else if(this.dias>=30 && this.monto<=5000){
            return 27.5;
        }
        else if(this.dias<30 && this.monto>5000 && this.monto<=99999){
            return 30.0;
        }
        else if(this.dias>=30 &&  this.monto>5000 && this.monto<=99999){
            return 32.3;
        }else if(this.dias<30 &&  this.monto>99999) {
            return 35.0;
        } else return  38.5;
    }

    public Double intereses(){
        Double i, temp;
        Double base, exp;
        base = 1+this.calcularTasa()/100;
        exp = (double) (this.dias) /360;
        temp = Math.pow(base,exp);
        i = this.monto*(temp-1);
        return i;
    }
    @Override
    public String toString() {
        return "PlazoFijo{" +
                "dias=" + dias +
                ", monto=" + monto +
                ", avisarVencimiento=" + avisarVencimiento +
                ", renovarAutomaticamente=" + renovarAutomaticamente +
                ", moneda=" + moneda +
                ", tasas=" + Arrays.toString(tasas) +
                ", cliente=" + cliente +
                '}';
    }
}
