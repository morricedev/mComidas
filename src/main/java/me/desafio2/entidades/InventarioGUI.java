package me.desafio2.entidades;

import me.desafio2.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventarioGUI {
    private Inventory inv;

    public InventarioGUI() {
    inv = Bukkit.createInventory(null, 9, "§cComidas");
    insertItens();
    }
    private InventarioGUI insertItens(){
        ItemStack i = new ItemBuilder(Material.BREAD).setDisplayName("§e§lPao").build();
        inv.setItem(4,i);

        return this;
    }
    public Inventory getInv() { return inv; }
}
