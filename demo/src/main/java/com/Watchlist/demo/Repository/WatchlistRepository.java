package com.Watchlist.demo.Repository;

import com.Watchlist.demo.Entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}