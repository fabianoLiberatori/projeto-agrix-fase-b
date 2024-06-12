package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Crop;

/**
 * Methords fromEntity'n'toDTO by Crop.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId
) {

  /**
   * Returns by Entity to DTO.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId()
    );
  }

  /**
   * Returns by DTO to Entity.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
}
