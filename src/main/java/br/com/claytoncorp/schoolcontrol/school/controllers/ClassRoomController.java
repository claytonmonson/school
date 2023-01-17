package br.com.claytoncorp.schoolcontrol.school.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claytoncorp.schoolcontrol.school.dtos.ClassRoomDto;
import br.com.claytoncorp.schoolcontrol.school.models.ClassRoomModel;
import br.com.claytoncorp.schoolcontrol.school.services.ClassRoomService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {

	final ClassRoomService classRoomService;

	public ClassRoomController(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	@GetMapping
	public ResponseEntity<List<ClassRoomModel>> getAllClassRooms() {
		return ResponseEntity.status(HttpStatus.OK).body(classRoomService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneClassRoom(@PathVariable(value = "id") UUID id) {
		Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findById(id);
		if (!classRoomModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(classRoomModelOptional.get());
	}

	@PostMapping
	public ResponseEntity<Object> saveClassRoom(@RequestBody @Valid ClassRoomDto classRoomDto) {

		if (classRoomService.existsByNumberRoom(classRoomDto.getNumberRoom())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This room is already in use!");
		}

		var classRoomModel = new ClassRoomModel();
		BeanUtils.copyProperties(classRoomDto, classRoomModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(classRoomService.save(classRoomModel));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClassRoom(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ClassRoomDto classRoomDto) {
		Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findById(id);
		if (!classRoomModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom not found.");
		}
		var classRoomModel = new ClassRoomModel();
		BeanUtils.copyProperties(classRoomDto, classRoomModel);
		classRoomModel.setId(classRoomModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(classRoomService.save(classRoomModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClassRoom(@PathVariable(value = "id") UUID id) {
		Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findById(id);
		if (!classRoomModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom not found.");
		}
		classRoomService.delete(classRoomModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Classroom deleted successfully.");
	}

}
