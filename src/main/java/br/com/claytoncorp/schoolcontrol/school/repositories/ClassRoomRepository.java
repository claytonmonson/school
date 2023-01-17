package br.com.claytoncorp.schoolcontrol.school.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.claytoncorp.schoolcontrol.school.models.ClassRoomModel;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomModel, UUID> {

	boolean existsByNumberRoom(String numberRoom);

}
