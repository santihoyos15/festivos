package festivos.festivos.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tipo {
    @Id
    private Integer id;
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo1 = (Tipo) o;
        return Objects.equals(id, tipo1.id) && Objects.equals(tipo, tipo1.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }
}
