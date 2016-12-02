package ro.gov.ithub.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.entity.Agency;

import java.util.Collection;

@RestController
public class AgencyController extends BaseController<Agency> {

	@Autowired
	private AgencyService agencyService;

	@RequestMapping(
			value = { "/agencies", "/regii" },
			method = RequestMethod.GET)
	public Collection<Agency> getAllAgencies() {
		return agencyService.getAllAgencies();
	}
}
