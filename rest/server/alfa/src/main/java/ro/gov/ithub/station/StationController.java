package ro.gov.ithub.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.city.City;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StationController extends BaseController<Station> {

	@Autowired
	private StationService stationService;

}
