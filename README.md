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
    
The content will be translated into itemstacks based on the formats you create.
The example above would show:
![image](https://user-images.githubusercontent.com/80917510/185811314-692a4622-29f2-4157-a8a8-d259a34109b0.png)
(Includes the animation ignore that)
    
Animations:

        Animation anima = new Animation(slot number, gui);
        anima.newFrame(util.buildItem(Material.RED_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.ORANGE_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.YELLOW_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.BLUE_WOOL, "e", "e"));

        anima.setTime(40);

        anima.toggle(plugin.getInstance());
        
        or
        
        anima.play(plugin.getInstance());
        
GUI Utilities:

The GUI utilities class helps with creating itemstacks and other general things.

Example:

    GUIUtility util = new GUIUtility(); 
    ItemStack stack = util.buildItem(Material.YELLOW_WOOL, "name", "lore")
