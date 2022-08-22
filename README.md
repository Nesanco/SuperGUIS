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
        
Register your main class:

In your main class get a new GUIUtility. Then use .register(your main class) to register the plugin.
Only call this method once.

Example:

    @Override
    public void onEnable() {
        GUIUtility util = new GUIUtility();
        util.register(this);

    }
    
You can use the same variable to call .buildItem, so if you want, store the variable.



        
Examples:

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        GUIUtility util = new GUIUtility();

        GUI gui = new GUI("title", GUIType.DEFAULT, 45);
        gui.content("xxxxxxxxxx###xxx x");
        gui.addFormat("#", util.buildItem(Material.DIRT, "name", "lore"));
        gui.addFormat("x", util.buildItem(Material.DIAMOND, "name", "lore"));
        gui.open(e.getPlayer());
    
The content will be translated into itemstacks based on the formats you create.
The example above would show:
![image](https://user-images.githubusercontent.com/80917510/185811314-692a4622-29f2-4157-a8a8-d259a34109b0.png)

(Ignore the red wool)
    
Animations:

        Animation anima = new Animation(slot number, gui);
        anima.newFrame(util.buildItem(Material.RED_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.ORANGE_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.YELLOW_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.BLUE_WOOL, "e", "e"));

        anima.setTime(ticks);

        anima.toggle();
        
        or
        
        anima.play();
        
GUI Utilities:

The GUI utilities class helps with creating itemstacks and other general things, it is also used to register your main class.

Example:

    GUIUtility util = new GUIUtility(); 
    ItemStack stack = util.buildItem(Material.YELLOW_WOOL, "name", "lore")
    
    util.register(instance);
    
Buttons:

Create buttons to run code when clicking a specified item in a slot.

Example:

        GUIButton button = new GUIButton(slot number, gui);

        button.setAction(new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("hello world!");
            }
        });
        
Types of inventories:

You can create different types of inventories using a similar method:

    GUI gui = new GUI("title", GUIType.TYPE);
    
Example:
    
    GUI gui = new GUI("title", GUIType.SHULKER);
    
Example of everything:

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        GUIUtility util = new GUIUtility();

        GUI gui = new GUI("E", GUIType.DEFAULT, 45);
        gui.content("xxxxxxxxxx###xxx x");
        gui.addFormat("#", util.buildItem(Material.DIRT, "e", "e"));
        gui.addFormat("x", util.buildItem(Material.DIAMOND, "e", "e"));
        gui.open(e.getPlayer());

        gui.onClose(new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("bye world!");
            }
        });

        Animation anima = new Animation(1, gui);
        anima.newFrame(util.buildItem(Material.RED_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.ORANGE_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.YELLOW_WOOL, "e", "e"));
        anima.newFrame(util.buildItem(Material.BLUE_WOOL, "e", "e"));

        GUIButton button = new GUIButton(2, gui);

        button.setAction(new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("hello world!");
            }
        });

        anima.setTime(40);

        anima.toggle();
    }
