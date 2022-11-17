package me.mizab.healthmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

import java.util.Collection;

public class SetHealthCommand {
    public SetHealthCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("hp").
        then(Commands.literal("set").
            then(Commands.argument("target", EntityArgument.players()).
                then(Commands.argument("amount", IntegerArgumentType.integer(1)).
                        executes((source) -> setHealth(source.getSource(), EntityArgument.getPlayers(source, "target"), IntegerArgumentType.getInteger(source, "amount")))))));
    }
    private int setHealth(CommandSource source, Collection<ServerPlayerEntity> targets, float amount) throws CommandSyntaxException{
        for(ServerPlayerEntity serverplayerentity : targets) {
            serverplayerentity.setHealth(amount);
        }

        source.sendFeedback(new StringTextComponent("Health has been set"), true);
        return 1;
    }
}
