This fork only supports 1.16.1 and newer versions when the time comes

# Zenchantments
## Description
Zenchantments is a custom enchantment plugin that adds 70+ new enchantments to the game, covering a multitude of different uses. These include target-tracing arrows, lumber axes, block-breaking lasers, and much more. These custom enchantments are obtained through the normal enchantment process and act like regular enchantments, capable of being combined and merged. The plugin requires no client-side mods or resource packs. A comprehensive configuration file enables fine-tuning of individual enchantments to tailor them to every server's gameplay. This specific repository tries to create a more stable version of Zenchantments

## Download
See [Releases](https://github.com/Zedly/Zenchantments/releases) for downloads

## Compile
Compile this project like every other project out there

## Compatibility
The current version of this plugin is fully compatible with Spigot version 1.16.1. Any versions under 1.16.1, will **not** work, versions above, may, although with a few issues. Note that 1.16.1 support is still pretty new and does not work fully as of now.
## Contribute
Anyone is free to contribute to this repository, however keep in mind that this (and parent) repository uses 4 space indentation.

## Changes done in this fork
<ul>
	<li>Various minor performance boosts</li>
	<li>A lot of whitespace changes; this repo is 100% 4-space indented</li>
	<li>Patched a bug where blue ice blocks and soulsand blocks placed by the frozenstep and netherstep enchantemnts can be moved or removed; can be toggled</li>
	<li>Patched a bug where the fire enchantment would work even when the player shouldn't be able to destroy a block</li>
	<li>Patched a bug which would result in the abillity of changing blockstates in protected regions, for example via Towny or World guard; can be toggled</li>
	<li>Removed unused variables and methods</li>
	<li>General reduction of warnings</li>
	<li>Removed NMS</li>
	<li>1.16.1 Compatible</li>
</ul>
