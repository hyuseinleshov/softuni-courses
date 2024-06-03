package bg.softuni.pathfinder.mapper;

import bg.softuni.pathfinder.dto.RegisterDto;
import bg.softuni.pathfinder.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "fullName", source = "fullname")
    UserEntity toUserEntity(RegisterDto registerDto);
}
