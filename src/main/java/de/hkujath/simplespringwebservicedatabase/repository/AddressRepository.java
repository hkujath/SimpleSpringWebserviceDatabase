package de.hkujath.simplespringwebservicedatabase.repository;

import de.hkujath.simplespringwebservicedatabase.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}