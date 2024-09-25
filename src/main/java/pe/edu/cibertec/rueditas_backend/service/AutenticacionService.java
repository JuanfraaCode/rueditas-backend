package pe.edu.cibertec.rueditas_backend.service;

import pe.edu.cibertec.rueditas_backend.dto.PlacaRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarPlaca(PlacaRequestDTO placaRequestDTO) throws IOException;

}
