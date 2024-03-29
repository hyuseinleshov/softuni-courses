package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.imports.AstronomerSeedDto;
import softuni.exam.models.dto.imports.AstronomerSeedRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.validations.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static final String FILE_ASTRONOMERS_SEED_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_ASTRONOMERS_SEED_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(AstronomerSeedRootDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        AstronomerSeedRootDto astronomerSeedRootDto = (AstronomerSeedRootDto) unmarshaller.unmarshal(new File(FILE_ASTRONOMERS_SEED_PATH));

        for (AstronomerSeedDto astronomer : astronomerSeedRootDto.getAstronomers()) {
            Optional<Astronomer> optionalAstronomer = this.astronomerRepository.findByFirstNameAndLastName(astronomer.getFirstName(), astronomer.getLastName());
            Optional<Star> optionalStar = this.starRepository.findById(astronomer.getStarId());
            if (!this.validationUtil.isValid(astronomer) || optionalAstronomer.isPresent() || optionalStar.isEmpty()) {
                sb.append("Invalid astronomer\n");

                continue;
            }

            Astronomer map = this.modelMapper.map(astronomer, Astronomer.class);
            this.astronomerRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported astronomer %s %s - %.2f\n", astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours()));
        }
        return sb.toString();
    }
}
