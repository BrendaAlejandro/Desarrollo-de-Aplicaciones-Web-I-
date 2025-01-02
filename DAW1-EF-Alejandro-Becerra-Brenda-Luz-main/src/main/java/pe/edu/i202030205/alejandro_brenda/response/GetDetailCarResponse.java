package pe.edu.i202030205.alejandro_brenda.response;

import pe.edu.i202030205.alejandro_brenda.dto.CarDetailDto;

public record GetDetailCarResponse(String code,
                                   String error,
                                   CarDetailDto carDetailDto) {
}
