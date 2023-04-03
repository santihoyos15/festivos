package festivos.festivos.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Festivo {
    @Id
    private Integer id;
    private String nombre;
    private Integer dia;
    private Integer mes;
    private Integer diaspascua;
    private Integer idtipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDiaspascua() {
        return diaspascua;
    }

    public void setDiaspascua(Integer diaspascua) {
        this.diaspascua = diaspascua;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festivo festivo = (Festivo) o;
        return Objects.equals(id, festivo.id) && Objects.equals(nombre, festivo.nombre) && Objects.equals(dia, festivo.dia) && Objects.equals(mes, festivo.mes) && Objects.equals(diaspascua, festivo.diaspascua) && Objects.equals(idtipo, festivo.idtipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, dia, mes, diaspascua, idtipo);
    }
}
