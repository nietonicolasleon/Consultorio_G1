package controlador;

import java.util.ArrayList;
import java.util.List;

public class agendaTest {

    public static void main(String[] args) {
        List<Turno> turnos = new ArrayList();
        Turno turnoUno = new Turno(1, 30);
        Turno turnoDos = new Turno(2, 15);
        turnos.add(turnoUno);
        turnos.add(turnoDos);
        List<Turno> turnosDos = new ArrayList();
        Turno turnoTres = new Turno(1, 30);
        Turno turnoCuatro = new Turno(2, 15);
        turnosDos.add(turnoTres);
        turnosDos.add(turnoCuatro);

        Agenda agenda = new Agenda(turnos);
        getAllAgendas(agenda);
    }

    public static void getAllAgendas(Agenda agenda) {
        List<Agenda> allAgendas = new ArrayList();
        allAgendas.add(agenda);

        for (Agenda agendas : allAgendas) {
            System.out.println("agendas = " + agendas.toString());
        }

        /*       allAgendas.forEach(agendaImpresa -> {

            System.out.println("agendaImpresa = " + agendaImpresa);

        });*/
    }
}
