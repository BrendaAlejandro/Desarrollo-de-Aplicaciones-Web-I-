package pe.edu.i202030205.alejandro_brenda.response;

import pe.edu.i202030205.alejandro_brenda.dto.CarDto;

import java.util.List;

public record GetAllCarResponse(String code,
                                String error,
                                List<CarDto> cars) {
}
