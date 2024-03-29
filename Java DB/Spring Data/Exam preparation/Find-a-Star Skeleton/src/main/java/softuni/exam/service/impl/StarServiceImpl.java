package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.imports.StarSeedDto;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.validations.ValidationUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StarServiceImpl implements StarService {
    private static final String FILE_SEED_STARS_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_SEED_STARS_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();
        StarSeedDto[] starSeedDtos = this.gson.fromJson(this.readStarsFileContent(), StarSeedDto[].class);

        for (StarSeedDto starSeedDto : starSeedDtos) {
            Optional<Star> optional = this.starRepository.findByName(starSeedDto.getName());
            if (!this.validationUtil.isValid(starSeedDto) || optional.isPresent()) {
                sb.append("Invalid star\n");

                continue;
            }

            Star map = this.modelMapper.map(starSeedDto, Star.class);
            map.setConstellation(this.constellationRepository.getById(starSeedDto.getConstellation()));
            this.starRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported star %s - %.2f light years\n", map.getName(), map.getLightYears()));
        }
        return sb.toString();
    }

    @Override
    public String exportStars() {
        return this.starRepository.findAllByStarTypeAndAstronomersIsEmptyOrderByLightYears(StarType.RED_GIANT)
                .stream()
                .map(s -> String.format("Star: %s\n" +
                        "   *Distance: %.2f light years\n" +
                        "   **Description: %s\n" +
                        "   ***Constellation: %s\n",
                        s.getName(), s.getLightYears(), s.getDescription(), s.getConstellation().getName()
                ))
                .collect(Collectors.joining());
    }
}
