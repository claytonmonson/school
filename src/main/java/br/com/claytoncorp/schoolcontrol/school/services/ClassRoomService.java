package br.com.claytoncorp.schoolcontrol.school.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.claytoncorp.schoolcontrol.school.models.ClassRoomModel;
import br.com.claytoncorp.schoolcontrol.school.repositories.ClassRoomRepository;
import jakarta.transaction.Transactional;

@Service
public class ClassRoomService {

	final ClassRoomRepository classRoomRepository;

	public ClassRoomService(ClassRoomRepository classRoomRepository) {
		this.classRoomRepository = classRoomRepository;
	}

	@Transactional
	public ClassRoomModel save(ClassRoomModel classRoomModel) {
		return classRoomRepository.save(classRoomModel);
	}

	public boolean existsByNumberRoom(String numberRoom) {
		return classRoomRepository.existsByNumberRoom(numberRoom);
	}

	public List<ClassRoomModel> findAll() {
		return classRoomRepository.findAll();
	}

	public Optional<ClassRoomModel> findById(UUID id) {
		return classRoomRepository.findById(id);
	}

	@Transactional
	public void delete(ClassRoomModel classRoomModel) {
		classRoomRepository.delete(classRoomModel);
	}

}
