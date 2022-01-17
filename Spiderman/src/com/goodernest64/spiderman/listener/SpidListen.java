package com.goodernest64.spiderman.listener;

import com.goodernest64.spiderman.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.*;
import org.bukkit.util.Vector;

import javax.naming.NameClassPair;
import java.util.Collections;
import java.util.HashSet;
import java.util.prefs.BackingStoreException;

public class SpidListen implements Listener {
    public boolean a = false;
    private Main plugin;
    private int task1;
    int cps =0;
    public SpidListen(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

/*
        //#@EventHandler
    //public void SwingEvent(PlayerInteractEvent e){

        if(e.getAction() == Action.LEFT_CLICK_AIR){

            Player p = e.getPlayer();
            Block b = p.getTargetBlock(Collections.singleton(Material.AIR), 1200);
            if(b != null && b.getType().isSolid()){

                World w = p.getWorld();
                Location l = p.getLocation();


                LivingEntity bat = (LivingEntity) w.spawnEntity(l, EntityType.SILVERFISH);
                bat.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 100000));

                Vector v = l.getDirection();
                Arrow arr = w.spawnArrow(l.add(v.clone().normalize().multiply(2)), v, 10f, 0);

                bat.setLeashHolder(arr);
                p.setLeashHolder(arr);

                BukkitScheduler sched = p.getServer().getScheduler();
                task1 = sched.scheduleSyncRepeatingTask(plugin, new Runnable(){

                    @Override
                    public void run(){

                        if(arr.isOnGround()){

                            p.teleport(p.getLocation().add(0,0.5,0));
                            p.setVelocity(v.clone().multiply(10));
                            p.setFallDistance(-100);
                            bat.remove();
                            arr.remove();
                            sched.cancelTask(task1);

                        }
                        if(arr.getTicksLived() >= 40){
                            bat.remove();
                            arr.remove();
                            sched.cancelTask(task1);
                        }
                        if(bat.getTicksLived() >= 40){
                            bat.remove();
                            arr.remove();
                            sched.cancelTask(task1);
                        }
                    }

                }, 0, 5L);

            }


        }

    }
    */

    @EventHandler
    public void fish(PlayerFishEvent event){
        boolean b;
        Player p = event.getPlayer();
        PlayerFishEvent.State a = event.getState();
        //p.sendMessage(a.name());
        if(a == PlayerFishEvent.State.FISHING){
            //p.sendMessage("Launchaaaaa");
        }else{
            Location loc1 = p.getLocation();
            Location loc2 = event.getHook().getLocation();
            Vector v = new Vector(loc2.getX() - loc1.getX(), 1, loc2.getZ() - loc1.getZ());
            p.setVelocity(v.multiply(1.5));
            p.setFallDistance(-1000);
            //p.sendMessage("Launch");

        }
    }
    @EventHandler
    public void move(PlayerMoveEvent e){
        Player p = e.getPlayer();
        p.setSprinting(true);

    }




}
