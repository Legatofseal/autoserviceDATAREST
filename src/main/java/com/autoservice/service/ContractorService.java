package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.*;
import com.autoservice.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
@Service
public class ContractorService {
    private final ContractorRepository contractorRepository;
    private final TypeServiceRepository typeServiceRepository;
    private final RangeworksRepository rangeworksRepository;
    private final CarmanufactureRepository carmanufactureRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository, TypeServiceRepository typeServiceRepository, RangeworksRepository rangeworksRepository, CarmanufactureRepository carmanufactureRepository, AddressRepository addressRepository) {
        this.contractorRepository = contractorRepository;
        this.typeServiceRepository = typeServiceRepository;
        this.rangeworksRepository = rangeworksRepository;
        this.carmanufactureRepository = carmanufactureRepository;
        this.addressRepository = addressRepository;
    }

    public Contractor get(Long id) {
        Contractor contractor = contractorRepository.findOne(id);
        if (contractor == null) {
            throw new NotFoundException("Contractor", id);
        }
        return contractor;
    }

    public Contractor create(Contractor contractor) {


        // Example of custom logic
        if (contractor.getId() != null && contractorRepository.findOne(contractor.getId()) != null) {
            throw new AlreadyExistsException("Contractor", contractor.getId());
        }

        Contractor result = contractorRepository.save(contractor);
        return contractor;
    }

    public List<Contractor> getByTypeService(Long id) {
         return contractorRepository.findByTypeServices(typeServiceRepository.findOne(id));
    }
    public List<Contractor> getByRangeworks(Long id) {
        return contractorRepository.findByRangeworks(rangeworksRepository.findOne(id));
    }
    public List<Contractor> getByCarmanuf(Long id) {
        return contractorRepository.findByCarmanufacture(carmanufactureRepository.findOne(id));
    }
    public List<Contractor> getByArea(String area) {
        List<Address> addresses = addressRepository.findByArea(area);
        List<Contractor> contractorsTemp = new ArrayList<Contractor>();
        for (Address address:addresses){
            contractorsTemp.addAll(contractorRepository.findByAddress(address));
        }

        return contractorsTemp;
    }
    public List<Contractor> getByAreaAndCity(String area, String city) {
        List<Address> addresses = addressRepository.findByAreaAndCity(area,city);
        List<Contractor> contractorsTemp = new ArrayList<Contractor>();
        for (Address address:addresses){
            contractorsTemp.addAll(contractorRepository.findByAddress(address));
        }

        return contractorsTemp;
    }

    public void addAddress(Long id, Address address){
        Contractor contractor = contractorRepository.findOne(id);
        contractor.setAddress(address);
        contractorRepository.save(contractor);
    }

    public List<Rangeworks> getAllRange(){
        return (List<Rangeworks>) rangeworksRepository.findAll();
    }

    public void addTypeService(Long id, TypeService typeService){

        Contractor contractor = contractorRepository.findOne(id);
        contractor.getTypeServices().add(typeService);
        contractorRepository.save(contractor);
    }
    public void removeTypeService (Long idcon, Long idtpserv){
        Contractor contractor = contractorRepository.findOne(idcon);
        for (TypeService typeService:contractor.getTypeServices()){
            if (typeService.getId().equals(idtpserv)){
                contractor.getTypeServices().remove(typeService);
            }
        }
        contractorRepository.save(contractor);
    }

    public void addPhone(Long id, Phone phone){

        Contractor contractor = contractorRepository.findOne(id);
        contractor.getPhones().add(phone);
        contractorRepository.save(contractor);
    }
    public void updateEmail(Long id, String email){

        Contractor contractor = contractorRepository.findOne(id);
        contractor.setEmail(email);
        contractorRepository.save(contractor);
    }

    public void removePhone (Long idcon, Long idphone){
        Contractor contractor = contractorRepository.findOne(idcon);
        for (Phone phone:contractor.getPhones()){
            if (phone.getId().equals(idphone)){
                contractor.getTypeServices().remove(phone);
            }
        }
        contractorRepository.save(contractor);
    }

    public void updateFax(Long id, String fax){

        Contractor contractor = contractorRepository.findOne(id);
        contractor.setFax(fax);
        contractorRepository.save(contractor);
    }

    public void updateWorkingDays(Long idcon, String workds) {
        Contractor contractor = contractorRepository.findOne(idcon);
        contractor.setWorkingDays(workds);
        contractorRepository.save(contractor);
    }

    public void updateWorkingHours(Long idcon, String workhrs) {

        Contractor contractor = contractorRepository.findOne(idcon);
        contractor.setWorkingDays(workhrs);
        contractorRepository.save(contractor);
    }

    public void addTypeVehicle(Long id, TypeVehicle typeVehicle) {
        Contractor contractor = contractorRepository.findOne(id);
        contractor.getTypeVehicles().add(typeVehicle);
        contractorRepository.save(contractor);
    }

    public void removeTypeVehicle(Long idcon, Long idtpveh) {
        Contractor contractor = contractorRepository.findOne(idcon);
        for (TypeVehicle typeVehicle:contractor.getTypeVehicles()){
            if (typeVehicle.getId().equals(idtpveh)){
                contractor.getTypeServices().remove(typeVehicle);
            }
        }
        contractorRepository.save(contractor);
    }
}
