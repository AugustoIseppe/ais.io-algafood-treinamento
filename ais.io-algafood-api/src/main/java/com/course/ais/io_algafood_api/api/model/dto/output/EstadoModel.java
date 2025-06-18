package com.course.ais.io_algafood_api.api.model.dto.output;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Setter
@Getter
@Relation(collectionRelation = "estados") //HATEOAS
public class EstadoModel extends RepresentationModel<EstadoModel> {

    private Long id;
    private String nome;

}
