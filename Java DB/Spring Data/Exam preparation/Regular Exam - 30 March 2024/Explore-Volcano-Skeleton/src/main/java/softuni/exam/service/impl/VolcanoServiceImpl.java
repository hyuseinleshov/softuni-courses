package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String FILE_VOLCANOES_SEED_PATH = "src/main/resources/files/json/volcanoes.json";
    private final VolcanoRepository volcanoRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.volcanoRepository = volcanoRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_VOLCANOES_SEED_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();

        VolcanoSeedDto[] volcanoSeedDtos = this.gson.fromJson(this.readVolcanoesFileContent(), VolcanoSeedDto[].class);

        for (VolcanoSeedDto volcanoSeedDto : volcanoSeedDtos) {
            Optional<Volcano> optional = this.volcanoRepository.findByName(volcanoSeedDto.getName());

            if (!this.validationUtil.isValid(volcanoSeedDto) || optional.isPresent()) {
                sb.append("Invalid volcano\n");

                continue;
            }

            Volcano map = this.modelMapper.map(volcanoSeedDto, Volcano.class);
            map.setCountry(this.countryRepository.findById(volcanoSeedDto.getCountry()).get());
            this.volcanoRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported volcano %s of type %s\n", map.getName(), map.getVolcanoType()));
        }

        return sb.toString();
    }

    @Override
    public String exportVolcanoes() {
        return this.volcanoRepository.findAllByElevationGreaterThanAndLastEruptionIsNotNullAndIsActiveTrueOrderByElevationDesc(3000)
                .stream()
                .map(v -> String.format("Volcano: %s\n"
                        + "   *Located in: %s\n"
                        + "   **Elevation: %d\n"
                        + "   ***Last eruption on: %s\n",
                        v.getName(), v.getCountry().getName(),
                        v.getElevation(), v.getLastEruption()))
                .collect(Collectors.joining());
    }
}