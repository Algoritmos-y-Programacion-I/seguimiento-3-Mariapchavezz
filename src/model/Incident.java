
package model;
import java.time.LocalDate;

public class Incident { 

    private LocalDate dateReport; 
    private String descripcion; 
    private boolean solucion; 
    private int solucionHoras;

    public incident (LocalDate dateReport, String descripcion) {
        this.dateReport = dateReport; 
        this.descripcion = descripcion; 
    }

    public LocalDate getDateReport() {
        return dateReport;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public boolean getSolucion () {
        return solucion;
    }

    public int getSolucionHoras () {
        return solutionHoras;
    }

    public void setDateReport(LocalDate dateReport) {
        this.DateReport = dateReport; 
    }

    public void setDescripcion(String descriptcion) {
        this.Descripcion = descripcion; 
    }

    public void setSolucion(boolean solucion){
        this.Solucion = solucion;
    }

    public void setSolutionHours(int solucionHours) {
        this.SolucionHours = solucionHours;
    }
}
﻿
    
}
