package festivos.festivos.services;

import festivos.festivos.models.Festivo;
import festivos.festivos.repositories.FestivoRepository;
import festivos.festivos.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class FestivoServiceImpl implements FestivoService {

    @Autowired
    FestivoRepository festivoRepository;

    @Autowired
    TipoRepository tipoRepository;

    @Override
    public boolean esFestivo(Integer dia, Integer mes, Integer anio) {
        List<Festivo> festivos = festivoRepository.findAll();

        LocalDate date = LocalDate.of(anio, mes, dia);

        LocalDate domingoPascua = this.calcularDomingoPascua(anio);

        for (Festivo festivo : festivos) {
            if (festivo.getIdtipo() == 1 && festivo.getDia().equals(dia) && mes.equals(festivo.getMes())) {
                return true;
            } else if (festivo.getIdtipo() == 2) {
                LocalDate festivoProximoLunes = LocalDate.of(anio, festivo.getMes(), festivo.getDia()).with(TemporalAdjusters.next(DayOfWeek.MONDAY));

                if (festivoProximoLunes.equals(date)) {
                    return true;
                }
            } else if (festivo.getIdtipo() == 3) {
                LocalDate festivoCalculado = domingoPascua.plusDays(festivo.getDiaspascua());

                if (festivoCalculado.equals(date)) {
                    return true;
                }
            } else if (festivo.getIdtipo() == 4) {
                LocalDate festivoCalculado = domingoPascua.plusDays(festivo.getDiaspascua()).with(TemporalAdjusters.next(DayOfWeek.MONDAY));

                if (festivoCalculado.equals(date)) {
                    return true;
                }
            }
        }

        return false;
    }

    private LocalDate calcularDomingoPascua(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        return LocalDate.of(year, 3, 15 + 7).plusDays(dias);
    }
}
