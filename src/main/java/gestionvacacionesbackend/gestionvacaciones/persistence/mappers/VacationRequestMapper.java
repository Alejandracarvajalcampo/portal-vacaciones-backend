package gestionvacacionesbackend.gestionvacaciones.persistence.mappers;

import gestionvacacionesbackend.gestionvacaciones.domain.dto.VacationRequest;
import gestionvacacionesbackend.gestionvacaciones.persistence.entities.VacationRequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacationRequestMapper {
        @Mapping(target = "document", ignore = true)
        List<VacationRequest> toVacationRequest (List<VacationRequestEntity> vacationRequestEntities);

        @Mapping(target = "document", ignore = true)
        VacationRequest toVacationRequest (VacationRequestEntity vacationRequestEntity);

        VacationRequestEntity toVacationRequestEntity (VacationRequest vacationRequest);
    }

