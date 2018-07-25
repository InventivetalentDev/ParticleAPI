package org.inventivetalent.particle;

import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.commons.lang.reflect.MethodUtils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bukkit/Minecraft version related utilities.
 */
public enum BukkitVersion {
	UNKNOWN,
	v1_7_R1,
	v1_7_R2,
	v1_7_R3,
	v1_7_R4,
	v1_8_R1,
	v1_8_R2,
	v1_8_R3,
	v1_9_R1,
	v1_9_R2,
	v1_10_R1,
	v1_11_R1,
	v1_12_R1,
	v1_13_R1;

	private static BukkitVersion currentVersion;

	static {
		currentVersion = Optional.ofNullable(getNMSVersion())
				.map(version -> {
					try {
						return BukkitVersion.valueOf(version);
					} catch (IllegalArgumentException e) {
						return null;
					}
				})
				.orElse(UNKNOWN);
	}

	public static BukkitVersion getCurrentVersion() {
		return currentVersion;
	}

	public static boolean isAtLeast(BukkitVersion other) {
		return getCurrentVersion().ordinal() >= other.ordinal();
	}

	public static boolean isBetweenOrEqual(BukkitVersion first, BukkitVersion second) {
		return isAtLeast(first) && getCurrentVersion().ordinal() <= second.ordinal();
	}

	public static Class<?> resolveNMSVanillaClass(String className) {
		try {
			return Class.forName("net.minecraft.server." + currentVersion.name() + "." + className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Class<?> resolveNMSBukkitClass(String className) {
		try {
			return Class.forName("org.bukkit.craftbukkit." + currentVersion.name() + "." + className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static int getItemId(ItemStack itemStack) {
		if (isAtLeast(BukkitVersion.v1_13_R1)) {
			try {
				Object vanillaItemStack = FieldUtils.readField(itemStack, "handle", true);
				Object vanillaItem = FieldUtils.readField(vanillaItemStack, "item", true);
				Class<?> Item = BukkitVersion.resolveNMSVanillaClass("Item");
				return (int) MethodUtils.invokeStaticMethod(Item, "getId", vanillaItem);
			} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				throw new IllegalStateException(e);
			}
		} else {
			try {
				return (int) MethodUtils.invokeMethod(itemStack, "getTypeId", null);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	/**
	 * This method returns the current NMS version code.
	 * Compatible with CraftBukkit/Spigot and MCPC+/Cauldron.
	 * Example: v1_8_R1
	 *
	 * @return the NMS package part or null if not found.
	 */
	private static String getNMSVersion() {
		String version = getBukkitVersion();
		if (version == null) {
			// Caused by MCPC+/Cauldron renaming packages, extract the version from Bukkit.getVersion().
			String serverVersion = getMinecraftVersion();
			if ("1.7.2".equals(serverVersion)) {
				version = "v1_7_R1";
			} else if ("1.7.5".equals(serverVersion)) {
				version = "v1_7_R2";
			} else if ("1.7.8".equals(serverVersion)) {
				version = "v1_7_R3";
			} else if ("1.7.10".equals(serverVersion)) {
				version = "v1_7_R4";
			} else if ("1.8".equals(serverVersion)) {
				version = "v1_8_R1";
			} else if ("1.8.3".equals(serverVersion)) {
				version = "v1_8_R2";
			}
		}
		return version;
	}

	/**
	 * This method uses a regex to getCurrent the NMS package part that changes with every update.
	 * Example: v1_8_R1
	 *
	 * @return the NMS package part or null if not found.
	 */
	private static String getBukkitVersion() {
		Matcher matcher = Pattern.compile("v\\d+_\\d+_R\\d+").matcher(Bukkit.getServer().getClass().getPackage().getName());
		return matcher.find() ? matcher.group() : null;
	}

	/**
	 * This method uses a regex to getCurrent the version of this Minecraft release.
	 * Example: 1.8.1
	 *
	 * @return the version of this release or null if not found.
	 */
	private static String getMinecraftVersion() {
		Matcher matcher = Pattern.compile("(\\(MC: )([\\d.]+)(\\))").matcher(Bukkit.getVersion());
		return matcher.find() ? matcher.group(2) : null;
	}
}
