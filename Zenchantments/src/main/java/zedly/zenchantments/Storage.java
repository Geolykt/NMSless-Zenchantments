package zedly.zenchantments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import zedly.zenchantments.compatibility.CompatibilityAdapter;

import java.util.*;

public class Storage {

    // Instance of the Zenchantments plugin to be used by the rest of the classes
    public static Zenchantments zenchantments;

    // Absolute path to the plugin jar
    public static String pluginPath;

    // The plugin Logo to be used in chat commands
    public static final String logo = ChatColor.BLUE + "[" + ChatColor.DARK_AQUA + "Zenchantments"
            + ChatColor.BLUE + "] " + ChatColor.AQUA;

    // Current Zenchantments version
    public static String version = "";

    public static final CompatibilityAdapter COMPATIBILITY_ADAPTER;

    // Random object
    public static final Random rnd = new Random();

    public static final BlockFace[] CARDINAL_BLOCK_FACES = {
        BlockFace.UP,
        BlockFace.DOWN,
        BlockFace.NORTH,
        BlockFace.EAST,
        BlockFace.SOUTH,
        BlockFace.WEST
    };

    static {
        String versionString = Bukkit.getServer().getClass().getPackage().getName();
        String nmsVersionString = versionString.substring(versionString.lastIndexOf('.') + 1);
        System.out.println("Zenchantments: Detected NMS version \"" + nmsVersionString + "\"");
        switch (nmsVersionString) {
            default:
                COMPATIBILITY_ADAPTER = zedly.zenchantments.compatibility.CompatibilityAdapter.getInstance();
                break;
        }
    }
}
