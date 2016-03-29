/*
 * Copyright 2015-2016 inventivetalent. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and contributors and should not be interpreted as representing official policies,
 *  either expressed or implied, of anybody else.
 */

package de.inventivegames.particle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @deprecated Please use {@link org.inventivetalent.particle.ParticleEffect} to get support for 1.9+ Particles
 */
@Deprecated
public enum ParticleEffect {

	// == Support for 1.7 Implementation ==
	HUGE_EXPLOSION("hugeexplosion", "EXPLOSION_HUGE"),
	LARGE_EXPLODE("largeexplode", "EXPLOSION_LARGE"),
	BUBBLE("bubble", "WATER_BUBBLE"),
	SUSPEND("suspended", "SUSPENDED"),
	DEPTH_SUSPEND("depthsuspend", "SUSPENDED_DEPTH"),
	MAGIC_CRIT("magicCrit", "CRIT_MAGIC"),
	MOB_SPELL("mobSpell", "SPELL_MOB", true),
	MOB_SPELL_AMBIENT("mobSpellAmbient", "SPELL_MOB_AMBIENT"),
	INSTANT_SPELL("instantSpell", "SPELL_INSTANT"),
	WITCH_MAGIC("witchMagic", "SPELL_WITCH"),
	EXPLODE("explode", "EXPLOSION_NORMAL"),
	SPLASH("splash", "WATER_SPLASH"),
	LARGE_SMOKE("largesmoke", "SMOKE_LARGE"),
	/**
	 * - Colored
	 */
	RED_DUST("reddust", "REDSTONE", true),
	SNOWBALL_POOF("snowballpoof", "SNOWBALL"),
	ANGRY_VILLAGER("angryVillager", "VILLAGER_ANGRY"),
	HAPPY_VILLAGER("happyVillager", "VILLAGER_HAPPY"),
	// == 1.8 Particles and Supported 1.7 Particles ==
	/**
	 * @see {@link #EXPLODE}
	 */
	EXPLOSION_NORMAL(EXPLODE.getName()),
	/**
	 * @see {@link #LARGE_EXPLODE}
	 */
	EXPLOSION_LARGE(LARGE_EXPLODE.getName()),
	/**
	 * 1.8 only!
	 *
	 * @see {@link #HUGE_EXPLOSION}
	 */
	EXPLOSION_HUGE(HUGE_EXPLOSION.getName()),
	FIREWORKS_SPARK("fireworksSpark"),
	/**
	 * @see {@link #BUBBLE}
	 */
	WATER_BUBBLE(BUBBLE.getName()),
	/**
	 * @see {@link #SPLASH}
	 */
	WATER_SPLASH(SPLASH.getName()),
	/**
	 * 1.8 only
	 */
	WATER_WAKE("wake"),
	/**
	 * @see {@link #SUSPEND}
	 */
	SUSPENDED(SUSPEND.getName()),
	/**
	 * @see {@link #DEPTH_SUSPEND}
	 */
	SUSPENDED_DEPTH(DEPTH_SUSPEND.getName()),
	CRIT("crit"),
	/**
	 * @see {@link #MAGIC_CRIT}
	 */
	CRIT_MAGIC(MAGIC_CRIT.getName()),
	/**
	 * 1.8 only!
	 */
	SMOKE_NORMAL("smoke"),
	/**
	 * @see {@link #LARGE_SMOKE}
	 */
	SMOKE_LARGE(LARGE_SMOKE.getName()),
	SPELL("spell"),
	/**
	 * @see {@link #INSTANT_SPELL}
	 */
	SPELL_INSTANT(INSTANT_SPELL.getName()),
	/**
	 * - Colored
	 *
	 * @see {@link #MOB_SPELL}
	 */
	SPELL_MOB(MOB_SPELL.getName(), true),
	/**
	 * @see {@link #MOB_SPELL_AMBIENT}
	 */
	SPELL_MOB_AMBIENT(MOB_SPELL_AMBIENT.getName()),
	/**
	 * @see {@link #WITCH_MAGIC}
	 */
	SPELL_WITCH(WITCH_MAGIC.getName()),
	DRIP_WATER("dripWater"),
	DRIP_LAVA("dripLava"),
	/**
	 * @see {@link #ANGRY_VILLAGER}
	 */
	VILLAGER_ANGRY(ANGRY_VILLAGER.getName()),
	/**
	 * @see {@link #HAPPY_VILLAGER}
	 */
	VILLAGER_HAPPY(HAPPY_VILLAGER.getName()),
	TOWN_AURA("townaura"),
	/**
	 * - Colored (Notes can be colored, but they're not fully implemented yet)
	 */
	NOTE("note", true),
	PORTAL("portal"),
	ENCHANTMENT_TABLE("enchantmenttable"),
	FLAME("flame"),
	LAVA("lava"),
	FOOTSTEP("footstep"),
	CLOUD("cloud"),
	REDSTONE("reddust", true),
	SNOWBALL("snowballpoof"),
	SNOW_SHOVEL("snowshovel"),
	SLIME("slime"),
	HEART("heart"),
	/**
	 * 1.8 only!
	 */
	BARRIER("barrier"),
	/**
	 * 1.8 only!
	 */
	ITEM_CRACK("iconcrack_"),
	/**
	 * 1.8 only!
	 */
	BLOCK_CRACK("blockcrack_"),
	/**
	 * 1.8 only!
	 */
	BLOCK_DUST("blockdust_"),
	/**
	 * 1.8 only!
	 */
	WATER_DROP("droplet"),
	/**
	 * 1.8 only!
	 */
	ITEM_TAKE("take"),
	/**
	 * 1.8 only!
	 */
	MOB_APPEARANCE("mobappearance");

