package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistSeedDto;
import softuni.exam.models.dto.VolcanologistSeedRootDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

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
public class VolcanologistServiceImpl implements VolcanologistService {
    private static final String FILE_VOLCANOLOGISTS_SEED_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoRepository volcanoRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_VOLCANOLOGISTS_SEED_PATH));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(VolcanologistSeedRootDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        VolcanologistSeedRootDto volcanologistSeedRootDto = (VolcanologistSeedRootDto) unmarshaller.unmarshal(new File(FILE_VOLCANOLOGISTS_SEED_PATH));

        for (VolcanologistSeedDto volcanologist : volcanologistSeedRootDto.getVolcanologists()) {
            Optional<Volcanologist> optionalVolcanologist = this.volcanologistRepository.findByFirstNameAndLastName(volcanologist.getFirstName(), volcanologist.getLastName());
            Optional<Volcano> optionalVolcano = this.volcanoRepository.findById(volcanologist.getExploringVolcanoId());

            if (!this.validationUtil.isValid(volcanologist) || optionalVolcanologist.isPresent() || optionalVolcano.isEmpty()) {
                sb.append("Invalid volcanologist\n");

                continue;
            }

            Volcanologist map = this.modelMapper.map(volcanologist, Volcanologist.class);
            map.setVolcano(optionalVolcano.get());
            this.volcanologistRepository.saveAndFlush(map);
            sb.append(String.format("Successfully imported volcanologist %s %s\n", map.getFirstName(), map.getLastName()));
        }

        return sb.toString();
    }
}