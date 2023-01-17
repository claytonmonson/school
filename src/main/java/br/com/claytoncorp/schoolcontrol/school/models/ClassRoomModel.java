package br.com.claytoncorp.schoolcontrol.school.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLASSROOM")
public class ClassRoomModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, length = 10)
	private String numberRoom;

	@Column(nullable = false, length = 2)
	private int freePlaces;

	@Column(nullable = false, length = 2)
	private int occupiedPlaces;

	@Column(nullable = false, length = 2)
	private int limitPlaces;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public void setFreePlaces(int freePlaces) {
		this.freePlaces = freePlaces;
	}

	public int getOccupiedPlaces() {
		return occupiedPlaces;
	}

	public void setOccupiedPlaces(int occupiedPlaces) {
		this.occupiedPlaces = occupiedPlaces;
	}

	public int getLimitPlaces() {
		return limitPlaces;
	}

	public void setLimitPlaces(int limitPlaces) {
		this.limitPlaces = limitPlaces;
	}

}
