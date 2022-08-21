# SuperGUIS
Having issues with creating GUIs? This library will hopefully help with that.
This has no use for server owners.

Maven:
        
        <dependency>
            <groupId>com.github.Nesanco</groupId>
            <artifactId>SuperGUIS</artifactId>
            <version>version</version>
            <scope>compile</scope>
        </dependency>
        
                <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
        
Examples:

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        GUIUtility util = new GUIUtility()
    
        GUI gui = new GUI(27, "title", GUIType.CHEST);
        gui.content("xxxxxxxxxx###xxx x");
        gui.addFormat("#", util.buildItem(Material.DIRT, "e", "e"));
        gui.addFormat("x", util.buildItem(Material.DIAMOND, "e", "e"));
        gui.open(e.getPlayer());
    }
    
Animations:

        Animation anima = new Animation(slot number, gui);
        anima.newFrame(util.buildItem(Material.RED_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.ORANGE_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.YELLOW_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.BLUE_WOOL, "e", "e"));

        anima.setTime(40);

        anima.toggle(plugin.getInstance());
        
