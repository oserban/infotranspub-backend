package ro.gov.ithub.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.gov.ithub.city.City;
import ro.gov.ithub.entity.Agency;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;


    @Override
    public Collection<Agency> getAllAgencies() {
        return this.agencyRepository.findAll();
    }

}
