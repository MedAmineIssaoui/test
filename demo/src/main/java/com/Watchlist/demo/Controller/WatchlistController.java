package com.Watchlist.demo.Controller;

import com.Watchlist.demo.Entity.Watchlist;
import com.Watchlist.demo.Service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlists")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @PostMapping
    public Watchlist addWatchlist(@RequestBody Watchlist watchlist) {
        return watchlistService.addWatchlist(watchlist);
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlist(@PathVariable Long id) {
        watchlistService.deleteWatchlist(id);
    }
}