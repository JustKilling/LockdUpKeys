package me.emiel.lockdupkeys;

import com.jeff_media.customblockdata.CustomBlockData;
import me.emiel.lockdupkeys.Commands.GetKey;
import me.emiel.lockdupkeys.Listeners.OnDoorClick;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lockdupkeys extends JavaPlugin {

    private static Lockdupkeys _instance;

    @Override
    public void onEnable() {
        _instance = this;

        this.getCommand("getkey").setExecutor(new GetKey());
        this.getServer().getPluginManager().registerEvents(new OnDoorClick(), this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static PersistentDataContainer getCustomData(Block block) {
        if(block.getBlockData() instanceof Bisected) {
            Bisected.Half half = ((Bisected)block.getBlockData()).getHalf();
            if(half == Bisected.Half.TOP) {
                return new CustomBlockData(block.getRelative(BlockFace.DOWN,1), get_instance());
            }
        }
        return new CustomBlockData(block,get_instance());
    }

    public static Lockdupkeys get_instance() {
        return _instance;
    }
}
