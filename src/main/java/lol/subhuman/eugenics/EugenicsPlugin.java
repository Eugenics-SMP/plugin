package lol.subhuman.eugenics;

import lol.subhuman.eugenics.entity.repository.CachedEntityContextRepository;
import lol.subhuman.eugenics.entity.repository.UUIDBoundPlayerContextRepository;
import lol.subhuman.eugenics.entity.repository.bindings.IEntityContextRepository;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import lol.subhuman.eugenics.listener.ContextWrappingListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class EugenicsPlugin extends JavaPlugin {
    private final IEntityContextRepository entityRepository;
    private final IPlayerContextRepository playerRepository;

    public EugenicsPlugin() {
        this.entityRepository = new CachedEntityContextRepository(new HashMap<>());
        this.playerRepository = new UUIDBoundPlayerContextRepository(new HashMap<>());
    }

    @Override
    public void onEnable() {
        final PluginManager pluginManager = Bukkit.getServer().getPluginManager();

        pluginManager.registerEvents(new ContextWrappingListener(entityRepository, playerRepository), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
