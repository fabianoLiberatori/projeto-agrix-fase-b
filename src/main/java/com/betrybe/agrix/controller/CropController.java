package com.betrybe.agrix.controller;


import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller by Crop.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Get Returns List Crops.
   */
  @GetMapping
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.findAll();
    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  @GetMapping("/{id}")
  public CropDto findById(@PathVariable("id") long id) throws CropNotFoundException {
    Crop crop = cropService.findById(id);
    return CropDto.fromEntity(crop);
  }

  /**
   * Search crops for startDate and endDate.
   */
  @GetMapping("/search")
  public List<CropDto> harvestDateByCrops(
      @RequestParam LocalDate start, @RequestParam LocalDate end
  ) {
    List<Crop> crops = cropService.searchCrops(start, end);
    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}