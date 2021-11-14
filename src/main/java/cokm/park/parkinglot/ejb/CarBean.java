/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package cokm.park.parkinglot.ejb;

import com.park.parkinglot.entity.Car;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author a
 */
@Stateless
public class CarBean {

    private static final Logger LOG = Logger.getLogger(CarBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Car> getAllCars() {
        LOG.info("getAllCars");
        
        try {
        List<Car> cars = (List<Car>) em.createQuery("SELECT c FROM Car c").getResultList();
            return cars;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
