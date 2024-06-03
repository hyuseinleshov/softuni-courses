package bg.softuni.mobilelele;

import bg.softuni.mobilelele.model.*;
import bg.softuni.mobilelele.model.enums.Category;
import bg.softuni.mobilelele.model.enums.Engine;
import bg.softuni.mobilelele.model.enums.Role;
import bg.softuni.mobilelele.model.enums.Transmission;
import bg.softuni.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public CommandLineRunnerImpl(BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        populateBrands();
//        populateModels();
//        populateOffers();
    }

    private void populateBrands() {
        Brand brand1 = new Brand();
        brand1.setName("Toyota");
        brand1.setCreated(LocalDateTime.now());
        brand1.setModified(LocalDateTime.now());
        brandRepository.save(brand1);

        Brand brand2 = new Brand();
        brand2.setName("Honda");
        brand2.setCreated(LocalDateTime.now());
        brand2.setModified(LocalDateTime.now());
        brandRepository.save(brand2);
    }

    private void populateModels() {
        Brand toyota = brandRepository.findByName("Toyota");
        Brand honda = brandRepository.findByName("Honda");

        Model model1 = new Model();
        model1.setName("Corolla");
        model1.setCategory(Category.CAR);
        model1.setImageUrl("corolla.jpg");
        model1.setStartYear(2000);
        model1.setEndYear(2022);
        model1.setCreated(LocalDateTime.now());
        model1.setModified(LocalDateTime.now());
        model1.setBrand(toyota);
        modelRepository.save(model1);

        Model model2 = new Model();
        model2.setName("Civic");
        model2.setCategory(Category.CAR);
        model2.setImageUrl("civic.jpg");
        model2.setStartYear(1995);
        model2.setEndYear(2021);
        model2.setCreated(LocalDateTime.now());
        model2.setModified(LocalDateTime.now());
        model2.setBrand(honda);
        modelRepository.save(model2);
    }

    private void populateOffers() {
        Model corolla = modelRepository.findByName("Corolla");

        UserRole role = new UserRole();
        role.setName(Role.USER);
        userRoleRepository.save(role);

        UserEntity seller1 = new UserEntity();
        seller1.setUsername("seller1");
        seller1.setPassword("password1");
        seller1.setFirstName("John");
        seller1.setLastName("Doe");
        seller1.setActive(true);
        seller1.setRole(role);
        userRepository.save(seller1);

        Offer offer1 = new Offer();
        offer1.setDescription("Good condition Corolla");
        offer1.setEngine(Engine.GASOLINE);
        offer1.setImageUrl("corolla_offer.jpg");
        offer1.setMileage(50000);
        offer1.setPrice(BigDecimal.valueOf(15000));
        offer1.setTransmission(Transmission.AUTOMATIC);
        offer1.setYear(2018);
        offer1.setCreated(LocalDateTime.now());
        offer1.setModified(LocalDateTime.now());
        offer1.setModel(corolla);
        offer1.setSeller(seller1);
        offerRepository.save(offer1);
    }

}
