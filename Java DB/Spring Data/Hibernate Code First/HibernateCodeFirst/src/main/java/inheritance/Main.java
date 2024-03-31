package inheritance;

import inheritance.entities.DemoBike;
import inheritance.entities.DemoCar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory mainFactory =
                Persistence.createEntityManagerFactory("main");
        EntityManager entityManager = mainFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new DemoCar());
        entityManager.persist(new DemoBike());

        entityManager.getTransaction().commit();
    }
}
