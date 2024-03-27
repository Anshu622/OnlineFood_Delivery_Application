package org.FoodDelivery.Repository;

import org.FoodDelivery.Model.Address;
import org.FoodDelivery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
