package zedly.zenchantments.enchantments;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import zedly.zenchantments.CustomEnchantment;
import zedly.zenchantments.Storage;
import zedly.zenchantments.enums.Hand;
import zedly.zenchantments.enums.Tool;
import zedly.zenchantments.util.Utilities;

import static org.bukkit.potion.PotionEffectType.FAST_DIGGING;
import static zedly.zenchantments.enums.Tool.*;

public class Haste extends CustomEnchantment {

    public static final int ID = 27;

    @Override
    public Builder<Haste> defaults() {
        return new Builder<>(Haste::new, ID)
            .maxLevel(4)
            .loreName("Haste")
            .probability(0)
            .enchantable(new Tool[]{PICKAXE, AXE, SHOVEL})
            .conflicting()
            .description("Gives the player a mining boost")
            .cooldown(0)
            .power(1.0)
            .handUse(Hand.NONE);
    }

    @Override
    public boolean onScanHands(Player player, int level, boolean usedHand) {
        Utilities.addPotion(player, FAST_DIGGING, 610, (int) Math.round(level * power));
        player.setMetadata("ze.haste", new FixedMetadataValue(Storage.zenchantments, System.currentTimeMillis()));
        return false;
    }

}
