package com.Watchlist.demo.Service;

import com.Watchlist.demo.Entity.Watchlist;
import com.Watchlist.demo.Repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;

    public Watchlist addWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    public void deleteWatchlist(Long id) {
        watchlistRepository.deleteById(id);
    }
}