	private String particleName;
	private String enumValue;
	private boolean hasColor;

	ParticleEffect(String particleName, String enumValue, boolean hasColor) {
		this.particleName = particleName;
		this.enumValue = enumValue;
		this.hasColor = hasColor;
	}

	ParticleEffect(String particleName, String enumValue) {
		this(particleName, enumValue, false);
	}

	ParticleEffect(String particleName) {
		this(particleName, null);
	}

	ParticleEffect(String particleName, boolean hasColor) {
		this(particleName, null, hasColor);
	}

	public String getName() {
		return this.particleName;
	}

	public boolean hasColor() {
		return hasColor;
	}

	private static Class<?> nmsPacketPlayOutParticle = ReflectionUtilities.getNMSClass("PacketPlayOutWorldParticles");
	private static Class<?> nmsEnumParticle;
	private static int particleRange = 25;

	/**
	 * Modify the maximum Range of particles (only useful for Client versions 1.8+)
	 *
	 * @param range New range
	 * @deprecated Methods with the 'force' argument should be used
	 */
	@Deprecated
	public static void setRange(int range) {
		if (range < 0) { throw new IllegalArgumentException("Range must be positive!"); }
		particleRange = range;
	}

	/**
	 * @return The current maximum Range of particles
	 * @deprecated Methods with the 'force' argument should be used
	 */
	@Deprecated
	public static int getRange() {
		return particleRange;
	}

