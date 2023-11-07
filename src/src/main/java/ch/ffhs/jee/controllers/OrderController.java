package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.OrdersRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderController {
    private final OrdersRepository ordersRepository;
    private final CartController cartController;
    private String firstname;
    private String lastname;
    private String streetAndHouseNr;
    private int plz;
    private String city;
    private String email;

    @Inject
    public OrderController(OrdersRepository ordersRepository, CartController cartController) {
        this.ordersRepository = ordersRepository;
        this.cartController = cartController;
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected OrderController() {
        this(null, null);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetAndHouseNr() {
        return this.streetAndHouseNr;
    }

    public void setStreetAndHouseNr(String streetAndHouseNr) {
        this.streetAndHouseNr = streetAndHouseNr;
    }

    public int getPlz() {
        return this.plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * execute the order
     * @return redirect to the thanks page
     */
    public String order() {
        this.ordersRepository.addOrder(this.firstname, this.lastname, this.streetAndHouseNr, this.plz, this.city, this.email, this.cartController.getProducts());
        this.cartController.clear();
        return "thanks?faces-redirect=true";
    }
}
