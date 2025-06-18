package com.course.ais.io_algafood_api.api.assembler;

import com.course.ais.io_algafood_api.api.controller.EstadoController;
import com.course.ais.io_algafood_api.api.controller.UsuarioController;
import com.course.ais.io_algafood_api.api.model.dto.output.EstadoModel;
import com.course.ais.io_algafood_api.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoModelAssembler extends RepresentationModelAssemblerSupport<Estado, EstadoModel> {

    @Autowired
    private ModelMapper modelMapper;

    public EstadoModelAssembler() {
        super(EstadoController.class, EstadoModel.class);
    }

    @Override
    public EstadoModel toModel(Estado estado) {
        EstadoModel estadoModel = createModelWithId(estado.getId(), estado);
        modelMapper.map(estado, estadoModel);

        estadoModel.add(WebMvcLinkBuilder.linkTo(EstadoController.class).withRel("estados"));

        return estadoModel;
    }

    @Override
    public CollectionModel<EstadoModel> toCollectionModel(Iterable<? extends Estado> entities) {
        return super.toCollectionModel(entities).add(WebMvcLinkBuilder.linkTo(EstadoController.class).withSelfRel());
    }

}