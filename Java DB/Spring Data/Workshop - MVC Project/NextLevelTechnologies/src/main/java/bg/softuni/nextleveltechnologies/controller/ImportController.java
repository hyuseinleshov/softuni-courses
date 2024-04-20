package bg.softuni.nextleveltechnologies.controller;

import bg.softuni.nextleveltechnologies.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
public class ImportController {
    private final CompanyService companyService;

    public ImportController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/import/xml")
    public String index(Model model) {
        model.addAttribute("areImported", new boolean[] {false, false, false});

        return "xml/import-xml";
    }

    @GetMapping("/import/companies")
    public String importCompanies(Model model) {
        Path path = Path.of("src/main/resources", "files", "xmls", "companies.xml");
        try {
            List<String> xmlContent = Files.readAllLines(path);

            model.addAttribute("companies", String.join("\n", xmlContent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "xml/import-companies";
    }

    @PostMapping("/import/companies")
    public String doImportCompanies() {
        companyService.importCompanies();

        return "redirect:/import/xml";
    }
}
