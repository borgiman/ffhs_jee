package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.OrdersRepository;
import ch.ffhs.jee.models.Product;

import java.util.ArrayList;

public class TestOrdersRepository extends OrdersRepository {
    @Override
    public void addOrder(String firstname, String lastname, String streetAndHouseNr, int plz, String city, String email, ArrayList<Product> products) {
    }
}
