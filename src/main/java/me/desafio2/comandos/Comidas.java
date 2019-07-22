package me.desafio2.comandos;

import me.desafio2.entidades.InventarioGUI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comidas implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;

        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("comidas"));
        p.openInventory(new InventarioGUI().getInv());
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10,10 );


        return false;
    }
}
