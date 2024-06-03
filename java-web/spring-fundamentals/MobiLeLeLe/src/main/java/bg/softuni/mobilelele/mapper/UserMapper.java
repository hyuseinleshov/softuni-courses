package bg.softuni.mobilelele.mapper;

import bg.softuni.mobilelele.dto.RegisterDto;
import bg.softuni.mobilelele.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(RegisterDto registerDto);
}
