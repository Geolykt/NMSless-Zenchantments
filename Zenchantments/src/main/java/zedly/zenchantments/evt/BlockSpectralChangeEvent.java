package zedly.zenchantments.evt;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import zedly.zenchantments.enchantments.Spectral;

public class BlockSpectralChangeEvent extends BlockBreakEvent  {

    public BlockSpectralChangeEvent(Block theBlock, Player player) {
        super(theBlock, player);
        if (!Spectral.performWorldProtection) {
            throw new IllegalStateException("A BlockSpectralChangeEvent was constructed but World protection for Spectral is turned off");
        }
    }
}
