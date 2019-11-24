package com.trade.Trade.Controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trade.Trade.Models.SideEnum;
import com.trade.Trade.Models.Trade;
import com.trade.Trade.repository.TradeRepository;

@RestController
public class TradeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MarketDataServiceProxy proxy;
	
	@Autowired
	TradeRepository repository ;
	
	@PostMapping("/trades")
	public ResponseEntity<Object> createTrade( @RequestBody Trade trade) {
		//User savedUser = userRepository.save(user);
		trade.setSide(SideEnum.BUY);
		
		Integer price = proxy.getMarketPrice(trade.getCommodity());
		System.out.println("Price   -> "+price);
		
		trade.setPrice(price);
		
		Trade bean =  repository.save(trade);
		

		System.out.println("Trade is : "+bean);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bean.getId())
				.toUri();

	
		return ResponseEntity.created(location).build();

	}
	


}
