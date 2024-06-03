package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}
