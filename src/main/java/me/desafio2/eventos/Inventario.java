package me.desafio2.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Inventario implements Listener {
@EventHandler
    public void clicar (InventoryClickEvent e){
    if(!e.getInventory().getName().equalsIgnoreCase("§cComidas")) return;

    ItemStack i = e.getCurrentItem();
    e.setCancelled(true);
    Player p = (Player) e.getWhoClicked();
    if(i.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPao"))
        p.performCommand("pao");
}
}
