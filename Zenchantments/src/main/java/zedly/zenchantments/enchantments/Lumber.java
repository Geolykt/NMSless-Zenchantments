package zedly.zenchantments.enchantments;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

import com.google.common.collect.ImmutableSet;

import zedly.zenchantments.CustomEnchantment;
import zedly.zenchantments.enums.Hand;
import zedly.zenchantments.enums.Tool;
import zedly.zenchantments.util.Utilities;

import java.util.List;
import java.util.Set;

import static zedly.zenchantments.enums.Tool.AXE;

public class Lumber extends CustomEnchantment {

    private static final int MAX_BLOCKS = 200;

    public static int[][] SEARCH_FACES = new int[][]{new int[]{}};

    public static final Set<Material> LUMBER_TRUNKS; 
    public static final Set<Material> LUMBER_ALLOWLIST;
    
    public static final int ID = 34;

    static {
        ImmutableSet.Builder<Material> b = ImmutableSet.builder();
        b.addAll(Tag.LOGS.getValues());
        b.add(Material.MUSHROOM_STEM);
        LUMBER_TRUNKS = b.build();
        b.addAll(Tag.ENDERMAN_HOLDABLE.getValues());
        b.addAll(Tag.LEAVES.getValues());
        b.addAll(Tag.CLIMBABLE.getValues());
        b.addAll(Tag.FLOWERS.getValues());
        b.addAll(Tag.SAPLINGS.getValues());
        b.add(new Material[]{
                Material.COCOA, Material.WATER, Material.LAVA, Material.AIR, Material.CAVE_AIR, Material.VOID_AIR,
                Material.RED_MUSHROOM, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM});
        LUMBER_ALLOWLIST = b.build();
    }
    
    @Override
    public Builder<Lumber> defaults() {
        return new Builder<>(Lumber::new, ID)
            .maxLevel(1)
            .loreName("Lumber")
            .probability(0)
            .enchantable(new Tool[]{AXE})
            .conflicting()
            .description("Breaks the entire tree at once")
            .cooldown(0)
            .power(-1.0)
            .handUse(Hand.LEFT);


    }

    @Override
    public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
        if (!evt.getPlayer().isSneaking()) {
            return false;
        }
        Block startBlock = evt.getBlock();
        
        if (!LUMBER_TRUNKS.contains(startBlock.getType())) {
            return false;
        }
        
        List<Block> blocks = Utilities.BFS(startBlock, MAX_BLOCKS, true, Float.MAX_VALUE, SEARCH_FACES, LUMBER_TRUNKS,
                LUMBER_ALLOWLIST, true, false);
        for (Block b : blocks) {
            ADAPTER.breakBlockNMS(b, evt.getPlayer());
        }
        return !blocks.isEmpty();
    }
}
