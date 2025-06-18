package com.course.ais.io_algafood_api.api.model.dto.output;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Setter
@Getter
@Relation(collectionRelation = "cidades") // Define o nome da coleção e do item na representação HATEOAS
public class CidadeModel extends RepresentationModel<CidadeModel> {

    private Long id;
    private String nome;
    private EstadoModel estado;

}