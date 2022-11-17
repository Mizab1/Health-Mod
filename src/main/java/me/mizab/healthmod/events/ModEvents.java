package me.mizab.healthmod.events;

import me.mizab.healthmod.Healthmod;
import me.mizab.healthmod.commands.SetHealthCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Healthmod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        new SetHealthCommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }
}
