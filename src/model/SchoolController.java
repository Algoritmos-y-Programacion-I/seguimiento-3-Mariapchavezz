package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolController {

    private ArrayList<Computer> computers = new ArrayList<>();
    private Computer[][] building;
/**
     * Constructor de la clase SchoolController que crea la matriz del edificio con 5 pisos y 10 columnas
     */
    public SchoolController() {
        building = new Computer[5][10];
    }
/**
     * Descripción: Registra un computador nuevo en el piso indicado y busca la primera columna libre
     * Precondición: El serial debe ser único y el piso debe estar entre 0 y 4
     * Postcondición: El computador se guarda en el ArrayList y en la matriz
     * @param serialNumber El número serial del computador
     * @param floor El piso donde se va a ubicar
     */
    public void agregarComputador(String serialNumber, int floor) {
        if (floor < 0 || floor >= 5) {
            System.out.println("Error: El piso debe estar entre 0 y 4");
            return;
        }

        for (int i = 0; i < computers.size(); i++) {
            Computer pc = computers.get(i);
            if (pc.getSerialNumber().equals(serialNumber)) {
                System.out.println("Error: Ya existe un computador con ese serial");
                return;
            }
        }

        int columnaDisponible = -1;
        for (int col = 0; col < 10; col++) {
            if (building[floor][col] == null) {
                columnaDisponible = col;
                break;
            }
        }

        if (columnaDisponible == -1) {
            System.out.println("Error: No hay espacio disponible en el piso " + floor);
            return;
        }


        Computer pc = new Computer(serialNumber, floor, columnaDisponible);
        computers.add(pc);
        building[floor][columnaDisponible] = pc;
        
        System.out.println("Computador registrado en piso " + floor + ", columna " + columnaDisponible);
    }
/**
     * Descripción: Registra un incidente nuevo en un computador
     * Precondición: Debe existir un computador con ese serial
     * Postcondición: Se agrega el incidente con la fecha de hoy al computador
     * @param serialNumber El número serial del computador
     * @param description La descripción del problema
     */
    public void agregarIncidenteEnComputador(String serialNumber, String description) {
        for (int i = 0; i < computers.size(); i++) {
            Computer pc = computers.get(i);
            if (pc.getSerialNumber().equals(serialNumber)) {
                Incident nuevoIncidente = new Incident(LocalDate.now(), description);
                pc.addIncident(nuevoIncidente);
                return;
            }
        }
        System.out.println("No se encontró un computador con ese serial");
    }

     /**
     * Descripción: Muestra en pantalla la información de todos los computadores
     * Precondición: Ninguna
     * Postcondición: Se muestra el serial, piso, columna y cantidad de incidentes de cada computador
     */
    public void getComputerList() {
        for (int i = 0; i < computers.size(); i++) {
            Computer pc = computers.get(i);
            System.out.println("Serial: " + pc.getSerialNumber());
            System.out.println("Piso: " + pc.getFloor());
            System.out.println("Columna: " + pc.getColumn());
            System.out.println("Incidentes: " + pc.getTotalIncidents());
            System.out.println("----------------");
        }
    }

     /**
     * Descripción: Busca el computador que tiene más incidentes
     * Precondición: Ninguna
     * Postcondición: Retorna el computador con más incidentes, o null si nno hay computadores
     * @return El computador con más incidentes
     */
    public Computer getComputerWithMoreIncidents() {
        if (computers.size() == 0) {
            return null;
        } else {
            Computer pcMasIncidentes = computers.get(0);

            for (int i = 1; i < computers.size(); i++) {
                Computer pcActual = computers.get(i);
                if (pcActual.getTotalIncidents() > pcMasIncidentes.getTotalIncidents()) {
                    pcMasIncidentes = pcActual;
                }
            }
            return pcMasIncidentes;
        }
    }
}