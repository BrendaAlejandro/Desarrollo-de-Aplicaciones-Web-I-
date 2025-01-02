package pe.edu.i202030205.alejandro_brenda.dto;

public record CarDto(Integer carId,
                     String ownerName,
                     String ownerContact,
                     String color,
                     Integer mileage,
                     String insuranceCompany,
                     String insurancePolicyNumber) {
}
