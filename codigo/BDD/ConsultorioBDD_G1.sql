/*Se crea y se usa la base de datos*/
drop database if exists consultorio;
create database consultorio;
use consultorio;

/*Se crean las tablas que serán utilizadas*/
create table odontologo(
	idOdontologo int unsigned not null,
	apellido varchar(30),
	nombre varchar(30),
	matricula varchar(20),
	mail varchar(50),
	primary key(idOdontologo)
);

create table paciente(
	idPaciente int unsigned,
	apellido varchar(30),
	nombre varchar(30),
	dni varchar(10),
	mail varchar(50),
	primary key(idPaciente)
);

create table horario(
	idOdontologo int unsigned not null,
	diaSemana int,
	horaInicio time,
	horaFin time,
	primary key(idOdontologo, diaSemana, horaInicio),
	foreign key(idOdontologo) references odontologo(idOdontologo)
);

create table turno(
	idTurno int unsigned auto_increment,
	idPaciente int unsigned,
	idOdontologo int unsigned not null,
	isTratamiento boolean,
	fecha date,
	hora time,
	primary key(idTurno),
	foreign key(idPaciente) references paciente(idPaciente),
	foreign key(idOdontologo) references horario(idOdontologo)
);

/*Se insertan los valores de los odontólogos y sus respectivos horarios*/
insert into odontologo values(1, "Vasquez", "Edmundo", "46343", "vasquezdrmundolol@mail.com");
insert into odontologo values(2, "Van Bothoven", "Ludwig", "27482", "drludwigvanbothoventf2@mail.com");
insert into odontologo values(3, "Taylor", "Roger", "78336", "drrogerqueentaylor@mail.com");
insert into odontologo values(4, "Ziegler", "Angela", "19216", "ziegleroangela@mail.com");
insert into odontologo values(5, "Valentine", "Vincent", "33844", "valentinevincent@mail.com");

insert into horario values(1, 1, "8:00", "12:30");
insert into horario values(1, 2, "8:00", "12:30");
insert into horario values(1, 3, "8:00", "12:30");

insert into horario values(2, 1, "9:30", "14:00");
insert into horario values(2, 3, "9:30", "14:00");
insert into horario values(2, 5, "9:30", "14:00");

insert into horario values(3, 2, "10:00", "15:00");
insert into horario values(3, 4, "10:00", "15:00");
insert into horario values(3, 6, "10:00", "15:00");

insert into horario values(4, 4, "8:00", "16:00");
insert into horario values(4, 5, "8:00", "16:00");

insert into horario values(5, 1, "10:00", "12:00");
insert into horario values(5, 2, "10:00", "12:00");
insert into horario values(5, 3, "10:00", "12:00");
insert into horario values(5, 4, "10:00", "12:00");
insert into horario values(5, 5, "10:00", "12:00");


/*Creamos las funciones y procedimientos a utilizar*/
delimiter $$

drop function if exists isDiaLaborable $$
create function isDiaLaborable(idO int unsigned,diaIngresado int)
	returns boolean
begin
	DECLARE done INT DEFAULT FALSE;
    declare isLaboral boolean;
    declare nDia int;
	DECLARE cur1 CURSOR FOR SELECT diaSemana from horario where idOdontologo = idO;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	OPEN cur1;
		WHILE done = FALSE DO
			FETCH cur1 INTO nDia;
			IF nDia = diaIngresado THEN
			  set isLaboral = true;
              set done = true;
			END IF;
		END WHILE;
  CLOSE cur1;
  return isLaboral;
end$$


/*Esta función devuelve la siguiente fecha que corresponda a cada odontólogo, teniendo en cuenta cuáles son los días de semana en los que trabaja.*/
drop function if exists fechaSiguiente $$
create function fechaSiguiente(idO int unsigned,ultimoTurno date )
	returns int 
begin
	/* Recomendación: Usar el idO (idOdontologo) para saber qué días trabaja y que días no */
	declare nextFecha date;
	declare diaUTurno int;
    declare diasTranscuridos int default 0;
    declare diaSemana int;
    declare  done boolean DEFAULT false;
	set diaUTurno = date_format(ultimoTurno, "%w");
    set diaSemana = diaUTurno; 
    
    /*tengo que recorrer todos los dias desde el que termino hasta el primero que trabaje y contar cuantos dias pasaron para despues sumarselo al ultimoTurno*/
    
    while !done do 
		set diaSemana = diaSemana + 1;
        set diasTranscuridos = diasTranscuridos + 1;
		if diaSemana > 6 then 
			set diaSemana = 0;
		end if;
        if isDiaLaborable(idO,diaSemana) then 
			set done = true;
        end if;
	end while;
    
	set nextFecha =  DATE_ADD(ultimoTurno, INTERVAL diasTranscuridos DAY) ;
	return nextFecha;
end$$

/*Este procedimiento genera turnos a partir de la última fecha. Requiere la cantidad de días que deseamos y el ID del odontólogo*/
drop procedure if exists generarTurnos$$
create procedure generarTurnos(in cantDias int, in idO int unsigned)
begin
	declare ultimoTurno date;
	declare fechaActual date;
	declare horaIni time;
	declare durTurno time;
	declare horaMax time;
	declare contador int;
	set contador = 0;
	set durTurno = "0:30";
	while contador < cantDias do
		set ultimoTurno = (select max(fecha) from turno where turno.idOdontologo = idO);
		if ultimoTurno is null then
			set ultimoTurno = current_date();
		end if;
		set fechaActual = fechaSiguiente(idO, ultimoTurno);
		set horaIni = (select horaInicio from horario where horario.idOdontologo = idO and horario.diaSemana = date_format(fechaActual, "%w"));
		set horaMax = (select horaFin from horario where horario.idOdontologo = idO and horario.diaSemana = date_format(fechaActual, "%w"));
		while horaIni < horaMax do
			insert into turno(idOdontologo, isTratamiento, fecha, hora) values(idO, false, fechaActual, horaIni);
			set horaIni = addtime(horaIni, durTurno);
		end while;
		set contador = contador + 1;
	end while;
end$$

delimiter ;