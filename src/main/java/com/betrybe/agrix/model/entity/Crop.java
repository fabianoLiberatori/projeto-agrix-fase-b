package com.betrybe.agrix.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity by crop.
 */
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;


  public Crop() {
  }

  public Long getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
