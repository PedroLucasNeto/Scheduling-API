package br.com.AlanaRetratosAgendamentos.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AlanaRetratosAgendamentos.model.Appointment;
import br.com.AlanaRetratosAgendamentos.model.User;
import br.com.AlanaRetratosAgendamentos.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	public void scheduleAppointment(Appointment appointment) {
		Appointment newAppointment = new Appointment();
		if (appointment != null) {
			newAppointment.setAppointmentType(appointment.getAppointmentType());
			newAppointment.setClientName(appointment.getClientName());
			newAppointment.setDate(null);
			appointmentRepository.save(appointment);
		}
	}

	public void deleteAppointment(Long id) throws Exception {

		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(()-> new Exception ("We're sorry. We couldn't find an appointment with this ID"+id));
			appointmentRepository.delete(appointment);
	}

	public Appointment updateAppointment(Long id, Appointment appointment) throws Exception {

		Appointment updatedAppointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new Exception("Couldn't find an appointment with this ID"+ id));
		
		updatedAppointment.setAppointmentType(appointment.getAppointmentType());
		
		
		updatedAppointment.setDate(appointment.getDate());
		updatedAppointment.setDescription(appointment.getDescription());
		appointmentRepository.save(updatedAppointment);

		return updatedAppointment;
	}

	public List<Appointment> listAppointments() {

		List<Appointment> appointmentList = (List<Appointment>) appointmentRepository.findAll();
		return appointmentList;
	}

	public Appointment findById(Long id) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		return appointment.get();
	}
	
	public List<Appointment> findByClientName(String name) {
		 List<Appointment> clientAppointments = appointmentRepository.findByClientName(name);
		 return clientAppointments;
	}

}
