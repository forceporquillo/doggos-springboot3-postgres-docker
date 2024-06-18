package dev.forcecodes.doggos;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
interface DoggosMapper {

  List<DoggosDto> doggosDtoToDoggos(List<Doggos> doggos);
}
