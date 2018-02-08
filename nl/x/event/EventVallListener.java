package nl.x.event;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EventVallListener extends ListenerAdapter {
	public Logger logger = Logger.getLogger("Bot");
	public List<String> facts = new CopyOnWriteArrayList<>();
	public Random random;
	
	@Override
	public void onReady(ReadyEvent event) {
		this.random = new Random();
		logger.info("Logged into bot");
		this.facts.add("`Did You Know`: Snails Can Live Pretty Much Anywhere, Although They Are Not Fond Of Heat. When The Weather Is Hot, Snails Burrow Under The Ground And Wait Until It Is Cool.");
		this.facts.add("`Did You Know`: There Are Both Land Snails And Water Snails.");
		this.facts.add("`Did You Know`: Snails Prefer Damp, Dark Environments.");
		this.facts.add("`Did You Know`: Snails Eat Plants, Algae, Chalk, Limestone, And, Sometimes, Each Other.");
		this.facts.add("`Did You Know`: The Romans Raised Snails");
		this.facts.add("`Did You Know`: Snails Hibernate In The Winter.");
		this.facts.add("`Did You Know`: As they move along snails leave behind a trail of mucus which acts as a lubricant to reduce surface friction. This also allows the snail to move along upside down.");
		this.facts.add("`Did You Know`: The World’s Smallest Land Snail Could Fit Through The Eye Of A Needle");
		this.facts.add("`Did You Know`: Did You Know That 30 People Have Died From Snails");
		this.facts.add("`Did You Know`: Snails Can Have Lungs Or Gills Depending On The Species And Their Habitat. Some Marine Snails Actually Can Have Lungs And Some Land Based Snails Can Have Gills.");
		this.facts.add("`Did You Know`: For Pre-Columbian Americans, Snails Were A Symbol Of Joy");
		this.facts.add("`Did You Know`: The Giant Triton, Charonia Tritonis, Can Grow Up To A Foot And A Half Long. It’S Also An Aggressive Predator With A Keen Sense Of Smell, And It Loves To Eat Starfish, Paralyzing Them With Venomous Saliva.");
		this.facts.add("`Did You Know`: Though Some Slugs Only Appear To Be Shell-Less In Reality, Slug Families Such As Limacidae And Milacidae Have Internal Shell Plates Hidden Within Their Bodies");
		this.facts.add("`Did You Know`: Most Snail Species Have A Ribbon-Like Tongue Called A Radula That Contains Thousands Of Microscopic Teeth. The Radula Works Like A File, Ripping Food Up Into Tiny Pieces.");
		this.facts.add("`Did You Know`: The Giant African Land Snail Grows To About 38 Cm (15 In) And Weigh 1 Kg (2lb).");
		this.facts.add("`Did You Know`: The Largest Living Sea Snail Species Is The Syrinx Aruanus Who'S Shell Can Reach 90 Cm (35 In) In Length And The Snail Can Weigh Up To 18 Kg (40lbs)!");
		this.facts.add("`Did You Know`: Common Garden Snails Have A Top Speed Of 45 M (50 Yards) Per Hour. Making The Snail One Of The Slowest Creatures On Earth.");
		this.facts.add("`Did You Know`: Snail Is A Common Name For Gastropod Molluscs That Can Be Split Into Three Groups, Land Snails, Sea Snails And Freshwater Snails.");
		this.facts.add("`Did You Know`: The Snail Is A Delicacy In French Cuisine Called Escargot. The Snail Is Also Eaten In Many Other Countries Of The World, Often As A Fried Meal.");
		this.facts.add("`Did You Know`: In English, The Expression \"A Snail'S Pace\" Is A Term Used To Describe A Slow, Inefficient Process And \"Snail Mail\" Is Now Commonly Used When Referring To Sending Regular Mail Rather Than That Sent By Email.");
		this.facts.add("`Did You Know`: He Snail Is Both Male And Female. Therefore, It Can Produce Sperms And Eggs At The Same Time ! Isn'T That Incredible?");
		this.facts.add("`Did You Know`: Snails Take About 2 Years To Become Adults.");
		this.facts.add("`Did You Know`: The Eyes Of A Snail Is On The Tip Of The Tentacle Or At The Base Of The Tentacle For Marine Species");
		super.onReady(event);
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().trim().toLowerCase();
		if (!message.startsWith("!")) return;
		if (message.startsWith("!facts")) {
			event.getTextChannel().sendMessage("`Snail Facts has " + this.facts.size() + " facts about snail's`").submit();
		}
		if ((message.contains("snaii10") || message.contains("snail10"))) {
			int other = this.random.nextInt(this.facts.size() - 10);
			for (int i = 0; i < 10; i++) {
				event.getTextChannel().sendMessage(facts.get(other + i)).submit();
			}
			return;
		}
		if (message.startsWith("!") && (message.contains("snaii") || message.contains("snail"))) {
			event.getTextChannel().sendMessage(this.facts.get(this.random.nextInt(this.facts.size()))).submit();
		}
		super.onMessageReceived(event);
	}

}
