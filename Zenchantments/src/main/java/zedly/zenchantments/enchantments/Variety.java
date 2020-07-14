package zedly.zenchantments.enchantments;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import zedly.zenchantments.CustomEnchantment;
import zedly.zenchantments.Storage;
import zedly.zenchantments.enums.Hand;
import zedly.zenchantments.enums.Tool;
import zedly.zenchantments.util.Utilities;

import static org.bukkit.Material.*;
import static zedly.zenchantments.enums.Tool.AXE;

public class Variety extends CustomEnchantment {

    public static final int ID = 65;

    @Override
    public Builder<Variety> defaults() {
        return new Builder<>(Variety::new, ID)
            .maxLevel(1)
            .loreName("Variety")
            .probability(0)
            .enchantable(new Tool[]{AXE})
            .conflicting(Fire.class)
            .description("Drops random types of wood or leaves")
            .cooldown(0)
            .power(-1.0)
            .handUse(Hand.LEFT);
    }

    @Override
    public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
        Material mat = evt.getBlock().getType();
        if (Tag.LOGS.isTagged(mat)) {
            evt.getBlock().setType(AIR);
            evt.getBlock().getWorld()
               .dropItemNaturally(evt.getBlock().getLocation(),
                   new ItemStack(Tag.LOGS.getValues().toArray(new Material[0])[Storage.rnd.nextInt(Tag.LOGS.getValues().size())]));
            Utilities.damageTool(evt.getPlayer(), 1, usedHand);
        } else if (Tag.LEAVES.isTagged(mat)) {
            evt.getBlock().setType(AIR);
            evt.getBlock().getWorld()
               .dropItemNaturally(evt.getBlock().getLocation(),
                   new ItemStack(Tag.LEAVES.getValues().toArray(new Material[0])[Storage.rnd.nextInt(Tag.LEAVES.getValues().size())]));
            Utilities.damageTool(evt.getPlayer(), 1, usedHand);
        }
        return true;
    }
}
