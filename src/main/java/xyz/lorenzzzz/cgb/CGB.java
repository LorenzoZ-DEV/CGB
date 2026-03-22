package xyz.lorenzzzz.cgb;

import dev.lorenzz.bukkit.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.lorenzzzz.cgb.managment.ManagerService;

import java.util.List;

public final class CGB extends JavaPlugin {


    private static CGB INSTANCE;
    private ManagerService managerService;

    @Override
    public void onEnable() {

        INSTANCE = this;
        try{
            managerService = new ManagerService();
            managerService.start();
            registerCmds();
            registerListeners();

        }catch(Exception e){
            e.printStackTrace();
            ManagerService.get().stop();
             getLogger().severe("Errore durante l'avvio del plugin: " + e.getMessage());

        }
    }

    @Override
    public void onDisable()
    {
        INSTANCE = null ;
        if (managerService != null){
            managerService.stop();
        }
    }

    private void registerCmds(){
        BukkitCommandManager cmdManager = new BukkitCommandManager(this);
         //
    }

    private void registerListeners(){
        List.of(
                //

        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    public static CGB getINSTANCE() {
        return INSTANCE;
    }





}
