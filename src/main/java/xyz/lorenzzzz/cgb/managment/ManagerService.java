package xyz.lorenzzzz.cgb.managment;

import xyz.lorenzzzz.cgb.CGB;

import java.util.List;

public class ManagerService
{
    private static ManagerService INSTANCE;
    private List<Manager> managers;

    public void start(){
        INSTANCE = this;
        registerManager();
    }

    public void stop(){
        for(Manager manager : managers){
            manager.stop();
        }

        if (INSTANCE != null){
            INSTANCE = null;
        }
        managers.clear();
    }

    private void registerManager(){
        // addManager(new NomeManager()

    }


    private void addManager(final Manager manager, final String name) {
        try {
            long startTime = System.currentTimeMillis();
            if (managers.contains(manager)) return;
            managers.add(manager);
            manager.start();
            CGB.getINSTANCE().getLogger().info("Manager" + name + " registrato con successo. in" + startTime + "ms");
        } catch (Exception e) {
            CGB.getINSTANCE().getLogger().severe("Errore durante la registrazione del manager: " + name);
        }
    }
    public static ManagerService get() {
        return INSTANCE;
    }



}