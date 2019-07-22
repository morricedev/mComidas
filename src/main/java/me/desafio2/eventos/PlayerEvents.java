package me.desafio2.eventos;

import static me.desafio2.MComidas.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEvents implements Listener {
    @EventHandler
    public void entrar (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(getInstance().getConfig().getString("Config.Entrar") + p.getName());
    }
    @EventHandler
    public void sair (PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(getInstance().getConfig().getString("Config.Sair") + p.getName());
    }
}
