package com.trade.Trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trade.Trade.Models.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
