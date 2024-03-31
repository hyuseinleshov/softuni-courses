package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String FILE_COUNTRIES_SEED_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_COUNTRIES_SEED_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountrySeedDto[] countrySeedDtos = this.gson.fromJson(this.readCountriesFromFile(), CountrySeedDto[].class);

        for (CountrySeedDto countrySeedDto : countrySeedDtos) {
            Optional<Country> optional = this.countryRepository.findByName(countrySeedDto.getName());

            if (!this.validationUtil.isValid(countrySeedDto) || optional.isPresent()) {
                sb.append("Invalid country\n");

                continue;
            }

            Country map = this.modelMapper.map(countrySeedDto, Country.class);
            this.countryRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported country %s - %s\n", map.getName(), map.getCapital()));
        }

        return sb.toString();
    }
}
