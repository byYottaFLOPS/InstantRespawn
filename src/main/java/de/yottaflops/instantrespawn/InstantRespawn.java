package de.yottaflops.instantrespawn;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;

@Plugin(
        id = "instantrespawn",
        name = "InstantRespawn",
        version = "1.0.0",
        description = "A plugin that lets players respawn instantly on death.",
        authors = {
                "YottaFLOPS"
        }
)
public class InstantRespawn {

    private Task.Builder taskBuilder = Task.builder();

    @Listener
    public void onPlayerDeath(DestructEntityEvent.Death event) {
        if (event.getTargetEntity() instanceof Player) {
            taskBuilder.execute(() -> (
                    (Player) event.getTargetEntity())
                        .respawnPlayer()
            ).delayTicks(1).submit(this);
        }
    }

}