	/**
	 * Send the particle to a specific Player
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @param extra    Extra arguments (block id, data)
	 */
	@Deprecated
	private void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count, int... extra) throws Exception {
		sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, false, extra);
	}

	/**
	 * Send the particle to a specific Player
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @param extra    Extra arguments (block id, data)
	 * @param force    If the distance to the receiving player should be ignored
	 */
	private void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force, int... extra) throws Exception {
		if (!force && !isPlayerInRange(player, location)) { return; }
		if (ReflectionUtilities.getVersion().contains("v1_8")) {
			try {
				if (nmsEnumParticle == null) {
					nmsEnumParticle = ReflectionUtilities.getNMSClass("EnumParticle");
				}
				if (this == BLOCK_CRACK) {
					int id = 0;
					int data = 0;
					if (extra.length > 0) {
						id = extra[0];
					}
					if (extra.length > 1) {
						data = extra[1];
					}
					extra = new int[] {
							id,
							id | data << 12 };
				}
				Object packet = nmsPacketPlayOutParticle.getConstructor(new Class[] {
						nmsEnumParticle,
						boolean.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						int.class,
						int[].class }).newInstance(getEnum(nmsEnumParticle.getName() + "." + (this.enumValue != null ? this.enumValue : this.name().toUpperCase())), true, (float) location.getX(), (float) location.getY(), (float) location.getZ(), offsetX, offsetY, offsetZ, speed, count, extra);
				Object handle = ReflectionUtilities.getHandle(player);
				Object connection = ReflectionUtilities.getField(handle.getClass(), "playerConnection").get(handle);
				ReflectionUtilities.getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
			} catch (Exception e) {
				// throw new IllegalArgumentException("Unable to send Particle " + name() + ". (Version 1.8): " + e.getMessage());
				throw e;
			}
		} else {
			try {
				if (this.particleName == null) {
					this.particleName = this.name().toLowerCase();
				}
				String name = this.particleName;
				if (this == BLOCK_CRACK || this == ITEM_CRACK || this == BLOCK_DUST) {
					int id = 0;
					int data = 0;
					if (extra.length > 0) {
						id = extra[0];
					}
					if (extra.length > 1) {
						data = extra[1];
					}
					name += id + "_" + data;
				}
				Object packet = nmsPacketPlayOutParticle.getConstructor(new Class[] {
						String.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						float.class,
						int.class }).newInstance(name, (float) location.getX(), (float) location.getY(), (float) location.getZ(), offsetX, offsetY, offsetZ, speed, count);
				Object handle = ReflectionUtilities.getHandle(player);
				Object connection = ReflectionUtilities.getField(handle.getClass(), "playerConnection").get(handle);
				ReflectionUtilities.getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
			} catch (Exception e) {
				// throw new IllegalArgumentException("Unable to send Particle " + name() + ". (Server Version: 1.7) " + e.getMessage());
				throw e;
			}
		}
	}

	/**
	 * Send the particle to a specific Player
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, force, new int[0]);
	}

	/**
	 * Send the particle to a specific Player
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, false);
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendToPlayers(Collection<? extends Player> players, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		for (Player p : players) {
			this.sendToPlayer(p, location, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	public void sendToPlayers(Collection<? extends Player> players, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		for (Player p : players) {
			this.sendToPlayer(p, location, offsetX, offsetY, offsetZ, speed, count, force);
		}
	}

	/**
	 * Send the particle to an Array of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendToPlayers(Player[] players, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		for (Player p : players) {
			this.sendToPlayer(p, location, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	// Color methods

	/**
	 * Send the particle to a player with the specified color (e.g. reddust)
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Player p, Location location, org.bukkit.Color color) throws Exception {
		if (!this.hasColor) { return; }
		this.sendToPlayer(p, location, this.getColor(color.getRed()), this.getColor(color.getGreen()), this.getColor(color.getBlue()), 1, 0);
	}

	/**
	 * Send the particle to a player with the specified color (e.g. reddust)
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	public void sendColor(Player p, Location location, org.bukkit.Color color, boolean force) throws Exception {
		if (!this.hasColor) { return; }
		this.sendToPlayer(p, location, this.getColor(color.getRed()), this.getColor(color.getGreen()), this.getColor(color.getBlue()), 1, 0, force);
	}

	/**
	 * Send the particle to a player with the specified color (e.g. reddust)
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Player p, Location location, java.awt.Color color) throws Exception {
		if (!this.hasColor) { return; }
		this.sendToPlayer(p, location, this.getColor(color.getRed()), this.getColor(color.getGreen()), this.getColor(color.getBlue()), 1, 0);
	}

	/**
	 * Send the particle to a player with the specified color (e.g. reddust)
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	public void sendColor(Player p, Location location, java.awt.Color color, boolean force) throws Exception {
		if (!this.hasColor) { return; }
		this.sendToPlayer(p, location, this.getColor(color.getRed()), this.getColor(color.getGreen()), this.getColor(color.getBlue()), 1, 0, force);
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Collection<? extends Player> players, Location location, java.awt.Color color) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color);
		}
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	public void sendColor(Collection<? extends Player> players, Location location, java.awt.Color color, boolean force) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color, force);
		}
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	public void sendColor(Collection<? extends Player> players, Location location, org.bukkit.Color color) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color);
		}
	}

	/**
	 * Send the particle to a Collection of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Collection<? extends Player> players, Location location, org.bukkit.Color color, boolean force) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color, force);
		}
	}

	/**
	 * Send the particle to an Array of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Player[] players, Location location, org.bukkit.Color color) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color);
		}
	}

	/**
	 * Send the particle to an Array of Players {@link #sendToPlayer(Player, Location, float, float, float, float, int)}
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param color    Color of the particle
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 */
	@Deprecated
	public void sendColor(Player[] players, Location location, java.awt.Color color) throws Exception {
		if (!this.hasColor) { return; }
		for (Player p : players) {
			this.sendColor(p, location, color);
		}
	}

	protected float getColor(float value) {
		if (value <= 0) {
			value = -1;
		}
		return value / 255;
	}

	// BLOCK_CRACK

	/**
	 * Send the BLOCK_BREAK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockCrack(Player player, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_CRACK) { throw new IllegalArgumentException("This method is only available for BLOCK_CRACK!"); }
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, id, data);
	}

	/**
	 * Send the BLOCK_BREAK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendBlockCrack(Player player, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != BLOCK_CRACK) { throw new IllegalArgumentException("This method is only available for BLOCK_CRACK!"); }
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, force, id, data);
	}

	/**
	 * Send the BLOCK_BREAK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockCrack(Collection<? extends Player> players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_CRACK) { throw new IllegalArgumentException("This method is only available for BLOCK_CRACK!"); }
		for (Player p : players) {
			this.sendBlockCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	/**
	 * Send the BLOCK_BREAK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendBlockCrack(Collection<? extends Player> players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != BLOCK_CRACK) { throw new IllegalArgumentException("This method is only available for BLOCK_CRACK!"); }
		for (Player p : players) {
			this.sendBlockCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count, force);
		}
	}

	/**
	 * Send the BLOCK_BREAK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockCrack(Player[] players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_CRACK) { throw new IllegalArgumentException("This method is only available for BLOCK_CRACK!"); }
		for (Player p : players) {
			this.sendBlockCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	// ITEM_CRACK

	/**
	 * Send the ITEM_CRACK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendItemCrack(Player player, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != ITEM_CRACK) { throw new IllegalArgumentException("This method is only available for ITEM_CRACK!"); }
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, id, data);
	}

	/**
	 * Send the ITEM_CRACK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendItemCrack(Player player, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != ITEM_CRACK) { throw new IllegalArgumentException("This method is only available for ITEM_CRACK!"); }
		this.sendToPlayer(player, location, offsetX, offsetY, offsetZ, speed, count, force, id, data);
	}

	/**
	 * Send the ITEM_CRACK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendItemCrack(Collection<? extends Player> players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != ITEM_CRACK) { throw new IllegalArgumentException("This method is only available for ITEM_CRACK!"); }
		for (Player p : players) {
			this.sendItemCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	/**
	 * Send the ITEM_CRACK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendItemCrack(Collection<? extends Player> players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != ITEM_CRACK) { throw new IllegalArgumentException("This method is only available for ITEM_CRACK!"); }
		for (Player p : players) {
			this.sendItemCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count, force);
		}
	}

	/**
	 * Send the ITEM_CRACK particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param data     Block data
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendItemCrack(Player[] players, Location location, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != ITEM_CRACK) { throw new IllegalArgumentException("This method is only available for ITEM_CRACK!"); }
		for (Player p : players) {
			this.sendItemCrack(p, location, id, data, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	// BLOCK_DUST

	/**
	 * Send the BLOCK_DUST particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockDust(Player p, Location location, int id, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_DUST) { throw new IllegalArgumentException("This method is only available for BLOCK_DUST!"); }
		this.sendToPlayer(p, location, offsetX, offsetY, offsetZ, speed, count, id);
	}

	/**
	 * Send the BLOCK_DUST particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendBlockDust(Player p, Location location, int id, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != BLOCK_DUST) { throw new IllegalArgumentException("This method is only available for BLOCK_DUST!"); }
		this.sendToPlayer(p, location, offsetX, offsetY, offsetZ, speed, count, force, id);
	}

	/**
	 * Send the BLOCK_DUST particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockDust(Collection<? extends Player> players, Location location, int id, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_DUST) { throw new IllegalArgumentException("This method is only available for BLOCK_DUST!"); }
		for (Player p : players) {
			this.sendBlockDust(p, location, id, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	/**
	 * Send the BLOCK_DUST particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	public void sendBlockDust(Collection<? extends Player> players, Location location, int id, float offsetX, float offsetY, float offsetZ, float speed, int count, boolean force) throws Exception {
		if (this != BLOCK_DUST) { throw new IllegalArgumentException("This method is only available for BLOCK_DUST!"); }
		for (Player p : players) {
			this.sendBlockDust(p, location, id, offsetX, offsetY, offsetZ, speed, count, force);
		}
	}

	/**
	 * Send the BLOCK_DUST particle
	 *
	 * @param player   Receiver of the particle
	 * @param location Location of the particle
	 * @param id       Block id
	 * @param offsetX  X size of the area to spawn particles in.
	 * @param offsetY  Y size of the area to spawn particles in.
	 * @param offsetZ  Z size of the area to spawn particles in.
	 * @param speed    Speed of the Particle
	 * @param count    Number of spawned particles
	 * @throws Exception
	 */
	@Deprecated
	public void sendBlockDust(Player[] players, Location location, int id, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		if (this != BLOCK_DUST) { throw new IllegalArgumentException("This method is only available for BLOCK_DUST!"); }
		for (Player p : players) {
			this.sendBlockDust(p, location, id, offsetX, offsetY, offsetZ, speed, count);
		}
	}

	// Reflection

	private static Class<?> nmsPlayerConnection;
	private static Class<?> nmsEntityPlayer;
	private static Class<?> ioNettyChannel;
	private static Method   nmsNetworkGetVersion;

	private static Field nmsFieldPlayerConnection;
	private static Field nmsFieldNetworkManager;
	private static Field nmsFieldNetworkManagerI;
	private static Field nmsFieldNetworkManagerM;

	protected static int getVersion(Player p) {
		try {
			final Object handle = ReflectionUtilities.getHandle(p);
			final Object connection = nmsFieldPlayerConnection.get(handle);
			final Object network = nmsFieldNetworkManager.get(connection);
			final Object channel;
			if (ReflectionUtilities.getVersion().contains("1_7")) {
				channel = nmsFieldNetworkManagerM.get(network);
			} else {
				channel = nmsFieldNetworkManagerI.get(network);
			}
			final Object version = ReflectionUtilities.getVersion().contains("1_7") ? nmsNetworkGetVersion.invoke(network, channel) : 47;
			return (int) version;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	static {
		String ver = ReflectionUtilities.getVersion();
		try {
			nmsPlayerConnection = ReflectionUtilities.getNMSClass("PlayerConnection");
			nmsEntityPlayer = ReflectionUtilities.getNMSClass("EntityPlayer");
			ioNettyChannel = ver.contains("1_7") ? Class.forName("net.minecraft.util.io.netty.channel.Channel") : Class.forName("io.netty.channel.Channel");

			nmsFieldPlayerConnection = ReflectionUtilities.getField(nmsEntityPlayer, "playerConnection");
			nmsFieldNetworkManager = ReflectionUtilities.getField(nmsPlayerConnection, "networkManager");
			nmsFieldNetworkManagerI = ReflectionUtilities.getField(nmsFieldNetworkManager.getType(), "i");
			nmsFieldNetworkManagerM = ReflectionUtilities.getField(nmsFieldNetworkManager.getType(), "m");

			nmsNetworkGetVersion = ReflectionUtilities.getMethod(nmsFieldNetworkManager.getType(), "getVersion", ioNettyChannel);

		} catch (Exception e) {
			System.err.println("[ParticleLIB] Error while loading: " + e.getMessage());
			e.printStackTrace(System.err);
			Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("ParticleLIB"));
		}
	}

	@SuppressWarnings({
			"unchecked",
			"rawtypes" })
	private static Enum<?> getEnum(String enumFullName) {
		String[] x = enumFullName.split("\\.(?=[^\\.]+$)");
		if (x.length == 2) {
			String enumClassName = x[0];
			String enumName = x[1];
			try {
				Class<Enum> cl = (Class<Enum>) Class.forName(enumClassName);
				return Enum.valueOf(cl, enumName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean isPlayerInRange(Player p, Location center) {
		double distance = 0;
		if (!p.getLocation().getWorld().equals(center.getWorld())) { return false; }
		if ((distance = center.distanceSquared(p.getLocation())) > Double.MAX_VALUE) { return false; }
		return distance < particleRange * particleRange;
	}

	public static class ReflectionUtilities {

		/**
		 * sets a value of an {@link Object} via reflection
		 *
		 * @param instance  instance the class to use
		 * @param fieldName the name of the {@link Field} to modify
		 * @param value     the value to set
		 * @throws Exception
		 */
		public static void setValue(Object instance, String fieldName, Object value) throws Exception {
			Field field = instance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(instance, value);
		}

		/**
		 * get a value of an {@link Object}'s {@link Field}
		 *
		 * @param instance  the target {@link Object}
		 * @param fieldName name of the {@link Field}
		 * @return the value of {@link Object} instance's {@link Field} with the name of fieldName
		 * @throws Exception
		 */
		public static Object getValue(Object instance, String fieldName) throws Exception {
			Field field = instance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(instance);
		}

		public static String getVersion() {
			String name = Bukkit.getServer().getClass().getPackage().getName();
			String version = name.substring(name.lastIndexOf('.') + 1) + ".";
			return version;
		}

		public static Class<?> getNMSClass(String className) {
			String fullName = "net.minecraft.server." + getVersion() + className;
			Class<?> clazz = null;
			try {
				clazz = Class.forName(fullName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return clazz;
		}

		public static Class<?> getOBCClass(String className) {
			String fullName = "org.bukkit.craftbukkit." + getVersion() + className;
			Class<?> clazz = null;
			try {
				clazz = Class.forName(fullName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return clazz;
		}

		public static Object getHandle(Object obj) {
			try {
				return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public static Field getField(Class<?> clazz, String name) {
			try {
				Field field = clazz.getDeclaredField(name);
				field.setAccessible(true);
				return field;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public static Method getMethod(Class<?> clazz, String name, Class<?>... args) {
			for (Method m : clazz.getMethods()) {
				if (m.getName().equals(name) && (args.length == 0 || ClassListEqual(args, m.getParameterTypes()))) {
					m.setAccessible(true);
					return m;
				}
			}
			return null;
		}

		public static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
			boolean equal = true;
			if (l1.length != l2.length) { return false; }
			for (int i = 0; i < l1.length; i++) {
				if (l1[i] != l2[i]) {
					equal = false;
					break;
				}
			}
			return equal;
		}
	}
}
