package com.goodernest64.spiderman;

import com.goodernest64.spiderman.commands.spidcommands;
import com.goodernest64.spiderman.listener.SpidListen;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        new SpidListen(this);

        spidcommands a = new spidcommands();
        getCommand("fly").setExecutor(a);
    }
}
