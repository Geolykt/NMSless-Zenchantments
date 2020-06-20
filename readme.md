# Zenchantments
## Description
Zenchantments is a custom enchantment plugin that adds 70+ new enchantments to the game, covering a multitude of different uses. These include target-tracing arrows, lumber axes, block-breaking lasers, and much more. These custom enchantments are obtained through the normal enchantment process and act like regular enchantments, capable of being combined and merged. The plugin requires no client-side mods or resource packs. A comprehensive configuration file enables fine-tuning of individual enchantments to tailor them to every server's gameplay. This specific repository tries to create a more stable version of Zenchantments

## Download
See [Releases](https://github.com/Zedly/Zenchantments/releases) for downloads

## Compile
To compile the entire project yourself, you need multiple versions of CraftBukkit as Maven repositories. These are created automatically when you use [BuildTools](https://www.spigotmc.org/wiki/buildtools/) to obtain CB and/or Spigot. If you are making a private build and only need support for one server version, you can easily add and remove compatibility adapters by editing the parent POM and a switch in PlayerInteractUtil.

## Compatibility
The current version of this plugin is fully compatible with CraftBukkit and Spigot versions 1.13 - 1.15.2. Keep in mind that currently the Plugin is only tested with 1.15.2, in case you want stabillity in older versions, use the Zedly's Zenchantments. 1.16 is **not** supported as of now, but watch this repo in case you want to get notified when it is!

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
</ul>
