package zedly.zenchantments.enchantments;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import zedly.zenchantments.CustomEnchantment;
import zedly.zenchantments.Storage;
import zedly.zenchantments.enums.Hand;
import zedly.zenchantments.enums.Tool;

import static org.bukkit.Material.*;
import static zedly.zenchantments.enums.Tool.AXE;

import java.util.ArrayList;

public class Arborist extends CustomEnchantment {

    public static final int ID = 2;
    public static boolean doGoldenAppleDrop = true;
    public static boolean useSoftcoded = true;

    @Override
    public Builder<Arborist> defaults() {
        return new Builder<>(Arborist::new, ID)
            .maxLevel(3)
            .loreName("Arborist")
            .probability(0)
            .enchantable(new Tool[]{AXE})
            .conflicting()
            .description("Drops more apples, sticks, and saplings when used on leaves")
            .cooldown(0)
            .power(1.0)
            .handUse(Hand.LEFT);
    }

    @Override
    public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
        Block blk = evt.getBlock();
        if (Storage.COMPATIBILITY_ADAPTER.Leaves().contains(blk.getType())) {
            if (!useSoftcoded) {
                return useHardcode(blk, level, usedHand);
            }
            ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
            for (int i = 0; i < level + 3; i++) {
                drops.addAll(blk.getDrops());
            }
            if (doGoldenAppleDrop && 
                    (Storage.rnd.nextInt(10000) <= (15 * (level+1) * power))) {
                drops.add(new ItemStack(GOLDEN_APPLE, 1));
            }
            boolean bol = false;
            for (ItemStack drop : drops) {
                bol = true;
                blk.getWorld().dropItemNaturally(blk.getLocation(), drop);
            }
            return bol;
        }
        return false;
    }
    
    private boolean useHardcode (Block blk, int level, boolean usedHand) {
            int index = Storage.COMPATIBILITY_ADAPTER.Leaves().indexOf(blk.getType());

            ItemStack stk = new ItemStack(Storage.COMPATIBILITY_ADAPTER.Saplings().get(index), 1);

            if (Storage.rnd.nextInt(10) >= (9 - level) / (power + .001)) {
                if (Storage.rnd.nextInt(3) % 3 == 0) {
                    blk.getWorld()
                       .dropItemNaturally(blk.getLocation(), stk);
                }
                if (Storage.rnd.nextInt(3) % 3 == 0) {
                    blk.getWorld()
                       .dropItemNaturally(blk.getLocation(), new ItemStack(STICK, 1));
                }
                if (Storage.rnd.nextInt(3) % 3 == 0) {
                    blk.getWorld()
                       .dropItemNaturally(blk.getLocation(), new ItemStack(APPLE, 1));
                }
                if (Storage.rnd.nextInt(65) == 25) {
                    blk.getWorld()
                       .dropItemNaturally(blk.getLocation(), new ItemStack(GOLDEN_APPLE, 1));
                }
                return true;
            }
        return false;
    }
}

