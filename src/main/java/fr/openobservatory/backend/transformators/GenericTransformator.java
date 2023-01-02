package fr.openobservatory.backend.transformators;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GenericTransformator<M, D> {

  private static ModelMapper modelMapper;

  public static ModelMapper modelMapper() {
    if (modelMapper == null) {
      modelMapper = new ModelMapper();
    }
    return modelMapper;
  }

  public D modelToDto(M model, Class<D> type) {
    return modelMapper().map(model, type);
  }

  public M dtoToModel(D dto, Class<M> type) {
    return modelMapper().map(dto, type);
  }

  public List<D> modelsToDtos(List<M> models, Class<D> type) {
    return models.stream().map(x -> modelToDto(x, type)).toList();
  }

  public List<M> dtosToModels(List<D> dtos, Class<M> type) {
    return dtos.stream().map(x -> dtoToModel(x, type)).toList();
  }
}
