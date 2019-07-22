package me.desafio2.comandos;

import static me.desafio2.MComidas.*;
import me.desafio2.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Pao implements CommandExecutor {

    HashMap<Player, Long> pao = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;

        Player p = (Player) s;
        if(pao.containsKey(p) && !(System.currentTimeMillis() >= pao.get(p))) {
            p.sendMessage("§cAguarde " +converter(p) + " §csegundos para usar o comando novamente!");
            return true;
        }else{
            pao.remove(p);
        }

        pao.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Long.parseLong(getInstance().getConfig().getString("Config.Tempo"))));

        PlayerInventory inv = p.getInventory();

        if(args.length == 0){
            ItemStack pao = new ItemBuilder(Material.BREAD, getInstance().getConfig().getInt("Config.Quantidade"))
                    .setDisplayName(getInstance().getConfig().getString("Config.Nome"))
                    .setLore(getInstance().getConfig().getString("Config.Lore"))
                    .build();
            p.getInventory().addItem(pao);
            p.sendMessage(getInstance().getConfig().getString("Config.Mensagem"));

        }



        return false;
    }
    private long converter(Player p) {
    long tempo = System.currentTimeMillis() - pao.get(p);
    return 1+ TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
}
}
