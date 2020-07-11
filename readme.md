Got a question? Need help or want to discuss changes? Then feel free to DM me via discord: tristellar#9022
<hr>
This fork uses NBT tags to store enchantments, which makes it somewhat uninterchangeable with the regular plugin
It also only intends to support 1.16.1 and newer versions when the time comes, older may work however with a bit of commit reverting

# NMSless-Zenchantments
## Description
Zenchantments is a custom enchantment plugin that adds 70+ new enchantments to the game, covering a multitude of different uses. These include target-tracing arrows, lumber axes, block-breaking lasers, and much more. These custom enchantments are obtained through the normal enchantment process and act like regular enchantments, capable of being combined and merged. The plugin requires no client-side mods or resource packs. A comprehensive configuration file enables fine-tuning of individual enchantments to tailor them to every server's gameplay. 
<br> This specific repository tries to create a more stable version of Zenchantments while also making it availiable for newer versions the partent repo doesn't support

## Download
See [Releases](https://github.com/Geolykt/NMSless-Zenchantments/releases) for downloads

## Compile
Compile this project like every other project out there

## Compatibility
The current version of this plugin is fully compatible with Spigot version 1.16.1. Any versions under 1.16.1, will **not** work without tinkering, versions above, may, although with a few issues. Note that 1.16.1 support is still pretty new and may have some issues right now, make sure to report them

## Contribute
Anyone is free to contribute to this repository via pull requests or comments, however keep in mind that this (and parent) repository uses 4 space indentation.

## Changes performed in this fork
<ul>
 <li>Major changes:
  <ul>
   <li>Removed NMS</li>
   <li>Using NBT tags to store enchantments other than invisble lore</li>
   <li>1.16.1 and upwards compatible</li>
  </ul>
 </li>
 <li>Minor changes:
  <ul>
   <li>Various minor performance boosts</li>
   <li>The fire and aborist enchantment no longer uses hardcoded recepies</li>
   <li>Command blocks and console now can use more commands</li>
   <li>Allow to target other players and using target modifiers in the enchantment command</li>
   <li>Added informative enchantment use events - cannot be cancelled as of yet</li>
  </ul>
 </li>
 <li>Patches:
  <ul>
   <li>Patched a bug where blue ice blocks and soulsand blocks placed by the frozenstep and netherstep enchantemnts can be moved or removed; can be toggled</li>
   <li>Patched a bug where the fire enchantment would work even when the player shouldn't be able to destroy a block</li>
   <li>Patched a bug which would result in the abillity of changing blockstates in protected regions, for example via Towny or World guard; can be toggled</li>
   <li>Patched a bug which would spam the console when the Weight enchantment is used</li>
   <li>Patched a bug which would result in a unbreaking 1 enchanted item, see https://github.com/Zedly/Zenchantments/issues/40</li>
  </ul>
 </li>
 <li>Code changes (doesn't affect behaviour as much):
  <ul>
   <li>A lot of whitespace changes; this repo is 100% 4-space indented</li>
   <li>Removed unused variables and methods</li>
   <li>General reduction of compiler warnings</li>
  </ul>
 </li>
</ul>
