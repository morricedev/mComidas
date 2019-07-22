package me.desafio2;

import me.desafio2.comandos.Comidas;
import me.desafio2.comandos.Pao;
import me.desafio2.eventos.Inventario;
import me.desafio2.eventos.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MComidas extends JavaPlugin {

    private static MComidas instance;

    @Override
    public void onEnable() {
        instance = this;
        Carregarconfig();
        Bukkit.getConsoleSender().sendMessage("§aHabilitado");
        Registrarcomandos();
        Registrareventos();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cDesabilitado");
    }
    public void Registrareventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new Inventario(), this);

    }
    public void Registrarcomandos() {
        getCommand("pao").setExecutor(new Pao());
        getCommand("comidas").setExecutor(new Comidas());

    }
    public void Carregarconfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
    public static MComidas getInstance(){
        return instance;
    }
    }

