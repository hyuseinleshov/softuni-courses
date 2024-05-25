package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.imports.ConstellationSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.validations.ValidationUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final static String FILE_CONSTELLATIONS_SEED_PATH = "src/main/resources/files/json/constellations.json";
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_CONSTELLATIONS_SEED_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder sb = new StringBuilder();
        ConstellationSeedDto[] constellationSeedDtos = this.gson.fromJson(this.readConstellationsFromFile(), ConstellationSeedDto[].class);

        for (ConstellationSeedDto constellationSeedDto : constellationSeedDtos) {
            Optional<Constellation> optional = this.constellationRepository.findByName(constellationSeedDto.getName());
            if (!this.validationUtil.isValid(constellationSeedDto) || optional.isPresent()) {
                sb.append("Invalid constellation\n");

                continue;
            }

            Constellation map = this.modelMapper.map(constellationSeedDto, Constellation.class);
            this.constellationRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported constellation %s - %s\n", map.getName(), map.getDescription()));
        }
        return sb.toString();
    }
}
