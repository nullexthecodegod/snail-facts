package nl.x;

import java.util.logging.Logger;
import net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import nl.x.event.EventVallListener;

public class Main {
	public Logger logger = Logger.getLogger("Builder");
	
	public Main() {
		try {
			this.logger.info("Building client");
		    DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
		    builder.setToken(process.env.BOT_TOKEN);
		    builder.setGame(Game.of(GameType.STREAMING, "Do !snail for a free snail fact!"));
		    builder.setIdle(true);
			this.logger.info("Adding event hook");
		    builder.addEventListeners(new EventVallListener());
		    builder.build();
		} catch (Exception e) {
			
		}
	}

}
