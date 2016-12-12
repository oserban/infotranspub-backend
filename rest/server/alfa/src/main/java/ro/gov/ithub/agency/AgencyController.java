package ro.gov.ithub.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.entity.Agency;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class AgencyController extends BaseController<Agency> {

	private static final String AGENCIES_EN = "/agencies";
	private static final String AGENCIES_RO = "/regii";
	private static final String AGENCY_EN = "/agency";
	private static final String AGENCY_RO = "/regie";
	private static final String AGENCY_EN_BY_ID = "/agency/{id}";
	private static final String AGENCY_RO_BY_ID = "/regie/{idRegie}";
	
	@Autowired
	private AgencyService agencyService;

	@RequestMapping(value = {AGENCIES_EN}, method = GET)
	public Collection<Agency> getAllAgencies() {
		return agencyService.findAll();
	}

	@RequestMapping(value = {AGENCY_EN_BY_ID}, method = GET)
	public Agency findAgencyById(@PathVariable("id") final int agencyId) {
		return agencyService.findById(agencyId);
	}

	@RequestMapping(value = {AGENCY_EN}, method = POST)
	public void saveOrUpdateAgency(@RequestBody final Agency agency) {
		agencyService.saveOrUpdate(agency);
	}

	@RequestMapping(value = {AGENCY_EN}, method = DELETE)
	public void deleteAgency(@RequestBody final Agency agency) {
		agencyService.delete(agency.getId());
	}
}
