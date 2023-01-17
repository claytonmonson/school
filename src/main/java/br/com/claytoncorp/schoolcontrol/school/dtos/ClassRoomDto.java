package br.com.claytoncorp.schoolcontrol.school.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClassRoomDto {

	@NotBlank
	private String numberRoom;
	@NotNull
	private int freePlaces;
	@NotNull
	private int occupiedPlaces;
	@NotNull
	private int limitPlaces;

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
