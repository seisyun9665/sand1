package seisyun.github.clicktnt.clicktnt;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClickTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("クリックTNTが起動しました");
        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Action action = e.getAction();
        if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK){
            if(e.getHand() == EquipmentSlot.HAND){
                Player player = e.getPlayer();
                Location location = player.getEyeLocation();
                TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);
                tnt.setFuseTicks(40);
                tnt.setVelocity(location.getDirection().multiply(1.5));
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("クリックTNTが終了しました");
    }



}
