/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.park.parkinglot.ejb;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.entity.Car;
import com.park.parkinglot.entity.User;
import java.util.ArrayList;
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
    
    
     public void updateCar(Integer carId, String licensePlate, String parkingSpot, Integer userId) {
       LOG.info("updateCar");
       Car car = em.find(Car.class, carId);
       car.setLicensePlate(licensePlate);
       car.setParkingSpot(parkingSpot);
       
       User oldUser = car.getUser();
       oldUser.getCars().remove(car);
       
       User user = em.find(User.class, userId);
       user.getCars().add(car);
       car.setUser(user);
    } 
   
    public CarDetails findById(Integer carId) {
        LOG.info("findCarById");
        
        try {
            Car car = em.find(Car.class, carId);
            return new CarDetails(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUser().getUsername());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    
    
    public List<CarDetails> getAllCars() {
        LOG.info("getAllCars");
        
        try {
            List<Car> cars = (List<Car>) em.createQuery("SELECT c FROM Car c").getResultList();
            return copyCarsToDetails(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<CarDetails> copyCarsToDetails(List<Car> cars) {
        List<CarDetails> detailsList = new ArrayList<>();
        for(Car car : cars) {
            CarDetails carDetails = new CarDetails(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getUser().getUsername()
            );
            detailsList.add(carDetails);
        }
        
        return detailsList;
    }
    
    public void createCar(String licensePlate, String parkingSpot, Integer ownerId){
        LOG.info("createCar");
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);
        
        User user  = em.find(User.class, ownerId);
        user.getCars().add(car);
        car.setUser(user);
        
        em.persist(car);
    }

    public void deleteCarsByIds(List<Integer> carIds) {
        LOG.info("deleteCarsById");
        for(Integer id : carIds)
        {
            Car car = em.find(Car.class, id);
            em.remove(car);
        }
    }
        
}
