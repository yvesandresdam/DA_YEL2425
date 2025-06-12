package andres.flights_v2.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//  =============================
//  TODO
//    INDICE DEL CODIGO
//    0._package / imports
//    1._NamedQueries
//    2._Entidad Table airport
//      2.1_Columnas
//      2.2_Getters/Setters
//  =============================
//

// TODO                                                    ■ Capitulo 1 _NamedQueries
// ■                                                       Contiene las Select definidas
// ■                                                       por el diseñador.
// ¤
@NamedQueries(
        {
                @NamedQuery(
                        name="AirportEntity.columnCode",
                        query="SELECT code FROM AirportEntity"
                ),
                @NamedQuery(
                        name="AirportEntity.columnName",
                        query="SELECT name FROM AirportEntity"
                )
        }
)

// TODO                                                    ■ Capitulo 2 _Entidad
// ■                                                       Contiene la descripcion de la
// ■                                                       entidad.
// ═
@Entity
@Table(name = "airports")
public class AirportEntity {
    // TODO                                                ■ Capitulo 2.1 _Entidad
    // ■                                                   En este capitulo se describe
    // ■                                                   la definicion de la entidad.
    // ═
    @Id
    @NotBlank
    @Size(max = 4)
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @Size(max = 100)
    @NotBlank
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    // TODO                                                ■ Capitulo 2.2 Getters / Setters
    // ■                                                   Aqui se definen los getters
    // ■                                                   y setters de los atributos de clase.
    // ═
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}