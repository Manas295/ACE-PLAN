package com.marketdataservice.MarketDataService;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketDataController {
	static Map<Object, Object> price;
	static {
		price = Stream.of(new Object[][] {
			{"Gold", 90000},
			{"Iron", 70000},
			{"Zinc", 60900},
			{"Lead", 75000},
			{"Platinum", 55000}
			
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
	}
	

	@GetMapping("/price/{commodity}")
	public  ResponseEntity<Integer> getCommodityPrice(@PathVariable String commodity) {

		 return new ResponseEntity<Integer>((Integer) price.get(commodity), HttpStatus.OK);
	}
}
