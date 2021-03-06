package net.mcreator.mctoolkitfusion.procedures;

@MctoolkitFusionModElements.ModElement.Tag
public class MagmaCreatureSpawningProcedure extends MctoolkitFusionModElements.ModElement {

	public MagmaCreatureSpawningProcedure(MctoolkitFusionModElements instance) {
		super(instance, 217);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MctoolkitFusionMod.LOGGER.warn("Failed to load dependency x for procedure MagmaCreatureSpawning!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MctoolkitFusionMod.LOGGER.warn("Failed to load dependency y for procedure MagmaCreatureSpawning!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MctoolkitFusionMod.LOGGER.warn("Failed to load dependency z for procedure MagmaCreatureSpawning!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MctoolkitFusionMod.LOGGER.warn("Failed to load dependency world for procedure MagmaCreatureSpawning!");
			return false;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()))
				|| ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.MAGMA_BLOCK.getDefaultState()
						.getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.POLISHED_BASALT
								.getDefaultState().getBlock()))
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BASALT.getDefaultState()
								.getBlock())))) {
			return (true);
		}
		return (false);

	}

}
