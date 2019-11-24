package com.trade.Trade.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")

public interface MarketDataServiceProxy {


	@GetMapping("/market-data-service/price/{commodity}")
	public Integer getMarketPrice
	(@PathVariable("commodity") String commodity);
}
