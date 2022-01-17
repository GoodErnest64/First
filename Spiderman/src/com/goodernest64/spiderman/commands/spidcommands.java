package com.goodernest64.spiderman.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;

public class spidcommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("fly")){
            sender.sendMessage("Really?");
            String ip = sender.getServer().getIp().toString();
            sender.sendMessage(ip);
            int distance = sender.getServer().getViewDistance();


            Player p = (Player)sender;
            int x = p.getLocation().getBlockX();
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            String string = p.getWorld().getGenerator().toString();
            p.sendMessage(string);

            sender.sendMessage(Integer.toString(distance));
        }

        return true;
    }
}
