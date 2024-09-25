package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_backend.dto.PlacaRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.PlacaResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.AutenticacionService;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/placa")
    public PlacaResponseDTO placa(@RequestBody PlacaRequestDTO placaRequestDTO){

        try {
            String[] datosPlaca = autenticacionService.validarPlaca(placaRequestDTO);
            if (datosPlaca == null){
                return new PlacaResponseDTO("01","Error: Placa no encontrada","","","","","");
            }
            return new PlacaResponseDTO("00","",datosPlaca[0],datosPlaca[1],datosPlaca[2],datosPlaca[3],datosPlaca[4]);

        } catch (Exception e) {
            return new PlacaResponseDTO("99","Error: Ocurrió un problema inesperado","","","","","");
        }

    }
}
