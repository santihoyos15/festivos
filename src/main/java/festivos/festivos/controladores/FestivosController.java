package festivos.festivos.controladores;

import festivos.festivos.services.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/festivos")
public class FestivosController {
    @Autowired
    FestivoService festivoService;

    @GetMapping("/es-festivo/{dia}/{mes}/{anio}")
    public boolean esFestivo (@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        return festivoService.esFestivo(dia, mes, anio);
    }
}