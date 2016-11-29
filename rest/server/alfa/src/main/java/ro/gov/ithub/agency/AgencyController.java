package ro.gov.ithub.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.entity.Agency;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AgencyController extends BaseController<Agency> {

	@Autowired
	private AgencyService agencyService;

}
