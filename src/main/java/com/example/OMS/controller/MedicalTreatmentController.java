package com.example.OMS.controller;

import com.example.OMS.model.MedicalTreatment;
import com.example.OMS.service.MedicalTreatmentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/treatments")
public class MedicalTreatmentController {
    private final MedicalTreatmentService medicalTreatmentService;

    public MedicalTreatmentController(MedicalTreatmentService medicalTreatmentService) {
        this.medicalTreatmentService = medicalTreatmentService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<MedicalTreatment> createMedicalRecord(@RequestBody MedicalTreatment medicalTreatment,
                                                                @PathVariable Long patientId){
        MedicalTreatment createdMedicalTreatment = medicalTreatmentService.createMedicalTreatment(medicalTreatment,
                patientId);
        return ResponseEntity.ok(createdMedicalTreatment);
    }

}
