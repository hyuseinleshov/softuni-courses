package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.models.Offer;

import java.util.List;

public interface OfferService {
    Offer getById(Long id);
    List<Offer> getAll();
    Offer save(Offer offer);
    void delete(Long id);
}
